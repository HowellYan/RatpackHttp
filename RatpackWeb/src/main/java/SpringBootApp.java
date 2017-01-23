import cn.com.ratpack.settings.MyBatis.MyBatisLog;
import cn.com.ratpack.settings.Ratpack.StartRatpack;
import cn.com.ratpack.settings.properties.RatpackSettings;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Howell on 12/12/16.
 */
@SpringBootApplication
@StartRatpack
@ComponentScan({
        "cn.com.ratpack"
})
@MapperScan({
        "cn.com.ratpack"
})
@ImportResource({ "classpath:restful/*.xml", "classpath:restful/**/*.xml" })
public class SpringBootApp   {
    public static void main(String... args) throws Exception {
        org.apache.ibatis.logging.LogFactory.useCustomLogging(MyBatisLog.class);

        for (String i : args) {
            if(i.contains("-port=")){
                RatpackSettings.port = Integer.parseInt(i.replaceAll("-port=",""));
            }
        }

        SpringApplication.run(SpringBootApp.class, args);
    }
}


