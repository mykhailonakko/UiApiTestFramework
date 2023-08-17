package org.rptest.core.utilities;

import com.google.gson.Gson;

public class JsonUtils {
    public static <T> T readJsonToObject(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }
}
