package com.macay.demo.test.cache;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: MapCacheManage
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/23 4:25 下午
 */
public class MapCacheManage {

    private volatile static MapCacheManage mapCacheManage;

    private volatile  Map<String, String> cacheMap = new ConcurrentHashMap<String, String>();// 缓存map

    /**
     * 采用单例模式获取缓存对象实例
     *
     * @return
     */
    public static MapCacheManage getInstance() {
        if (null == mapCacheManage) {
            synchronized (MapCacheManage.class) {
                if (null == mapCacheManage) {
                    mapCacheManage = new MapCacheManage();
                }
            }
        }
        return mapCacheManage;
    }

    //set
    public  void setMapCache(Map<String, String> map) {
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            cacheMap.put(key, map.get(key));
        }
    }

    //get
    public  Map<String, String> getMapCache() {

        return cacheMap;
    }

    //清除cache
    public  void clear() {
        cacheMap.clear();
    }
}
