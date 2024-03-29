package com.kuzmich.searchengineapp.service;

import com.kuzmich.searchengineapp.action.SitesConcurrencyIndexingExecutor;
import com.kuzmich.searchengineapp.action.WebSiteAnalyzer;
import com.kuzmich.searchengineapp.config.SiteConfig;
import com.kuzmich.searchengineapp.dto.ResultDTO;
import com.kuzmich.searchengineapp.entity.Index;
import com.kuzmich.searchengineapp.entity.Lemma;
import com.kuzmich.searchengineapp.entity.Page;
import com.kuzmich.searchengineapp.entity.Site;
import com.kuzmich.searchengineapp.exception.IndexExecutionException;
import com.kuzmich.searchengineapp.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@RequiredArgsConstructor
@Log4j2
public class IndexingService {

    private final SitesConcurrencyIndexingExecutor indexingExecutor;
    private final SiteConfig siteConfig;
    private final SiteRepository siteRepository;
    private final PageRepository pageRepository;
    private final LemmaRepository lemmaRepository;
    private final FieldRepository fieldRepository;
    private final IndexRepository indexRepository;


    public ResultDTO executeIndexation() throws IndexExecutionException {
        if (!indexingExecutor.isExecuting()) {
            WebSiteAnalyzer.setIndexationStopped(false);
            indexingExecutor.executeSitesIndexing();
            return new ResultDTO(true);
        } else {
            throw new IndexExecutionException(new ResultDTO(false, "Индексация уже запущена").getError());
        }
    }

    public ResultDTO stopIndexation() throws IndexExecutionException {
        if (indexingExecutor.isExecuting()) {
            WebSiteAnalyzer.setIndexationStopped(true);
            return new ResultDTO(true);
        } else {
            throw new IndexExecutionException(new ResultDTO(false, "Индексация не запущена").getError());
        }
    }

    public ResultDTO executePageIndexation(String pageUrl) throws IndexExecutionException {
        List<SiteConfig.SiteObject> siteObjects = siteConfig.getSiteArray();
        Optional<SiteConfig.SiteObject> siteObjectOptional = siteObjects.stream()
                .filter(siteObject -> pageUrl.startsWith(siteObject.getUrl()))
                .findFirst();
        if (siteObjectOptional.isPresent()) {
            String name = siteObjectOptional.get().getName();
            String url = siteObjectOptional.get().getUrl();
            Site site = siteRepository.findByNameAndUrl(name, url).get();
            WebSiteAnalyzer.setOnePageIndexation(true);
            try {
                updateDataIfReindexExecute(pageUrl, site.getId());
            } catch(RuntimeException ex) {
                log.info(ex.getMessage());
            }

            WebSiteAnalyzer wsa = new WebSiteAnalyzer(pageRepository, lemmaRepository, indexRepository, fieldRepository, siteRepository, siteConfig);
            wsa.setSite(site);
            wsa.setMainPath(pageUrl);
            new ForkJoinPool().invoke(wsa);
            WebSiteAnalyzer.setOnePageIndexation(false);
            return new ResultDTO(true);
        } else {
            throw new IndexExecutionException(new ResultDTO(false, "Данная страница находится за пределами сайтов, указанных в конфигурационном файле")
                    .getError());
        }
    }

    private void updateDataIfReindexExecute(String pageUrl, int siteId) throws RuntimeException {
        String regex = "https?:\\/\\/\\w+\\.\\w+(\\/.*)";
        Matcher matcher = Pattern.compile(regex).matcher(pageUrl);
        String url = "";
        if (matcher.find()) {
            url = matcher.group(1);
        }
        Page page = pageRepository.findPageByPath(url.concat("/"), siteId).orElseThrow(() -> new RuntimeException("Url is not exist! Indexation is started"));
        List<Index> indexList = page.getIndexList();
        pageRepository.deleteById(page.getId());
        indexList.stream()
                .map(Index::getLemma)
                .map(Lemma::getId)
                .forEach(lemmaRepository::minusLemmaFrequencyById);

    }
}

