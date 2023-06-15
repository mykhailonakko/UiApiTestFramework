package org.rptest.core.testrunner;

import com.epam.reportportal.service.Launch;
import com.epam.reportportal.service.ReportPortal;
import com.epam.ta.reportportal.ws.model.FinishTestItemRQ;
import com.epam.ta.reportportal.ws.model.StartTestItemRQ;
import com.epam.ta.reportportal.ws.model.launch.StartLaunchRQ;
import io.reactivex.Maybe;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ReportPortalTestListener implements TestListener {
    private final Launch launch;
    private final Map<String, Maybe<String>> testIds;

    public ReportPortalTestListener() {
        ReportPortal reportPortal = ReportPortal.builder().build();

        StartLaunchRQ startLaunchRQ = new StartLaunchRQ();
        startLaunchRQ.setName("My Launch");
        startLaunchRQ.setStartTime(Calendar.getInstance().getTime());
        startLaunchRQ.setMode(reportPortal.getParameters().getLaunchRunningMode());
        startLaunchRQ.setDescription("My Launch Description");

        this.launch = reportPortal.newLaunch(startLaunchRQ);
        this.testIds = new HashMap<>();
    }

    @Override
    public void onTestStarted(String testName) {
        StartTestItemRQ startTestRq = new StartTestItemRQ();
        startTestRq.setName(testName);
        startTestRq.setStartTime(Calendar.getInstance().getTime());
        startTestRq.setType("STEP");

        Maybe<String> testId = launch.startTestItem(startTestRq);
        testIds.put(testName, testId);
    }

    @Override
    public void onTestFinished(String testName) {
        finishTest(testName, "PASSED");
    }

    @Override
    public void onTestFailed(String testName) {
        finishTest(testName, "FAILED");
    }

    private void finishTest(String testName, String status) {
        FinishTestItemRQ finishTestRq = new FinishTestItemRQ();
        finishTestRq.setEndTime(Calendar.getInstance().getTime());
        finishTestRq.setStatus(status);

        Maybe<String> testId = testIds.get(testName);
        launch.finishTestItem(testId, finishTestRq);
    }
}
