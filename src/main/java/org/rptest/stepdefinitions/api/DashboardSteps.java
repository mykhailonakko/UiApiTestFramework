package org.rptest.stepdefinitions.api;

import org.rptest.core.api.client.ApiClient;
import org.rptest.core.api.models.DashboardObject;

import java.util.List;

public class DashboardSteps extends BaseApiSteps{
    private final String dashboardUrl = createUrl("dashboard");

    public DashboardSteps(ApiClient apiClient) {
        super(apiClient);
    }

    public List<DashboardObject.Content> getDashboardContentList() {
        return apiClient.sendGetRequest(dashboardUrl).getResponse(DashboardObject.class).getContent();
    }

    public int getDashboardEndpointStatusCode() {
        return apiClient.sendGetRequest(dashboardUrl).getStatusCode();
    }
}
