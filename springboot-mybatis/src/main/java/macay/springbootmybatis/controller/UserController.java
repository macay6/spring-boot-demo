package macay.springbootmybatis.controller;

import macay.springbootmybatis.model.User;
import macay.springbootmybatis.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/4 9:56 上午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/getUsers")
    public List<User> getUserList() {
        return userService.getUserList();
    }
}

