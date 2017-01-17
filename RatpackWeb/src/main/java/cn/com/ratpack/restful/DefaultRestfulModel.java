package cn.com.ratpack.restful;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * Created by Howell on 17/1/17.
 */
@Slf4j
@Data
public class DefaultRestfulModel implements Serializable {
    private String action;
    private String method;
    private DefaultRequest request;
    private DefaultResponse response;
}
