package cn.com.ratpack.RestfulModel.response;


import cn.com.ratpack.RestfulModel.util.CommonCode;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
public class CommonResponse<T>  implements Serializable {

    private static final long serialVersionUID = -3214885479484534221L;

    private T result;  //获取调用返回值

    private String code = "000000"; //获取错误码

    private String msg = "Success";

    public CommonResponse(){}

    public CommonResponse(CommonCode commonCode){
        this.code = commonCode.getCode();
        this.msg = commonCode.getMsg();
    }
}
