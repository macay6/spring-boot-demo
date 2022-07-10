package com.macay.springbootredis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: Macay
 * @Date: 2021/1/29 12:18 上午
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello redis";
    }
}
