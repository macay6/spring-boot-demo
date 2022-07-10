package com.macay.demo.test.controller;

import com.macay.demo.test.service.HelloService1;
import com.macay.demo.test.service.HelloService2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/23 5:01 下午
 */
@RestController
public class HelloController {

    @Resource
    private HelloService1 helloService1;

    @Resource
    private HelloService2 helloService2;

    @GetMapping("/hello")
    public Map hello() {
        helloService1.setMap();
        Map map = helloService2.getMap();
        return map;
    }
}
