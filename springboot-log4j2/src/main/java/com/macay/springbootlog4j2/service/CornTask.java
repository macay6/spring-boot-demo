package com.macay.springbootlog4j2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CornTask
 * @Description:
 * @Author: Macay
 * @Date: 2021/11/27 5:15 下午
 */
@Component
@Slf4j
public class CornTask {

    @Scheduled( cron = "0/1 * * * * *")
    public void test() {
        log.info("info");
        log.warn("warn  cccccccccccccccccccccccccccccccccccccccccccccccccccccccccc前面介绍的几种日志框架一样，每一种日志框架都有自己单独的API，要使用对应的框架就要使用其对应的API，这就大大的增加应用程序代码对于日志框架的耦合性。\n" +
                "\n" +
                "使用了slf4j后，对于应用程序来说，无论底层的日志框架如何变，应用程序不需要修改任意一行代码，就可以直接上线了。");
        log.error("error");
        System.out.println("hello");
    }
}
