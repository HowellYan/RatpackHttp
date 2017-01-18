package cn.com.ratpack.RestfulModel.response.base;


import cn.com.ratpack.RestfulModel.response.CommonResponse;
import cn.com.ratpack.RestfulModel.util.CommonCode;
import lombok.ToString;

@ToString(callSuper = true)
public class ExternalResponse<T> extends CommonResponse<T> {
    public ExternalResponse(){
    }

    public ExternalResponse(CommonCode commonCode){
        this.setCode(commonCode.getCode());
        this.setMsg(commonCode.getMsg());
    }
}
