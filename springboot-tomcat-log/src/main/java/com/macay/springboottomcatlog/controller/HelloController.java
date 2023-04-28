package com.macay.springboottomcatlog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: Macay
 * @Date: 2020/12/18 10:29 下午
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello tomcat";
    }
}
