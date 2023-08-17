package org.rptest.core.api.client;

import lombok.SneakyThrows;
import org.apache.hc.client5.http.fluent.Response;
import org.rptest.core.utilities.JsonUtils;

public class ApacheHttpResponse implements ApiResponse {
    private final Response httpResponse;

    public ApacheHttpResponse(Response httpResponse) {
        this.httpResponse = httpResponse;
    }


    @Override
    @SneakyThrows
    public int getStatusCode() {
        return httpResponse.returnResponse().getCode();
    }

    @Override
    @SneakyThrows
    public String getResponseBody() {
        return httpResponse.returnContent().asString();
    }

    @Override
    public <T> T getResponse(Class<T> tClass) {
        return JsonUtils.readJsonToObject(getResponseBody(), tClass);
    }


}
