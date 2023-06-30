package org.rptest.core.elements;

import com.microsoft.playwright.Locator;
import org.rptest.core.logger.ILogger;
import org.rptest.core.logger.LoggerFactory;

public class PwUiElement implements UiElement{
    private final Locator locator;
    private final ILogger logger = LoggerFactory.getLogger();

    public PwUiElement(Locator locator) {
        this.locator = locator;
    }

    @Override
    public void click() {
        locator.click();
    }

    @Override
    public void setText(String text) {
        locator.clear();
        locator.type(text);
        logger.info(String.format("Typing the following text: '%s'", text));
    }

    @Override
    public String getText() {
        return locator.textContent();
    }

    @Override
    public boolean isVisible() {
        return locator.isVisible();
    }
}