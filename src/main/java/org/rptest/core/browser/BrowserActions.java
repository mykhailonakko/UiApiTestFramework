package org.rptest.core.browser;

public interface BrowserActions {
    void open(String url);
    void close();
    String getCurrentUrl();
}
