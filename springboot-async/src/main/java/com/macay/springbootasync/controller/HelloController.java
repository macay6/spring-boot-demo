package com.macay.springbootasync.controller;

import com.macay.springbootasync.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: Macay
 * @Date: 2021/11/27 9:47 下午
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() throws InterruptedException, ExecutionException {
        System.out.println("开始执行");
        Future<String> one = helloService.one();
        Future<String> two = helloService.two();
        Future<String> three = helloService.three();

        // 三个任务都调用完成，退出循环等待
        while (!one.isDone() || !two.isDone() || !three.isDone()) {
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(one.get() + "-" + two.get() + "-" + three.get());

        System.out.println("执行结束");
        return "hello";
    }
}
