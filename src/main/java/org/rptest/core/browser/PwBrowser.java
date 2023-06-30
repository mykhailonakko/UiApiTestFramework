package org.rptest.core.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.Objects;

import static com.microsoft.playwright.BrowserType.LaunchOptions;
import static org.rptest.core.config.Property.COMMON_PROPERTY;

public class PwBrowser {
    private static final Playwright playwright = Playwright.create();
    private static final BrowserContext browserContext = startSpecificBrowser().newContext();
    private static Page page;

    private PwBrowser() {
    }

    public static Page getPwDriver() {
        if (Objects.isNull(page) || page.isClosed()) {
            page = browserContext.newPage();
        }
        return page;
    }

    private static Browser startSpecificBrowser() {
        BrowserType browserType = Enum.valueOf(BrowserType.class, COMMON_PROPERTY.browserType().toUpperCase());
        switch (browserType) {
            case CHROME:
            case EDGE:
                return PwBrowser.playwright.chromium().launch(getLaunchOptionsBasedOnConfig());
            case FIREFOX:
                return PwBrowser.playwright.firefox().launch(getLaunchOptionsBasedOnConfig());
            default:
                throw new IllegalArgumentException("Browser" + browserType + "is not supported");
        }
    }

    private static LaunchOptions getLaunchOptionsBasedOnConfig() {
        return new LaunchOptions()
                .setHeadless(COMMON_PROPERTY.headlessMode());
    }
}
