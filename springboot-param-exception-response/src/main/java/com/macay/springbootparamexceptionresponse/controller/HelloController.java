package com.macay.springbootparamexceptionresponse.controller;

import com.macay.springbootparamexceptionresponse.entity.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: Macay
 * @Date: 2021/11/14 4:45 下午
 */
@RestController
public class HelloController {

    @PostMapping("/formRequest")
    public String hello(@Validated  Student student) {
        return "hello";
    }

    @PostMapping("/jsonRequest")
    public String hello1(@Validated @RequestBody Student student) {
       return "hello";
    }
}
