package com.gaoice.common.json;

import com.google.common.reflect.TypeToken;
import com.google.gson.internal.LinkedTreeMap;

import java.lang.reflect.Type;

/**
 * 方便去处理无对应实体类的字符串
 * Convenient to handle strings without corresponding entity classes
 *
 * @author gaoice
 */
public class JsonMap {

    private final LinkedTreeMap<String, Object> linkedTreeMap;

    public JsonMap(LinkedTreeMap<String, Object> linkedTreeMap) {
        this.linkedTreeMap = linkedTreeMap;
    }

    /**
     * @param key string
     * @return value string
     */
    public String get(String key) {
        Object o = this.linkedTreeMap.get(key);
        if (o == null) {
            return null;
        }
        if (o instanceof String) {
            return (String) o;
        }
        return JsonUtils.toJson(o);
    }

    public JsonMap getJsonMap(String key) {
        String v = get(key);
        return JsonUtils.jsonMap(v);
    }

    public <T> T getBean(String key, Class<T> c) {
        String v = get(key);
        return JsonUtils.fromJson(v, c);
    }

    public <T> T getBean(String key, Type c) {
        String v = get(key);
        return JsonUtils.fromJson(v, c);
    }

    public <T> T getBean(String key, TypeToken<T> c) {
        String v = get(key);
        return JsonUtils.fromJson(v, c);
    }

    public String getString(String key) {
        return get(key);
    }

    public String getString(String key, String defaultValue) {
        String r = getString(key);
        return r == null ? defaultValue : r;
    }

    public Integer getInteger(String key) {
        String v = get(key);
        return JsonUtils.fromJson(v, Integer.class);
    }

    public Integer getInteger(String key, int defaultValue) {
        Integer r = getInteger(key);
        return r == null ? defaultValue : r;
    }

    public Long getLong(String key) {
        String v = get(key);
        return JsonUtils.fromJson(v, Long.class);
    }

    public Long getLong(String key, long defaultValue) {
        Long r = getLong(key);
        return r == null ? defaultValue : r;
    }

    public Short getShort(String key) {
        String v = get(key);
        return JsonUtils.fromJson(v, Short.class);
    }

    public Short getShort(String key, short defaultValue) {
        Short r = getShort(key);
        return r == null ? defaultValue : r;
    }

    public Double getDouble(String key) {
        String v = get(key);
        return JsonUtils.fromJson(v, Double.class);
    }

    public Double getDouble(String key, double defaultValue) {
        Double r = getDouble(key);
        return r == null ? defaultValue : r;
    }

    public Float getFloat(String key) {
        String v = get(key);
        return JsonUtils.fromJson(v, Float.class);
    }

    public Float getFloat(String key, float defaultValue) {
        Float r = getFloat(key);
        return r == null ? defaultValue : r;
    }

    public Byte getByte(String key) {
        String v = get(key);
        return JsonUtils.fromJson(v, Byte.class);
    }

    public Byte getByte(String key, byte defaultValue) {
        Byte r = getByte(key);
        return r == null ? defaultValue : r;
    }

    public Character getCharacter(String key) {
        String v = get(key);
        return JsonUtils.fromJson(v, Character.class);
    }

    public Character getCharacter(String key, char defaultValue) {
        Character r = getCharacter(key);
        return r == null ? defaultValue : r;
    }

    public Boolean getBoolean(String key) {
        String v = get(key);
        return JsonUtils.fromJson(v, Boolean.class);
    }

    public Boolean getBoolean(String key, boolean defaultValue) {
        Boolean r = getBoolean(key);
        return r == null ? defaultValue : r;
    }
}
