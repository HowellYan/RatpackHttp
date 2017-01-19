package cn.com.ratpack.ModelMapper;

import cn.com.ratpack.dbModel.UserModel;
import cn.com.ratpack.dbModel.T_info_user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Howell on 13/12/16.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM DB_User WHERE u_id = #{ID}")
    UserModel findByID(@Param("ID") String ID);

    @Select("SELECT * FROM DB_User")
    List<UserModel> findAll();

    @Select("SELECT * from T_info_user where tel=#{tel} and password=#{password}")
    T_info_user getInfoUser(@Param("tel") String tel, @Param("password") String password);

    @Select("SELECT * from T_info_user where tel=#{tel}")
    T_info_user findHaveUser(@Param("tel") String tel);

    T_info_user findUser(@Param("tel") String tel);

}
