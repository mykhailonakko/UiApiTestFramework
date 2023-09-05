package org.rptest.core.api.client;

import javafx.util.Pair;
import org.rptest.core.api.models.AuthorizationObject;
import org.rptest.core.config.Property;
import org.rptest.core.utilities.JsonUtils;

public class TokenManager {
    private volatile String accessToken;

    private TokenManager() {
    }

    private static final class InstanceHolder {
        static final TokenManager instance = new TokenManager();
    }

    public static TokenManager getInstance() {
        return InstanceHolder.instance;
    }

    public String getAccessToken() {
        if (accessToken == null) {
            synchronized (this) {
                if (accessToken == null) {
                    accessToken = requestNewTokenFromServer();
                }
            }
        }
        return accessToken;
    }

    private String requestNewTokenFromServer() {
        String url = Property.COMMON_PROPERTY.baseUrl() + "uat/sso/oauth/token";
        String body = String.format("grant_type=password&username=%s&password=%s", Property.COMMON_PROPERTY.apiUsername(), Property.COMMON_PROPERTY.apiPassword());
        Pair<String, String> authHeader = new Pair<>("Authorization", "Basic dWk6dWltYW4=");
        String response = ApiClientFactory.getInstance().getApiClient().sendPostRequest(url, body, authHeader).getResponseBody();
        AuthorizationObject authorizationObject = JsonUtils.readJsonToObject(response, AuthorizationObject.class);
        return String.join(" ", authorizationObject.getTokenType(), authorizationObject.getAccessToken());
    }
}

