package cn.com.ratpack.web;

import net.sf.json.JSONObject;
import ratpack.handling.Handler;
import ratpack.registry.Registry;
import ratpack.server.RatpackServer;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ratpack.jackson.Jackson.json;

/**
 * Created by Howell on 6/12/16.
 */
public class Test {


    public static void main(String[] args) throws Exception {
        String path = Test.class.getResource("/").toString();
        System.out.println(path+"app");
        Path baseDir = Paths.get(new URI(path+"app")).toAbsolutePath();

        new Test().start(baseDir);
    }

    public void start(final Path baseDir) throws Exception {
        RatpackServer.start(server ->
                server.registry(Registry.single(new JSONObject()))
                        .handlers(chain ->
                                chain.get(ctx -> ctx.insert(
                                        addOutput("a","Hello"),
                                        addOutput("b","World"),
                                        ctx3 -> ctx3.render(json(ctx3.get(JSONObject.class)))
                                ))
                        ).serverConfig(serverConfigBuilder -> serverConfigBuilder.port(9090))
        );
    }

    private Handler addOutput(final Object key, final Object value) {
        return ctx -> {
            ctx.get(JSONObject.class).put(key, value);
            ctx.next();
        };
    }

}