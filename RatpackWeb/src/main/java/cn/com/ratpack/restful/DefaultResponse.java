package cn.com.ratpack.restful;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Howell on 17/1/17.
 */
@Data
@ToString(callSuper = true)
public class DefaultResponse implements Serializable {
    private Map<String, Object> response;
}
