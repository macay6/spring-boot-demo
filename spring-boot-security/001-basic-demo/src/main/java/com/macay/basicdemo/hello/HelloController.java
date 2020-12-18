package com.macay.basicdemo.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: Macay
 * @Date: 2020/12/16 1:58 下午
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello security!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "hello admin!";
    }

    @GetMapping("/user")
    public String user() {
        return "hello user!";
    }
}
