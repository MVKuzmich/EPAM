package com.kuzmich.searchengineapp.action;

import com.kuzmich.searchengineapp.entity.*;
import com.kuzmich.searchengineapp.repository.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

@Log4j2
@Component
@RequiredArgsConstructor
public class WebSiteAnalyzer extends RecursiveAction {

    private static final String USERAGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36" +
            " (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36";
    private static final String REFERRER = "https://www.google.com";
    private static CopyOnWriteArraySet<String> serviceSet = new CopyOnWriteArraySet<>();
    @Setter
    @Getter
    private static boolean isIndexationStopped;
    @Setter
    @Getter
    private static boolean isOnePageIndexation;
    @Setter
    @Getter
    private volatile Site site;
    @Setter
    private volatile String mainPath;

    private final PageRepository pageRepository;
    private final LemmaRepository lemmaRepository;
    private final IndexRepository indexRepository;
    private final FieldRepository fieldRepository;
    private final SiteRepository siteRepository;


    @Override
    protected void compute() {
        if (!isIndexationStopped) {
            log.info("выполняется поток: {}, парсинг страницы: {}", Thread.currentThread().getName(), mainPath);
            List<WebSiteAnalyzer> taskList = new ArrayList<>();
            int twoSlashIndex = mainPath.indexOf("//") + 2;
            int slashIndex = mainPath.indexOf("/", twoSlashIndex);
            try {
                Connection jsoupConnection = Jsoup.connect(mainPath);
                Document document = jsoupConnection.userAgent(USERAGENT).referrer(REFERRER).timeout(0).get();
                String pathFormat = (slashIndex == -1) ? "/" : mainPath.substring(slashIndex);
                int statusCode = jsoupConnection.execute().statusCode();
                String htmlContent = document.toString();
                Page page = pageRepository.saveAndFlush(Page.builder().path((pathFormat.endsWith("/") || pathFormat.endsWith(".html")) ? pathFormat : pathFormat.concat("/")).code(statusCode).content(htmlContent).site(site).build());
                log.info("SAVED page: {}, pageId: {}", page.getPath(), page.getId());

                new PageIndexExecutor(fieldRepository, lemmaRepository, indexRepository, siteRepository).executePageIndexing(page);

                Elements elements = document.select("a[abs:href^=" + site.getUrl() + "]");
                Set<String> links = elements.stream()
                        .map(e -> e.attr("abs:href"))
                        .collect(Collectors.toSet());
                links.removeIf(l -> l.contains("#") || l.contains("?") || l.contains("=")
                        || l.matches("(?i).+\\.(?!html).{1,5}$"));
                links.removeIf(l -> !serviceSet.add(l));
                if (!links.isEmpty()) {
                    serviceSet.add(mainPath);
                    serviceSet.addAll(links);
                    for (String link : links) {
                        if (isIndexationStopped || isOnePageIndexation) {
                            break;
                        }
                        WebSiteAnalyzer task = new WebSiteAnalyzer(pageRepository, lemmaRepository, indexRepository, fieldRepository, siteRepository);
                        task.setSite(site);
                        task.setMainPath(link);
                        task.fork();
                        taskList.add(task);
                        Thread.sleep((long) (500 + Math.random() * 4500));
                    }
                    for (WebSiteAnalyzer web : taskList) {
                        web.join();
                    }
                }
            } catch (HttpStatusException hse) {
                String pathFormat = (slashIndex == -1) ? "/" : hse.getUrl().substring(slashIndex);
                Page page = Page.builder().path(pathFormat).code(hse.getStatusCode()).content("no content").site(site).build();
                pageRepository.saveAndFlush(page);
            } catch (Exception e) {
                siteRepository.updateSiteStatusAndError(Status.FAILED, e.getMessage(), site.getId());
                e.printStackTrace();
            }
        }
    }
}






