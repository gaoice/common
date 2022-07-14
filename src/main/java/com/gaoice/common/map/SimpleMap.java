package com.gaoice.common.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoice
 */
public class SimpleMap<K, V> extends HashMap<K, V> {

    public SimpleMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public SimpleMap(int initialCapacity) {
        super(initialCapacity);
    }

    public SimpleMap() {
    }

    public SimpleMap(Map<? extends K, ? extends V> m) {
        super(m);
    }

    public SimpleMap<K, V> append(K key, V value) {
        super.put(key, value);
        return this;
    }
}
