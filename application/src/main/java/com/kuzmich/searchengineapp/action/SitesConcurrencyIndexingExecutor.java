package com.kuzmich.searchengineapp.action;

import com.kuzmich.searchengineapp.config.SiteConfig;
import com.kuzmich.searchengineapp.entity.Site;
import com.kuzmich.searchengineapp.entity.Status;
import com.kuzmich.searchengineapp.repository.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@Component
@RequiredArgsConstructor
@Log4j2
public class SitesConcurrencyIndexingExecutor {

    private final SiteConfig siteConfig;
    private final SiteRepository siteRepository;
    private final PageRepository pageRepository;
    private final LemmaRepository lemmaRepository;
    private final IndexRepository indexRepository;
    private final FieldRepository fieldRepository;

    @Setter
    @Getter
    private boolean isExecuting;

    public void executeSitesIndexing() {
        if (!isExecuting) {
            setExecuting(true);
            long start = System.currentTimeMillis() / 1000;
            List<SiteConfig.SiteObject> siteObjects = siteConfig.getSiteArray();
            ExecutorService pool = Executors.newFixedThreadPool(siteObjects.size());
            List<CompletableFuture<Integer>> futureList = new ArrayList<>();
            siteObjects.stream().map(siteObject -> {
                        Optional<Site> foundSite = siteRepository.findByNameAndUrl(siteObject.getName(), siteObject.getUrl());
                        foundSite.ifPresent(s -> siteRepository.removeSiteById(s.getId()));
                        siteRepository.flush();
                        WebSiteAnalyzer siteAnalyzer = new WebSiteAnalyzer(pageRepository, lemmaRepository, indexRepository, fieldRepository, siteRepository);
                        Site site = getSite(siteObject);
                        siteAnalyzer.setSite(site);
                        siteAnalyzer.setMainPath(site.getUrl());
                        return siteAnalyzer;
                    })
                    .map(siteAnalyzer -> {
                        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                            new ForkJoinPool().invoke(siteAnalyzer);
                            return siteAnalyzer.getSite().getId();
                        }, pool);
                        futureList.add(future);
                        return future;
                    })
                    .forEach(future -> {
                        future.thenAccept(result -> siteRepository.updateSiteStatus(Status.INDEXED, result));
                    });
            futureList.forEach(CompletableFuture::join);
            setExecuting(false);
            log.info("ИТОГО длительность ИНДЕКСАЦИИ: {} минут", (System.currentTimeMillis() / 1000 - start) / 60);
        }
    }

    private Site getSite(SiteConfig.SiteObject siteObject) {
        Site site = new Site(
                Status.INDEXING,
                System.currentTimeMillis(),
                "",
                siteObject.getUrl(),
                siteObject.getName()
        );
        return siteRepository.saveAndFlush(site);
    }
}



