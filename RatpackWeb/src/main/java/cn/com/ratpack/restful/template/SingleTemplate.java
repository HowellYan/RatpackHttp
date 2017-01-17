package cn.com.ratpack.restful.template;


import cn.com.ratpack.RestfulModel.request.CommonRequest;
import cn.com.ratpack.RestfulModel.response.base.ExternalResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 公用抽象模板
 * Winlone 2015.5.6
 *
 * @param <Request>    最外层请求对象
 * @param <Response> 最外层结果对象
 */
@Slf4j
public abstract class SingleTemplate<Request extends CommonRequest, Response> {
    /**
     * 外层call
     * @param request
     * @return
     */
    public ExternalResponse<Response> call(Request request) {
        ExternalResponse<Response> response = null;
        try {
            //请求remote
            response = callInner(request);
        } catch (Exception e) {
            log.error("[{}] Request验证不通过,类:[{}],请求:[{}],异常:[{}]", request.getKeep(), this.getClass().getName(), request.toString(), e);
            response = new ExternalResponse<Response>();
            response.setErrorCode("999999");
            response.setErrorMsg("Request验证不通过");
        }
        return response;
    }

    /**
     * 子类模板实现：request转换 -> 请求remote -> response转换
     */
    protected abstract ExternalResponse<Response> callInner(Request request);
}
