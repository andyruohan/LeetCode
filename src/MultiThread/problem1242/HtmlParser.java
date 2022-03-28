package MultiThread.problem1242;

import java.util.List;

interface HtmlParser {
    // Return a list of all urls from a webpage of given url.
    // This is a blocking call, that means it will do HTTP request and return when this request is finished.
    public List<String> getUrls(String url);
}