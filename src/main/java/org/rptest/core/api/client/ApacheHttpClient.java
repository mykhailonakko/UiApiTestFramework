package org.rptest.core.api.client;

import lombok.SneakyThrows;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.message.BasicHeader;

import java.util.Map;

public class ApacheHttpClient implements ApiClient {
    @Override
    @SneakyThrows
    public ApiResponse sendGetRequest(String url) {
        return new ApacheHttpResponse(Request.get(url).addHeader(getAuthHeader()).execute());
    }

    @Override
    @SneakyThrows
    public ApiResponse sendPostRequest(String url, String body, Map<String, String> headers) {
//        ClassicHttpRequest httpPost = ClassicRequestBuilder.post(url)
//                .setEntity(new Head(Arrays.asList(
//                        new BasicNameValuePair("username", "vip"),
//                        new BasicNameValuePair("password", "secret"))))
//                .build();
//        httpPost.setEntity(new StringEntity(body));
//        for (Map.Entry<String, String> header : headers.entrySet()) {
//            httpPost.addHeader(header.getKey(), header.getValue());
//        }
//        return httpClient.execute(httpPost, new BasicHttpClientResponseHandler());

        return new ApacheHttpResponse(Request.post(url).bodyString(body, ContentType.APPLICATION_JSON).addHeader(getAuthHeader()).execute());
    }

    private Header getAuthHeader() {
        return new BasicHeader("Authorization", "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2OTIzNjk1MTgsInVzZXJfbmFtZSI6ImRlZmF1bHQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiYTgzNTIxMmYtOGVhMC00ODFhLWE5Y2ItYzYyMDliYzYyNWRhIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.1cvhrjoyNUtmhpp-XtxxS_UVEWE3O7Pi6sbps27G94I");
    }
}
