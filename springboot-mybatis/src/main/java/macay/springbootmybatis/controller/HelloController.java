package macay.springbootmybatis.controller;

import macay.springbootmybatis.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/4 9:51 上午
 */
@RestController
public class HelloController {

    @Resource
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "macay";
    }
}
