package cn.com.ratpack.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ratpack.server.RatpackServer;

import static ratpack.spring.Spring.spring;

/**
 * Created by Howell on 12/12/16.
 */
public class Start {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .registry(spring(MyConfiguration.class))
                .handlers(chain -> chain
                        .get(ctx -> ctx
                                .render("Hello " + ctx.get(Service.class).message()))
                        .get(":message", ctx -> ctx
                                .render("Hello " + ctx.getPathTokens().get("message") + "!")
                        )
                )
        );
    }
}

@Configuration
class MyConfiguration {
    @Bean
    public Service service() {
        return () -> "World!";
    }
}

interface Service {
    String message();
}
