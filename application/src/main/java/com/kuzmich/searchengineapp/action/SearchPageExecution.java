package com.kuzmich.searchengineapp.action;

import com.kuzmich.searchengineapp.dto.searchDto.SearchPageData;
import com.kuzmich.searchengineapp.entity.Index;
import com.kuzmich.searchengineapp.entity.Lemma;
import com.kuzmich.searchengineapp.entity.Page;
import com.kuzmich.searchengineapp.entity.Site;
import com.kuzmich.searchengineapp.repository.IndexRepository;
import com.kuzmich.searchengineapp.repository.LemmaRepository;
import com.kuzmich.searchengineapp.repository.PageRepository;
import com.kuzmich.searchengineapp.repository.SiteRepository;
import lombok.RequiredArgsConstructor;
import org.apache.lucene.morphology.LuceneMorphology;

import lombok.extern.log4j.Log4j2;
import org.apache.lucene.morphology.russian.RussianLuceneMorphology;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Log4j2
@Component
@RequiredArgsConstructor
public class SearchPageExecution {
    private final LemmaRepository lemmaRepository;
    private final IndexRepository indexRepository;
    private final PageRepository pageRepository;
    private final SiteRepository siteRepository;


    public List<SearchPageData> getSearchResultListFromUserQuery(String userQuery, String siteUrl) {
        try {
            List<Lemma> lemmaObjectListFromUserQuery = findLemmasByWordsFromUserQuery(userQuery);
            if (!lemmaObjectListFromUserQuery.isEmpty()) {
                List<Site> siteList = (siteUrl == null)
                        ? lemmaObjectListFromUserQuery.stream()
                                                        .map(Lemma::getSite)
                                                        .distinct()
                                                        .collect(Collectors.toList())
                        : siteRepository.findSiteBySiteUrl(siteUrl);
                List<Index> globalIndexList = new ArrayList<>();
                for (Site site : siteList) {
                    List<Lemma> lemmaListBySite = lemmaObjectListFromUserQuery.stream()
                            .filter(lemma -> lemma.getSite().getId() == site.getId())
                            .collect(Collectors.toList());
                    List<Index> indexListBySite = indexRepository.findAllByLemmaId(lemmaListBySite.get(0).getId()).get();
                    for (int i = 1; i < lemmaListBySite.size(); i++) {
                        int position = i;
                        indexListBySite.removeIf(index -> index.getLemma().getLemma().equals(lemmaListBySite.get(position).getLemma()));
                    }
                    globalIndexList.addAll(indexListBySite);
                }
                if (!globalIndexList.isEmpty()) {
                    return getSearchDataFromIndexes(globalIndexList, lemmaObjectListFromUserQuery);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    private List<SearchPageData> getSearchDataFromIndexes(List<Index> indexList, List<Lemma> lemmaObjectListFromUserQuery) throws IOException {
        long startMethod = System.currentTimeMillis() / 1_000;
        List<SearchPageData> resultList = new ArrayList<>();
        for (Index index : indexList) {
            long startIndex = System.currentTimeMillis() / 1000;
            int pageId = index.getPage().getId();
            Page page = pageRepository.findById(pageId).orElseThrow(() -> new RuntimeException("Page not found"));
            String siteName = page.getSite().getName();
            String siteUrl = page.getSite().getUrl();
            String pageUri = page.getPath();
            String pageTitle = Jsoup.parse(page.getContent()).title();
            Element elementBody = Jsoup.parse(page.getContent()).body();
            log.info("id {}, url {}, page title {}", pageId, pageUri, pageTitle);
            String pageSnippetByUserQuery = createSnippetFromPage(lemmaObjectListFromUserQuery, elementBody);
            float sumRank = 0;
            for (Lemma lemma : lemmaObjectListFromUserQuery) {
                Optional<Index> indexOptional = indexRepository.findLemmaRankFromIndex(pageId, lemma.getId());
                if (indexOptional.isPresent()) {
                    sumRank += indexOptional.get().getRank();
                }
            }
            SearchPageData searchPageData = SearchPageData
                    .builder()
                    .site(siteUrl)
                    .siteName(siteName)
                    .uri(pageUri)
                    .title(pageTitle)
                    .snippet(pageSnippetByUserQuery)
                    .relevance(sumRank)
                    .build();
            log.info("сниппет: {}, релевантность: {}", pageSnippetByUserQuery, sumRank);
            resultList.add(searchPageData);
            long duration = System.currentTimeMillis() / 1000 - startIndex;
            log.info("search for: pageID {}, path {}; duration: {}", page.getId(), page.getPath(), duration);
        }
        resultList.sort(Comparator.comparing(SearchPageData::getRelevance).reversed());
        long duration = System.currentTimeMillis() / 1000 - startMethod;
        log.info("ДЛИТЕЛЬНОСТЬ поиска: {}", duration);
        return resultList;
    }

    private String cleanUpHtml(String text) {
        String regex = "(\"?(([А-яЁё\\d]+)(-\3|[\":;.,!?])?))\\s+?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> wordList = new ArrayList<>();
        while (matcher.find()) {
            wordList.add(matcher.group(1));
        }
        return String.join(" ", wordList);
    }

    private String createSnippetFromPage(List<Lemma> lemmaObjectListFromUserQuery, Element element) throws IOException {
        List<String> lemmaWordsFromQuery = lemmaObjectListFromUserQuery.stream().map(Lemma::getLemma).distinct().collect(Collectors.toList());
        long startSnippet = System.currentTimeMillis() / 1000;
        String text = element.toString().toLowerCase();
        String parseText = element.text().toLowerCase();
        String regexFirstLetter = lemmaWordsFromQuery.stream()
                .map(w -> w.substring(0, 1))
                .collect(Collectors.joining("|"));
        String regex = "\\b".concat("(").concat(regexFirstLetter).concat(")").concat("([А-яЁё]+)(-\1)?");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parseText);
        TreeMap<String, String> lemma2word = new TreeMap<>();
        List<Integer> wordIndexes = new ArrayList<>();
        while (matcher.find()) {
            String word = matcher.group();
            String normalWordForm = new RussianLuceneMorphology().getNormalForms(word).get(0);
            if (lemmaWordsFromQuery.contains(normalWordForm)) {
                log.info("лемма: {}, слово: {}", normalWordForm, word.toUpperCase());
                lemma2word.put(normalWordForm, word);
                wordIndexes.add(text.indexOf(word));
                lemmaWordsFromQuery.remove(normalWordForm);
            }
            if (lemmaWordsFromQuery.isEmpty()) {
                break;
            }
        }

        String partHtml = wordIndexes.stream().map(index -> text.substring(index - 100, index + 100)).collect(Collectors.joining(" "));
        String cleanSnippet = cleanUpHtml(partHtml);
        for (String value : lemma2word.values()) {
            cleanSnippet = cleanSnippet.replaceAll("\\b".concat(value), "<b>".concat(value).concat("</b>"));
        }

        long duration = System.currentTimeMillis() / 1000 - startSnippet;
        log.info("Длительность получения СНИППЕТА: {}", duration);
        return cleanSnippet;
    }

    public List<Lemma> findLemmasByWordsFromUserQuery(String userQuery) throws IOException {
        List<Lemma> lemmaList = new ArrayList<>();
        LuceneMorphology luceneMorph = new RussianLuceneMorphology();
        String[] queryWords = userQuery.split(" ");

        for (String word : queryWords) {
            if (luceneMorph.getMorphInfo(word.toLowerCase(Locale.ROOT)).stream().anyMatch(i -> i.contains("ПРЕДЛ") || i.contains("СОЮЗ")
                    || i.contains("ЧАСТ") || i.contains("МЕЖД"))) {
                continue;
            }
            List<Lemma> formWords = luceneMorph.getNormalForms(word.toLowerCase(Locale.ROOT)).get(0).lines()
                    .map(lemmaRepository::findLemmaObjectByLemmaName)
                    .filter(Optional::isPresent)
                    .flatMap(lemmaListOpt -> lemmaListOpt.get().stream())
                    .collect(Collectors.toList());
            lemmaList.addAll(formWords);
        }
        lemmaList.sort(Comparator.comparing(Lemma::getFrequency).thenComparing(Lemma::getLemma));
        return lemmaList;
    }
}



