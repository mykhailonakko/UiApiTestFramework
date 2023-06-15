package org.rptest.core.testrunner;

import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestNGListenerAdapter extends TestListenerAdapter implements ITestNGListener {
    private final TestListener testListener;

    public TestNGListenerAdapter(TestListener testListener) {
        this.testListener = testListener;
    }

    @Override
    public void onTestStart(ITestResult result) {
        testListener.onTestStarted(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testListener.onTestFinished(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testListener.onTestFailed(result.getName());
    }
}
