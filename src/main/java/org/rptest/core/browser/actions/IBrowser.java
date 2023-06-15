package org.rptest.core.browser.actions;

import org.rptest.core.elements.UiElement;

import java.nio.file.Path;
import java.util.List;

public interface IBrowser {
    void open(String url);
    void close();
    String getCurrentUrl();
    void takeScreenshot(Path path);
    UiElement findElement(String xpath);
    List<UiElement> findElements(String xpath);
}
