package com.solution.cache;

import java.util.WeakHashMap;

public class BestCache<T> implements Cache<T> {

    private WeakHashMap<String, T> cache = new WeakHashMap<>();

    @Override
    public void put(String key, T value) {
        cache.put(key, value);
    }

    @Override
    public T get(String key) {
        return cache.get(cache);
    }

    @Override
    public void clear(String key) {
        cache.remove(key);
    }

    @Override
    public void clearAll() {
        cache.clear();
    }



}