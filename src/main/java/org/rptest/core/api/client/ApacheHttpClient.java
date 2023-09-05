package org.rptest.core.api.client;

import javafx.util.Pair;
import lombok.SneakyThrows;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.message.BasicHeader;

public class ApacheHttpClient implements ApiClient {
    @Override
    @SneakyThrows
    public ApiResponse sendGetRequest(String url) {
        return new ApacheHttpResponse(Request.get(url).addHeader(getAuthHeader()).execute());
    }

    @Override
    @SneakyThrows
    public ApiResponse sendPostRequest(String url, String body, Pair<String, String> header) {
        return new ApacheHttpResponse(Request.post(url).bodyString(body, ContentType.APPLICATION_FORM_URLENCODED)
                .addHeader(header.getKey(), header.getValue()).execute());
    }

    private Header getAuthHeader() {
        return new BasicHeader("Authorization", TokenManager.getInstance().getAccessToken());
    }
}
