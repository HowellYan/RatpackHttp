package cn.com.ratpack.RestfulModel.response.base;


import cn.com.ratpack.RestfulModel.response.CommonResponse;
import lombok.ToString;

/**
 * Created by winlone
 * Date: 2016-8-8.
 */
@ToString(callSuper = true)
public class ExternalResponse<T> extends CommonResponse<T> {
}
