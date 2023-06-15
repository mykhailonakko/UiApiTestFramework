package org.rptest.core.testrunner;

public interface TestListener {
    void onTestStarted(String testName);

    void onTestFinished(String testName);

    void onTestFailed(String testName);
}
