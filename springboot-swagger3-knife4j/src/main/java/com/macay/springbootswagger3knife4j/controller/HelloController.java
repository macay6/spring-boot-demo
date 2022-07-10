package com.macay.springbootswagger3knife4j.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: Macay
 * @Date: 2021/11/14 4:45 下午
 */
@RestController
@Api(tags = "测试接口文档")
public class HelloController {

    @ApiOperation("表单类型")
    @PostMapping("/formRequest")
    public String hello() {
        return "hello";
    }

    @ApiOperation("json类型")
    @PostMapping("/jsonRequest")
    public String hello1() {
       return "hello";
    }
}
