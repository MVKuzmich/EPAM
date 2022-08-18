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
import com.kuzmich.searchengineapp.repository.IndexRepository;
import com.kuzmich.searchengineapp.repository.LemmaRepository;
import com.kuzmich.searchengineapp.repository.PageRepository;
import com.kuzmich.searchengineapp.repository.SiteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class IndexingService {

    private final SitesConcurrencyIndexingExecutor indexingExecutor;
    private final WebSiteAnalyzer webSiteAnalyzer;
    private final SiteConfig siteConfig;
    private final SiteRepository siteRepository;
    private final PageRepository pageRepository;
    private final LemmaRepository lemmaRepository;


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

    public ResultDTO executePageIndexation(String pageUrl) {
        List<SiteConfig.SiteObject> siteObjects = siteConfig.getSiteArray();
        Optional<SiteConfig.SiteObject> siteObjectOptional = siteObjects.stream()
                .filter(siteObject -> pageUrl.startsWith(siteObject.getUrl()))
                .findFirst();
        if (siteObjectOptional.isPresent()) {
            updateDataIfReindexExecute(pageUrl);
            String name = siteObjectOptional.get().getName();
            String url = siteObjectOptional.get().getUrl();
            Site site = siteRepository.findByNameAndUrl(name, url).get();
            webSiteAnalyzer.setSite(site);
            webSiteAnalyzer.setMainPath(pageUrl);
            webSiteAnalyzer.fork();
            return new ResultDTO(true);
        } else {
            throw new IndexExecutionException(new ResultDTO(false, "Данная страница находится за пределами сайтов, указанных в конфигурационном файле")
                    .getError());
        }

    }

    private void updateDataIfReindexExecute(String pageUrl) {
        String regex = "https?:\\/\\/\\w+\\.\\w+(\\/.*)";
        Matcher matcher = Pattern.compile(regex).matcher(pageUrl);
        String url = "";
        if (matcher.find()) {
            url = matcher.group(1);
        }
        Page page = pageRepository.findPageByPath(url.concat("/")).orElseThrow(() -> new RuntimeException("Something wrong"));
        List<Index> indexList = page.getIndexList();
        pageRepository.deleteById(page.getId());
        indexList.stream()
                .map(Index::getLemma)
                .map(Lemma::getId)
                .forEach(lemmaRepository::minusLemmaFrequencyById);

    }
}
