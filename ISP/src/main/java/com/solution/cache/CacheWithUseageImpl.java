package com.solution.cache;

import java.util.Date;
import java.util.WeakHashMap;

/**
 * @author Ehtiram Etibarovich Abdullayev on 27.08.2019
 * @project oo-principles
 */
public class CacheWithUseageImpl<T> implements Cache<T> ,CacheWithUseage,WinnableLottery  {
    private WeakHashMap<String, T> cache = new WeakHashMap<>();



    @Override
    public Date getLastAccess(String key) {
        return new Date();
    }

    @Override
    public long getNumHits(String key) {
        return 0;
    }
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

    @Override
    public Iterable<String> getKeys() {
        return cache.keySet();
    }


    @Override
    public void callThisMethodToWinTheLottery() {
        System.out.println("You won !!");
    }
}
