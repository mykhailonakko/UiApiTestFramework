package org.rptest.core.elements;

public interface UiElement {
    void click();

    void setText(String text);

    String getText();

    boolean isVisible();
}
