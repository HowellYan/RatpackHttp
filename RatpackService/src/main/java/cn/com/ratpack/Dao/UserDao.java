package cn.com.ratpack.Dao;

import cn.com.ratpack.ModelMapper.UserMapper;
import cn.com.ratpack.dbModel.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Howell on 13/12/16.
 */
@Service
@Slf4j
public class UserDao {
    @Resource
    private UserMapper userMapper;

    public UserModel findByID(String id){
        return userMapper.findByID(id);
    }


    public List<UserModel> findAll(){
        List<UserModel> list = userMapper.findAll();
        log.info("List size:"+list.size());


        return list;
    }

}
