package com.epam;

import com.epam.cache.BestCache;
import com.epam.cache.Cache;

public class Application {

	public static void main(String[] args) {
		Cache<String> stringCache = new BestCache<String>();
		use(stringCache);
		monitor(stringCache);
		winLottery(stringCache);
	}

	private static void monitor(Cache<String> stringCache) {
		Monitor<String> stringCacheMonitor = new Monitor<String>(stringCache);
		stringCacheMonitor.printInfo();
	}

	private static void use(Cache<String> stringCache) {
		CacheUser cacheUser = new CacheUser(stringCache);
		cacheUser.use();
	}

	private static void winLottery(Cache<String> stringCache) {
		stringCache.callThisMethodToWinTheLottery();
	}

}
