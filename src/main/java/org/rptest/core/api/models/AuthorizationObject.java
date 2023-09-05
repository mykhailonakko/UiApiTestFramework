package org.rptest.core.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AuthorizationObject {
    @SerializedName(value = "access_token")
    private final String accessToken;
    @SerializedName(value = "token_type")
    private final String tokenType;
}
