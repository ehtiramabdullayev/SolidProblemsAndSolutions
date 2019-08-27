package com.solution.cache;


public interface Cache<T> {

    void put(String key, T value);

    T get(String key);

    void clear(String key);

    void clearAll();
}
