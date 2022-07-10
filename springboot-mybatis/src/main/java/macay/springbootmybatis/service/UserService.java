package macay.springbootmybatis.service;

import macay.springbootmybatis.mapper.UserMapper;
import macay.springbootmybatis.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/4 10:02 上午
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    public List<User> getUserList() {
        return userMapper.selectUserList();
    }
}
