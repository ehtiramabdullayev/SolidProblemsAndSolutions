package com.solution;

import com.solution.cache.Cache;

public class CacheUser {

	private Cache<String> cache;

	public CacheUser(Cache<String> cache) {
		this.cache = cache;
	}

	public void use() {
		cache.put("A", "A");
		cache.get("A");
		cache.get("A");
		cache.get("A");
	}

}
