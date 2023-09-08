package org.rptest.core.browser.actions;

import com.microsoft.playwright.Page;
import org.rptest.core.elements.PlaywrightUiElement;
import org.rptest.core.elements.UiElement;
import org.rptest.core.logger.ILogger;
import org.rptest.core.logger.LoggerFactory;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class PlaywrightBrowser implements IBrowser {
    private final Page page;
    private final ILogger logger = LoggerFactory.getLogger();

    public PlaywrightBrowser(Page page) {
        this.page = page;
    }

    @Override
    public void open(String url) {
        page.navigate(url);
        logger.info("OPENING URL: " + url);
    }

    @Override
    public void close() {
        page.close();
    }

    @Override
    public String getCurrentUrl() {
        return page.url();
    }

    @Override
    public UiElement findElement(String xpath) {
        return new PlaywrightUiElement(page.locator(xpath));
    }

    @Override
    public List<UiElement> findElements(String xpath) {
        return page.locator(xpath).all().stream()
                .map(PlaywrightUiElement::new)
                .collect(Collectors.toList());
    }

    @Override
    public void takeScreenshot(Path path) {
        page.screenshot(new Page.ScreenshotOptions().setPath(path));
    }
}
