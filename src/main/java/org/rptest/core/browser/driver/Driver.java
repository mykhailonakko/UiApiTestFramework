package org.rptest.core.browser.driver;

import org.rptest.core.browser.actions.IBrowser;

public interface Driver {
    void initiateDriver();
    IBrowser getBrowser();
    void closeBrowser();
    void quitDriver();
}
