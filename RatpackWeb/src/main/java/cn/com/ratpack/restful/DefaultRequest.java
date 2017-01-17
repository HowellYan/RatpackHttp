package cn.com.ratpack.restful;

import cn.com.ratpack.RestfulModel.request.CommonRequest;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Howell on 17/1/17.
 */
@Data
@ToString(callSuper = true)
public class DefaultRequest  extends CommonRequest implements Serializable {
    private Map<String, String>  request;
}
