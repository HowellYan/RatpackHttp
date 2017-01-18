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
    /**
     * 接口名称
     */
    private String action;

    /**
     * 方法类型
     */
    private String method;

    /**
     * 请求参数Model
     */
    private DefaultRequest request;

    /**
     * 响应参数Model
     */
    private DefaultResponse response;

    /**
     *
     */
    private boolean SqlStr;


    /**
     * SELECT、INSERT、UPDATE、DELETE、null
     */
    private String SqlDML;
}
