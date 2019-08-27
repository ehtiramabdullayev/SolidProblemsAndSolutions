package com.epam.cache;

import java.util.Date;
import java.util.WeakHashMap;

public class BestCache<T> implements Cache<T>{

	private WeakHashMap<String, T> cache = new WeakHashMap<String, T>();
	
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
	public Date getLastAccess(String key) {
		throw new UnsupportedOperationException("Not supported, because I'm too lazy");
	}

	@Override
	public long getNumHits(String key) {
		throw new UnsupportedOperationException("Not supported, because I'm too lazy");
	}

	@Override
	public void callThisMethodToWinTheLottery() {
		throw new UnsupportedOperationException("Really!?");
	}

}
