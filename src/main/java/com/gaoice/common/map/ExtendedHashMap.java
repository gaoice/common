package com.gaoice.common.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoice
 */
public class ExtendedHashMap<K, V> extends HashMap<K, V> {

    public ExtendedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public ExtendedHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    public ExtendedHashMap() {
    }

    public ExtendedHashMap(Map<? extends K, ? extends V> m) {
        super(m);
    }

    public ExtendedHashMap<K, V> append(K key, V value) {
        super.put(key, value);
        return this;
    }
}
