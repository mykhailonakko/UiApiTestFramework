package org.rptest.apitests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rptest.stepdefinitions.api.DashboardSteps;

class DashboardApiTest extends BaseApiJunit5 {
    DashboardSteps dashboardSteps = new DashboardSteps(apiClient);

    @Test
    void testResponseCode() {
        Assertions.assertEquals(200, dashboardSteps.getDashboardEndpointStatusCode());
    }

    @Test
    void testDashboardContentNotEmpty() {
        Assertions.assertFalse(dashboardSteps.getDashboardContentList().isEmpty());
    }

    @Test
    void testDemoDashboardIsPresent() {
        final String demoDashboardName = "DEMO DASHBOARD";
        Assertions.assertTrue(dashboardSteps.getDashboardContentList().stream()
                .anyMatch(dashboard -> dashboard.getName().equals(demoDashboardName)));
    }
}
