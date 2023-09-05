package org.rptest.core.api.client;

import javafx.util.Pair;

public interface ApiClient {
    ApiResponse sendGetRequest(String url);
    ApiResponse sendPostRequest(String url, String body, Pair<String, String> headers);
}
