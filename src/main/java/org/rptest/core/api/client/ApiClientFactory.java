package org.rptest.core.api.client;

import org.rptest.core.config.Property;

public class ApiClientFactory {
    public enum ApiClientName {
        APACHE,
        JAVA
    }

    public ApiClient getApiClient() {
        ApiClientName library = Enum.valueOf(ApiClientName.class, Property.COMMON_PROPERTY.apiClient().toUpperCase());
        switch (library) {
            case APACHE:
                return new ApacheHttpClient();
            default:
                throw new IllegalArgumentException("Unsupported API library: " + library);
        }
    }
}
