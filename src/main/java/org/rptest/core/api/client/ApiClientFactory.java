package org.rptest.core.api.client;

import org.rptest.core.config.Property;
import org.rptest.core.logger.ILogger;
import org.rptest.core.logger.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

public class ApiClientFactory {
    private final ILogger logger = LoggerFactory.getLogger();
    private final AtomicReference<ApiClient> apiClientHolder = new AtomicReference<>();

    public enum ApiClientName {
        APACHE,
        JAVA
    }

    private static final class InstanceHolder {
        static final ApiClientFactory instance = new ApiClientFactory();
    }

    public static ApiClientFactory getInstance() {
        return InstanceHolder.instance;
    }

    public ApiClient getApiClient() {
        ApiClient apiClient = apiClientHolder.get();
        if (apiClient == null) {
            synchronized (this) {
                apiClient = apiClientHolder.get();
                if (apiClient == null) {
                    apiClient = startApiClient();
                    apiClientHolder.compareAndSet(null, apiClient);
                }
            }
        }
        logger.info(apiClient.toString());
        return apiClient;
    }

    private ApiClient startApiClient() {
        ApiClientName library = Enum.valueOf(ApiClientName.class, Property.COMMON_PROPERTY.apiClient().toUpperCase());
        switch (library) {
            case APACHE:
                return new ApacheHttpClient();
            default:
                throw new IllegalArgumentException("Unsupported API library: " + library);
        }
    }
}
