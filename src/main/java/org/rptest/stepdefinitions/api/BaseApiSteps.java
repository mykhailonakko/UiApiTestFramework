package org.rptest.stepdefinitions.api;

import org.rptest.core.api.client.ApiClient;
import org.rptest.core.config.Property;

public class BaseApiSteps {
    protected final ApiClient apiClient;
    private static final String API_ENDPOINT = "api/v1";
    private final String baseUrl = Property.COMMON_PROPERTY.baseUrl();
    private final String projectName = Property.COMMON_PROPERTY.rpProjectName();

    public BaseApiSteps (ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    protected String createUrl(String endpoint) {
        return String.join("/", baseUrl, API_ENDPOINT, projectName, endpoint);
    }
}
