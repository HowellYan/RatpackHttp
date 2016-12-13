package cn.com.ratpack.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Howell on 13/12/16.
 */
@Configuration
@ConfigurationProperties(prefix = "app",locations = "classpath:config/app.properties")
public class AppSettings {

}
