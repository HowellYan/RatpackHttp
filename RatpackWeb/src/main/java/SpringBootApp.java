import cn.com.ratpack.settings.StartRatpack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Howell on 12/12/16.
 */
@SpringBootApplication
@StartRatpack
@ComponentScan({
        "cn.com.ratpack.controller",
        "cn.com.ratpack.settings"
})
public class SpringBootApp  {
    public static void main(String... args) throws Exception {
        SpringApplication.run(SpringBootApp.class, args);
    }
}


