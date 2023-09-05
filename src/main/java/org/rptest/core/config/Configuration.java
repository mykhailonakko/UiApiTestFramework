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
    @Key("ui.library")
    String uiLibrary();

    @Key("logger.library")
    String loggerLibrary();

    @Key("run.env")
    String runEnv();

    @Key("${run.env}.base.url")
    String baseUrl();

    @Key("screenshots.path")
    String screenshotsPath();

    @Key("rp.project.name")
    String rpProjectName();

    @Key("api.client")
    String apiClient();

    @Key("api.admin.username")
    String apiUsername();

    @Key("api.admin.password")
    String apiPassword();
}
