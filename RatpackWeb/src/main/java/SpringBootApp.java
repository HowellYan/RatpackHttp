import cn.com.ratpack.settings.MyBatis.MyBatisLog;
import cn.com.ratpack.settings.Ratpack.StartRatpack;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
public class SpringBootApp   {

    public static void main(String... args) throws Exception {
        // org.apache.ibatis.logging.LogFactory.useSlf4jLogging();
        // org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        // org.apache.ibatis.logging.LogFactory.useCommonsLogging();
        // org.apache.ibatis.logging.LogFactory.useStdOutLogging();
         org.apache.ibatis.logging.LogFactory.useCustomLogging(MyBatisLog.class);


        SpringApplication.run(SpringBootApp.class, args);
    }

}


