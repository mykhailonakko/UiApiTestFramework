package org.rptest.core.browser.actions;

import com.microsoft.playwright.Page;
import org.rptest.core.elements.PlaywrightUiElement;
import org.rptest.core.elements.UiElement;

import java.util.List;
import java.util.stream.Collectors;

public class PlaywrightBrowser implements IBrowser {
    private final Page page;

    public PlaywrightBrowser(Page page) {
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
}
