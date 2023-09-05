package org.rptest.core.utilities;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtils {
    public static <T> T readJsonToObject(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }
}
