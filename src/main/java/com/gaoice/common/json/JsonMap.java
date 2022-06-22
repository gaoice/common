package com.gaoice.common.json;

import com.google.common.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 方便去处理无对应实体类的字符串
 * Convenient to handle strings without corresponding entity classes
 *
 * @author gaoice
 */
public class JsonMap extends LinkedHashMap<String, Object> {

    public JsonMap() {
    }

    public String getString(String key) {
        Object o = super.get(key);
        if (o == null) {
            return null;
        }
        if (o instanceof String) {
            return (String) o;
        }
        return JsonUtils.toJson(o);
    }

    public String getString(String key, String defaultValue) {
        String v = getString(key);
        return v == null ? defaultValue : v;
    }

    @SuppressWarnings("unchecked")
    public JsonMap getJsonMap(String key) {
        Object o = super.get(key);
        if (o == null) {
            return null;
        }
        if (o instanceof Map) {
            Map<String, Object> map = null;
            try {
                map = (Map<String, Object>) o;
            } catch (Throwable e) {
                return JsonUtils.jsonMap(JsonUtils.toJson(o));
            }
            JsonMap r = new JsonMap();
            r.putAll(map);
            return r;
        }
        if (o instanceof String) {
            return JsonUtils.jsonMap((String) o);
        }
        return JsonUtils.jsonMap(JsonUtils.toJson(o));
    }

    public <T> T getBean(String key, Class<T> c) {
        String v = getString(key);
        return JsonUtils.fromJson(v, c);
    }

    public <T> T getBean(String key, Type c) {
        String v = getString(key);
        return JsonUtils.fromJson(v, c);
    }

    public <T> T getBean(String key, TypeToken<T> c) {
        String v = getString(key);
        return JsonUtils.fromJson(v, c);
    }

    public Integer getInteger(String key) {
        String v = getString(key);
        return JsonUtils.fromJson(v, Integer.class);
    }

    public Integer getInteger(String key, int defaultValue) {
        Integer r = getInteger(key);
        return r == null ? defaultValue : r;
    }

    public Long getLong(String key) {
        String v = getString(key);
        return JsonUtils.fromJson(v, Long.class);
    }

    public Long getLong(String key, long defaultValue) {
        Long r = getLong(key);
        return r == null ? defaultValue : r;
    }

    public Short getShort(String key) {
        String v = getString(key);
        return JsonUtils.fromJson(v, Short.class);
    }

    public Short getShort(String key, short defaultValue) {
        Short r = getShort(key);
        return r == null ? defaultValue : r;
    }

    public Double getDouble(String key) {
        String v = getString(key);
        return JsonUtils.fromJson(v, Double.class);
    }

    public Double getDouble(String key, double defaultValue) {
        Double r = getDouble(key);
        return r == null ? defaultValue : r;
    }

    public Float getFloat(String key) {
        String v = getString(key);
        return JsonUtils.fromJson(v, Float.class);
    }

    public Float getFloat(String key, float defaultValue) {
        Float r = getFloat(key);
        return r == null ? defaultValue : r;
    }

    public Byte getByte(String key) {
        String v = getString(key);
        return JsonUtils.fromJson(v, Byte.class);
    }

    public Byte getByte(String key, byte defaultValue) {
        Byte r = getByte(key);
        return r == null ? defaultValue : r;
    }

    public Character getCharacter(String key) {
        String v = getString(key);
        return JsonUtils.fromJson(v, Character.class);
    }

    public Character getCharacter(String key, char defaultValue) {
        Character r = getCharacter(key);
        return r == null ? defaultValue : r;
    }

    public Boolean getBoolean(String key) {
        String v = getString(key);
        return JsonUtils.fromJson(v, Boolean.class);
    }

    public Boolean getBoolean(String key, boolean defaultValue) {
        Boolean r = getBoolean(key);
        return r == null ? defaultValue : r;
    }

}
