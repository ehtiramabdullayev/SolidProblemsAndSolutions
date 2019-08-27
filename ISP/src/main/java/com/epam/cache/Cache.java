package com.epam.cache;

import java.util.Date;

public interface Cache<T> {

	// Basic cache operations
	public void put(String key, T value);

	public T get(String key);

	public void clear(String key);

	public void clearAll();

	// Check cache usage
	public Iterable<String> getKeys();
	
	public Date getLastAccess(String key);

	public long getNumHits(String key);

	// It would be great to implement this
	public void callThisMethodToWinTheLottery();

}
