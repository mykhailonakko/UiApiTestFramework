package org.rptest.core.testrunner;

import org.testng.ITestNGListener;
import org.testng.TestNG;

import java.util.List;


public class TestNGRunner implements TestRunner{
    private final TestNG testNG;

    public TestNGRunner() {
        this.testNG = new TestNG();
    }

    public void runTests(Class<?> testClass) {
        testNG.setTestClasses(new Class<?>[]{testClass});
        testNG.run();
    }

    public void runTests(List<Class<?>> testClasses) {
        testNG.setTestClasses(testClasses.toArray(new Class<?>[0]));
        testNG.run();
    }

    public void addListener(TestListener testListener) {
        testNG.addListener((ITestNGListener) new TestNGListenerAdapter(testListener));
    }
}
