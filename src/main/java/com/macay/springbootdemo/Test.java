package com.macay.springbootdemo;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * @ClassName: Test
 * @Description:
 * @Author: Macay
 * @Date: 2020/12/12 8:20 下午
 */
public class Test {
    private String name;
    private int age;

    public Test(String name) {
        try {
            this.name = name;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

}
