package org.rptest.core.browser.actions;

import org.rptest.core.elements.UiElement;

import java.util.List;

public interface IBrowser {
    void open(String url);
    void close();
    String getCurrentUrl();

    UiElement findElement(String xpath);
    List<UiElement> findElements(String xpath);
}
