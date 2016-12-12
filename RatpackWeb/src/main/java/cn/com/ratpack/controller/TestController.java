package cn.com.ratpack.controller;

import net.sf.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import ratpack.exec.Promise;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.http.TypedData;

/**
 * Created by Howell on 12/12/16.
 */
@Controller
public class TestController {


    @Bean
    public Action<Chain> index() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","000000");

        return chain -> chain
                .get(ctx -> ctx
                        .render(jsonObject.toString())
                );
    }

    @Bean
    public Action<Chain> getName() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","100000");

        return PrefixChain -> PrefixChain.prefix("api/name", GChain -> GChain
                .all(context ->{
                    context.byMethod(method -> {
                        method.post(()->{
                            Promise<TypedData> json = context.getRequest().getBody();
                            System.out.println(context.getRequest().getContentType());
                            if(context.getRequest().getContentType().toString().contains("application/json")){
                                json.then(typedData ->{
                                    System.out.println("post:"+typedData.getText());
                                    context.getResponse().send(typedData.getText());
                                });
                            } else {
                                System.out.println("post:1");
                                jsonObject.put("code","090909");
                                jsonObject.put("msg","ContentType not 'application/json'");
                                context.getResponse().send(jsonObject.toString());
                            }
                        });
                        method.get(()->{
                            System.out.println(1);
                            jsonObject.put("code","090909");
                            context.getResponse().send(jsonObject.toString());
                        });
                    });
                })
        );
    }

}
