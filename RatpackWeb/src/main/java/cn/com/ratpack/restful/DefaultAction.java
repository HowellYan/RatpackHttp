package cn.com.ratpack.restful;

import cn.com.ratpack.RestfulModel.response.base.ExternalResponse;
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
public class DefaultAction extends SingleTemplate<DefaultRequest, DefaultResponse> {

    @Override
    protected ExternalResponse<DefaultResponse> callInner(DefaultRequest request) {
        return null;
    }



    public Action<Chain> restfulAction(@Autowired DefaultRestfulModel defaultRestfulModel) {
        log.info("Action: "+ defaultRestfulModel.getAction());
        return PrefixChain -> PrefixChain.prefix(defaultRestfulModel.getAction(), GChain -> GChain
                .all(context ->{
                    context.byMethod(method -> {
                        if(defaultRestfulModel.getMethod().equals("post")){
                            method.post(()->{
                                Promise<TypedData> json = context.getRequest().getBody(); // 请求数据
                                log.info("ContentType :"+context.getRequest().getContentType());


                                DefaultRequest defaultRequest = defaultRestfulModel.getRequest();
                                Map<String, String> request = defaultRequest.getRequest(); // 请求参数模板


                                if(context.getRequest().getContentType().toString().contains("application/json")){
                                    json.then(typedData ->{
                                        JSONObject jsonRes = JSONObject.fromObject(typedData.getText());

                                        request.forEach((k,v)->{
                                            jsonRes.get(k);

                                        });

                                        context.getResponse().send("ok");
                                    });
                                } else {
                                    context.getResponse().send("ok");
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

}
