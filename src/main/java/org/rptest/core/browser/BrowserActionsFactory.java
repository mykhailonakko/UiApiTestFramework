package org.rptest.core.browser;

import lombok.experimental.UtilityClass;
import org.rptest.core.config.Property;
import org.rptest.core.constants.UiLibrary;

@UtilityClass
public class BrowserActionsFactory {
    public static BrowserActions getBrowserActions() {
        UiLibrary library = Enum.valueOf(UiLibrary.class, Property.COMMON_PROPERTY.uiLibrary().toUpperCase());
        switch (library) {
            case PLAYWRIGHT:
                return new PwBrowserActions(PwBrowser.getPwDriver());
            default:
                throw new IllegalArgumentException("Unsupported library: " + library);
        }
    }
}
