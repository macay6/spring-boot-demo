package macay.springbootmybatis.mapper;

import macay.springbootmybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/4 10:04 上午
 */
@Mapper
public interface UserMapper {

    List<User> selectUserList();
}
