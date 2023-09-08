package org.rptest.core.browser.driver;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import org.rptest.core.browser.actions.IBrowser;
import org.rptest.core.browser.actions.PlaywrightBrowser;
import org.rptest.core.constants.BrowserType;
import org.rptest.core.logger.ILogger;
import org.rptest.core.logger.LoggerFactory;

import static org.rptest.core.config.Property.COMMON_PROPERTY;

public class PlaywrightDriver implements Driver {
    private final ILogger logger = LoggerFactory.getLogger();
    private Playwright playwright;
    private BrowserContext browserContext;
    private Browser browser;

    @Override
    public void initiateDriver() {
        playwright = Playwright.create();
        browser = startSpecificBrowser();
    }

    @Override
    public IBrowser getBrowser() {
        browserContext = browser.newContext();
        Page page = browser.newPage();
        return new PlaywrightBrowser(page);
    }

    @Override
    public void quitDriver() {

        if (playwright != null) {
            playwright.close();
        }
    }

    @Override
    public void closeBrowser() {
        if (browserContext != null) {
            browserContext.close();
        }
    }

    private Browser startSpecificBrowser() {
        BrowserType browserType = Enum.valueOf(BrowserType.class, COMMON_PROPERTY.browser().toUpperCase());
        logger.info("STARTING BROWSER: " + browserType.name());
        switch (browserType) {
            case CHROME:
            case EDGE:
                return playwright.chromium().launch(getLaunchOptionsBasedOnConfig());
            case FIREFOX:
                return playwright.firefox().launch(getLaunchOptionsBasedOnConfig());
            default:
                throw new IllegalArgumentException("Browser" + browserType + "is not supported");
        }
    }

    private LaunchOptions getLaunchOptionsBasedOnConfig() {
        return new LaunchOptions()
                .setHeadless(COMMON_PROPERTY.headlessMode());
    }
}
