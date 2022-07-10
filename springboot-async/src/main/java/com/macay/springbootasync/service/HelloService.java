package com.macay.springbootasync.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @ClassName: HelloService
 * @Description:
 * @Author: Macay
 * @Date: 2021/11/27 9:48 下午
 */
@Service
public class HelloService {

    @Async("taskExecutor")
    public Future<String> one() {
        System.out.println("one，当前线程：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务一完成");

    }

    @Async("taskExecutor")
    public Future<String> two() {
        System.out.println("two，当前线程：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务二完成");
    }

    @Async("taskExecutor")
    public Future<String> three() {
        System.out.println("three，当前线程：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务三完成");
    }
}
