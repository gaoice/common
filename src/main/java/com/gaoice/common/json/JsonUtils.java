package com.gaoice.common.json;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Gson 的简单封装
 * Simple wrapper for Gson
 *
 * @author gaoice
 */
public class JsonUtils {

    public static final Gson GSON = new Gson();

    private static final Type MAP_TYPE = new TypeToken<JsonMap>() {
    }.getType();

    public static String toJson(Object o) {
        return GSON.toJson(o);
    }

    public static <T> T fromJson(String s, Class<T> c) {
        return GSON.fromJson(s, c);
    }

    public static <T> T fromJson(String s, Type t) {
        return GSON.fromJson(s, t);
    }

    public static <T> T fromJson(String s, TypeToken<T> t) {
        return GSON.fromJson(s, t.getType());
    }

    /**
     * @param s json string
     * @return JsonMap，may null
     */
    public static JsonMap jsonMap(String s) {
        return fromJson(s, MAP_TYPE);
    }

}
