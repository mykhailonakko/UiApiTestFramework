package org.rptest.apitests;

import org.rptest.core.api.client.ApiClient;
import org.rptest.core.api.client.ApiClientFactory;

public class BaseApiJunit5 {
    ApiClient apiClient = new ApiClientFactory().getApiClient();
}
