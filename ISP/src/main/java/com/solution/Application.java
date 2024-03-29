package com.solution;

import com.solution.cache.*;

public class Application {

	public static void main(String[] args) {
		CacheWithUseageImpl<String> stringCache = new CacheWithUseageImpl<>();
		use(stringCache);
		monitor(stringCache);
		winLottery(stringCache);

		Cache<String> bestCache = new BestCache<>();
		use(bestCache);

	}

	private static void monitor(CacheWithUseage stringCache) {
		Monitor<String> stringCacheMonitor = new Monitor<>(stringCache);
		stringCacheMonitor.printInfo();
	}

	private static void use(Cache<String> stringCache) {
		CacheUser cacheUser = new CacheUser(stringCache);
		cacheUser.use();
	}

	private static void winLottery(WinnableLottery stringCache) {
		stringCache.callThisMethodToWinTheLottery();
	}

}
