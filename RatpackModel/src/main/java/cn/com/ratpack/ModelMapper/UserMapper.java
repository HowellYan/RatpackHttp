package cn.com.ratpack.ModelMapper;

import cn.com.ratpack.dbModel.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Howell on 13/12/16.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM wp_users WHERE ID = #{ID}")
    UserModel findByID(@Param("ID") String ID);

    @Select("SELECT * FROM wp_users")
    List<UserModel> findAll();

}
