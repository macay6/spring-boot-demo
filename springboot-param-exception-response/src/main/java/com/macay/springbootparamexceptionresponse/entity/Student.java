package com.macay.springbootparamexceptionresponse.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassName: Student
 * @Description:
 * @Author: Macay
 * @Date: 2021/5/2 1:49 下午
 */

@Data
public class Student {

    @NotNull(message = "id不能为空")
    private Integer id;

    @NotBlank(message = "姓名不能为空 ")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    private String name;

    private String email;
    private Integer age;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
