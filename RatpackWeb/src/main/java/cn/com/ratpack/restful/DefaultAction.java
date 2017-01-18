package cn.com.ratpack.restful;

import cn.com.ratpack.RestfulModel.response.CommonResponse;
import cn.com.ratpack.RestfulModel.util.CommonCode;
import cn.com.ratpack.restful.template.SingleTemplate;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ratpack.exec.Promise;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.http.TypedData;

import java.util.Map;

/**
 * Created by Howell on 17/1/17.
 */
@Controller
@Slf4j
public class DefaultAction {

    public Action<Chain> restfulAction(@Autowired DefaultRestfulModel defaultRestfulModel,
                                       @Autowired SingleTemplate<DefaultRequest, DefaultResponse, DefaultRestfulModel> singleTemplate) {
        log.info("Action: "+ defaultRestfulModel.getAction());

        DefaultRequest defaultRequest = defaultRestfulModel.getRequest();
        String SqlDML = defaultRestfulModel.getSqlDML();

        return PrefixChain -> PrefixChain.prefix(defaultRestfulModel.getAction(), GChain -> GChain
                .all(context ->{
                    context.byMethod(method -> {
                        if(defaultRestfulModel.getMethod().equals("post")){
                            method.post(()->{
                                Promise<TypedData> json = context.getRequest().getBody(); // 请求数据
                                log.info("ContentType :"+context.getRequest().getContentType());

                                Map<String, String> request = defaultRequest.getRequest(); // 请求参数模板

                                if(context.getRequest().getContentType().toString().contains("application/json")){
                                    json.then(typedData ->{
                                        JSONObject jsonRes = JSONObject.fromObject(typedData.getText());

                                        request.forEach((k,v) -> {
                                            request.replace(k, jsonRes.getString(k));
                                        });
                                        defaultRequest.setRequest(request);
                                        //判断
                                        if(singleTemplate != null){
                                            CommonResponse<DefaultResponse> response = singleTemplate.call(defaultRequest, defaultRestfulModel);
                                            context.getResponse().send(JSONObject.fromObject(response).toString());
                                        } else if (SqlDML != null){
                                            CommonResponse<DefaultResponse> response = null;
                                            switch (SqlDML) {
                                                case "SELECT":
                                                    response = SELECT(defaultRestfulModel);
                                                case "INSERT":
                                                    response = INSERT(defaultRestfulModel);
                                                case "UPDATE":
                                                    response = UPDATE(defaultRestfulModel);
                                                case "DELETE":
                                                    response = DELETE(defaultRestfulModel);
                                                    default:
                                                        response = new CommonResponse<DefaultResponse>(CommonCode.Configuration_msg);
                                            }
                                            context.getResponse().send(JSONObject.fromObject(response).toString());
                                        } else {
                                            CommonResponse<DefaultResponse> response = new  CommonResponse<DefaultResponse>(CommonCode.Configuration_msg);
                                            context.getResponse().send(JSONObject.fromObject(response).toString());
                                        }
                                    });
                                } else {
                                    CommonResponse<DefaultResponse> response = new  CommonResponse<DefaultResponse>(CommonCode.ContentType_msg);
                                    context.getResponse().send(JSONObject.fromObject(response).toString());
                                }
                            });
                        } else if(defaultRestfulModel.getMethod().equals("get")) {
                            method.get(()->{
                                context.getResponse().send("ok");
                            });
                        }

                    });
                })
        );

    }

    public CommonResponse<DefaultResponse> SELECT(DefaultRestfulModel defaultRestfulModel){

        CommonResponse<DefaultResponse> response = new  CommonResponse<DefaultResponse>();
        DefaultResponse defaultResponse = defaultRestfulModel.getResponse();
        Map<String, Object> map = defaultResponse.getResponse();
        map.forEach((k,v)->{
            //todo
            map.put(k, "123");
        });

        defaultResponse.setResponse(map);
        response.setResult(defaultResponse);

        return response;
    }

    public CommonResponse<DefaultResponse> INSERT(DefaultRestfulModel defaultRestfulModel){
        return null;
    }

    public CommonResponse<DefaultResponse> UPDATE(DefaultRestfulModel defaultRestfulModel){
        return null;
    }

    public CommonResponse<DefaultResponse> DELETE(DefaultRestfulModel defaultRestfulModel){
        return null;
    }

}
