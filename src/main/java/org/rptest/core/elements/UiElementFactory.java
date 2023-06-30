package org.rptest.core.elements;

import lombok.experimental.UtilityClass;
import org.rptest.core.browser.PwBrowser;
import org.rptest.core.config.Property;
import org.rptest.core.constants.UiLibrary;

@UtilityClass
public class UiElementFactory {
    private static final UiLibrary library = Enum.valueOf(UiLibrary.class, Property.COMMON_PROPERTY.uiLibrary().toUpperCase());

    public static UiElement findElementById(String id) {
        switch (library) {
            case PLAYWRIGHT:
                return new PwUiElement(PwBrowser.getPwDriver().locator(String.format("id=%s", id)));
            default:
                throw new IllegalArgumentException("Unsupported library: " + library);
        }
    }

    public static UiElement findElementByXpath(String xpath) {
        switch (library) {
            case PLAYWRIGHT:
                return new PwUiElement(PwBrowser.getPwDriver().locator(xpath));
            default:
                throw new IllegalArgumentException("Unsupported library: " + library);
        }
    }
}
