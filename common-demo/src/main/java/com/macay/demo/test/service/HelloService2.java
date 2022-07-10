package com.macay.demo.test.service;

import com.macay.demo.test.cache.MapCacheManage;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: HelloService2
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/23 5:03 下午
 */
@Service
public class HelloService2 {

    public Map getMap() {
        MapCacheManage mapCacheManage = MapCacheManage.getInstance();
        Map<String, String> mapCache = mapCacheManage.getMapCache();
        return mapCache;
    }
}
