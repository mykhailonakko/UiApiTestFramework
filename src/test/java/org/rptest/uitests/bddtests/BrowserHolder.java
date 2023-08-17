package org.rptest.uitests.bddtests;

import org.rptest.core.browser.actions.IBrowser;

public class BrowserHolder {
    private IBrowser browser;

    public void setBrowser(IBrowser browser) {
        this.browser = browser;
    }

    public IBrowser getBrowser() {
        return browser;
    }
}
