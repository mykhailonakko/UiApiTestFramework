package org.rptest.core.testrunner;

import java.util.List;

public interface TestRunner {
    void runTests(Class<?> testClass);

    void runTests(List<Class<?>> testClasses);

    void addListener(TestListener testListener);
}
