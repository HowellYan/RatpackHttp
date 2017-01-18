package cn.com.ratpack.service;

import cn.com.ratpack.RestfulModel.response.base.ExternalResponse;
import cn.com.ratpack.restful.DefaultRequest;
import cn.com.ratpack.restful.DefaultResponse;
import cn.com.ratpack.restful.template.SingleTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Howell on 18/1/17.
 */
@Slf4j
public class LoginService extends SingleTemplate<DefaultRequest,DefaultResponse> {

    @Override
    protected ExternalResponse<DefaultResponse> callInner(DefaultRequest request) {
        log.info("---------LoginService----------");

        return null;
    }



}
