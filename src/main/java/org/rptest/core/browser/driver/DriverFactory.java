package org.rptest.core.browser.driver;

import org.rptest.core.config.Property;
import org.rptest.core.constants.UiLibrary;

public class DriverFactory {
    public Driver getDriver() {
        UiLibrary library = Enum.valueOf(UiLibrary.class, Property.COMMON_PROPERTY.uiLibrary().toUpperCase());
        switch (library) {
            case PLAYWRIGHT:
                return new PlaywrightDriver();
            default:
                throw new IllegalArgumentException("Unsupported library: " + library);
        }
    }
}
