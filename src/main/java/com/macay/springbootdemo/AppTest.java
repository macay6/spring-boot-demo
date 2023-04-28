package com.macay.springbootdemo;

import org.springframework.beans.BeanUtils;

/**
 * @ClassName: AppTest
 * @Description:
 * @Author: Macay
 * @Date: 2022/8/6 3:33 下午
 */
public class AppTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation();
        Classes classes = new Classes();
        classes.setName("三级级二班");
        citation.setClasses(classes);
        citation.setName("张三");
        citation.setContent(" 在2020学年第一学期中表现优秀，被评为三好学生。特发此状！");
        citation.setSchool("徐信小学");
        Citation citation1 = new Citation();
        // 使用BeanUtils复制对象
        BeanUtils.copyProperties(citation, citation1);
        citation1.getClasses().setName("lisi");
        citation.show();
        citation1.show();
    }
}
