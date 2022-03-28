package MultiThread.problem1242;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Crawl mainCrawl = new Crawl(startUrl);
        Crawl.host = mainCrawl.getHost(startUrl);
        Crawl.htmlParser = htmlParser;
        Crawl.result = new HashSet<>();

        Thread mainThread = new Thread(mainCrawl);
        mainThread.start();
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(Crawl.result);
    }
}

class Crawl implements Runnable {
    String url;
    static String host;
    static HtmlParser htmlParser;
    volatile static HashSet<String> result;

    @Override
    public void run() {
        if (!addUrl(url)) {
            return;
        }

        List<Thread> threads = new ArrayList<>();
        for (String link: htmlParser.getUrls(url)) {
            Crawl child = new Crawl(link);
            Thread t = new Thread(child);
            threads.add(t);
            t.start();
        }

        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Crawl(String url) {
        this.url = url;
    }

    public String getHost(String url) {
        return url.split("/", 4)[2];
    }

    public synchronized boolean addUrl(String url) {
        if (!getHost(url).equals(host) || result.contains(url)) {
            return false;
        }
        result.add(url);
        return true;
    }
}
