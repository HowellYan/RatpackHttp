package cn.com.ratpack.RestfulModel.response;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Winlone
 */
@Data
@ToString(callSuper = true)
public class CommonResponse<T>  implements Serializable {

    private static final long serialVersionUID = -3214885479484534221L;

    private T result;  //获取调用返回值

    private String errorCode; //获取错误码

    private String errorMsg;

}
