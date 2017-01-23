package cn.com.ratpack.settings.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Howell on 12/12/16.
 */
@Configuration
@ConfigurationProperties(prefix = "ratpack",locations = "classpath:config/ratpack.properties")
public class RatpackSettings {
    public static Integer port = 0;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        if(this.port == 0){
            this.port = port;
        }
    }

}
