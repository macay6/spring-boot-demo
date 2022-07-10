package com.macay.demo.test.service;

import com.macay.demo.test.cache.MapCacheManage;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @ClassName: HelloService1
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/23 5:03 下午
 */
@Service
public class HelloService1 {

    public void setMap() {
        MapCacheManage mapCacheManage = MapCacheManage.getInstance();
        HashMap<String, String> map = new HashMap<>();
        map.put("朵朵", "我是哈哈哈");
        mapCacheManage.setMapCache(map);
    }
}
