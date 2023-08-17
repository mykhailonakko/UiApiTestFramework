package org.rptest.core.api.client;

import java.util.Map;

public interface ApiClient {
    ApiResponse sendGetRequest(String url);
    ApiResponse sendPostRequest(String url, String body, Map<String, String> headers);
}
