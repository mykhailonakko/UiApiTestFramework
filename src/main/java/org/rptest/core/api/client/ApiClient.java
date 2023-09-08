package org.rptest.core.api.client;

import org.apache.commons.lang3.tuple.Pair;

public interface ApiClient {
    ApiResponse sendGetRequest(String url);
    ApiResponse sendPostRequest(String url, String body, Pair<String, String> headers);
}
