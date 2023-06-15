package org.rptest.core.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:env", "file:src/main/resources/configuration.properties"})
public interface Configuration extends Config {
    @Key("browser")
    String browserType();

    @Key("headless")
    @DefaultValue("false")
    boolean headlessMode();
}
