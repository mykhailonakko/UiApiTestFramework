package org.rptest.uitests.bddtests;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.rptest.uitests.bddtests"),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "com.epam.reportportal.cucumber.StepReporter")
})
public class CucumberRunner {
}
