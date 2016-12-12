package cn.com.ratpack.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Howell on 12/12/16.
 */
@Configuration
@ConfigurationProperties(prefix = "ratpack",locations = "classpath:config/ratpack.properties")
public class RatpackSettings {
    private Integer port;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}
