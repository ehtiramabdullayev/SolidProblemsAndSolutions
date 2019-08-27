package com.solution;


import com.solution.cache.CacheWithUseage;

public class Monitor<T> {

	private CacheWithUseage cache;

	public Monitor(CacheWithUseage cache) {
		this.cache = cache;
	}

	public void printInfo() {
		System.out.println("Cache info:");
		for (String key : cache.getKeys()) {
			System.out.println("Element: " + key);
			System.out.println("Last access: " + cache.getLastAccess(key));
			System.out.println("Number of hits: " + cache.getNumHits(key));
		}
	}
	
}
