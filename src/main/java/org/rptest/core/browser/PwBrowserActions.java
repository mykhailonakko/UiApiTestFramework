package org.rptest.core.browser;

import com.microsoft.playwright.Page;

public class PwBrowserActions implements BrowserActions{
    private final Page page;

    public PwBrowserActions(Page page) {
        this.page = page;
    }

    @Override
    public void open(String url) {
        page.navigate(url);
    }

    @Override
    public void close() {
        page.close();

    }

    @Override
    public String getCurrentUrl() {
        return page.url();
    }
}
