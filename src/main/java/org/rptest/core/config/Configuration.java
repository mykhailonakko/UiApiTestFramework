package org.rptest.core.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:env", "file:src/main/resources/general.properties"})
public interface Configuration extends Config {
    @Key("browser")
    String browserType();

    @Key("headless")
    @DefaultValue("false")
    boolean headlessMode();
    @Key("ui_library")
    String uiLibrary();

    @Key("logger_library")
    String loggerLibrary();

    @Key("base_url")
    String baseUrl();

    @Key("screenshots_path")
    String screenshotsPath();
}
