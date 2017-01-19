package cn.com.ratpack.service;

import cn.com.ratpack.ModelMapper.UserMapper;
import cn.com.ratpack.RestfulModel.response.base.ExternalResponse;
import cn.com.ratpack.RestfulModel.util.CommonCode;
import cn.com.ratpack.commons.Md5;
import cn.com.ratpack.dbModel.T_info_user;
import cn.com.ratpack.restful.DefaultRequest;
import cn.com.ratpack.restful.DefaultResponse;
import cn.com.ratpack.restful.DefaultRestfulModel;
import cn.com.ratpack.restful.template.SingleTemplate;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Howell on 18/1/17.
 */
@Slf4j
public class LoginService extends SingleTemplate<DefaultRequest, DefaultResponse, DefaultRestfulModel> {

    @Resource
    private UserMapper userMapper;

    @Override
    protected ExternalResponse<DefaultResponse> callInner(DefaultRequest request, DefaultRestfulModel model) {
        ExternalResponse<DefaultResponse> response = new ExternalResponse<DefaultResponse>();
        DefaultResponse defaultResponse = new DefaultResponse();

        //请求参数
        Map<String, String> reqMap = request.getRequest();

       // T_info_user t_info_user = userMapper.getInfoUser(reqMap.get("tel"), Md5.encode(reqMap.get("password")));
        T_info_user t_info_user = userMapper.findUser(reqMap.get("tel"));

        if(t_info_user != null){
            //响应模型

            Map<String, Object> respMap = model.getResponse().getResponse();
            log.info("getPassword:"+t_info_user.getPassword().toUpperCase());
            log.info("reqMap:"+Md5.encode(reqMap.get("password")));
            //校验密码
            if(t_info_user.getPassword().toUpperCase().equals(Md5.encode(reqMap.get("password")))){
                respMap.replace("T_info_user", t_info_user);
                defaultResponse.setResponse(respMap);
                response.setResult(defaultResponse);
            } else {
                response = new ExternalResponse<DefaultResponse>(CommonCode.LoginWrong_msg);
            }
        } else {
            response = new ExternalResponse<DefaultResponse>(CommonCode.UserWrong_msg);
        }

        return response;
    }



}
