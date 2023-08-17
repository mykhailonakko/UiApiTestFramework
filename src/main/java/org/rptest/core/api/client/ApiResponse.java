package org.rptest.core.api.client;

public interface ApiResponse {
    int getStatusCode();
    String getResponseBody();
    <T> T getResponse(Class<T> tClass);
}
