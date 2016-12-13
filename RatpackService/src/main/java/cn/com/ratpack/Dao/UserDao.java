package cn.com.ratpack.Dao;

import cn.com.ratpack.ModelMapper.UserMapper;
import cn.com.ratpack.dbModel.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Howell on 13/12/16.
 */
@Service
public class UserDao {
    @Resource
    private UserMapper userMapper;

    public UserModel findByID(String id){
        return userMapper.findByID(id);
    }


}
