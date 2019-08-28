package com.solution.cache;

import java.util.Date;

/**
 * @author Ehtiram Etibarovich Abdullayev on 27.08.2019
 * @project oo-principles
 */
public interface CacheWithUseage {

    Iterable<String> getKeys();

    Date getLastAccess(String key);

    long getNumHits(String key);
}
