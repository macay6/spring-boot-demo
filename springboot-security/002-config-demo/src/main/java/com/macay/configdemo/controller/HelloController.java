package com.macay.configdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: Macay
 * @Date: 2020/12/16 4:08 下午
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello security!";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user!";
    }
}
