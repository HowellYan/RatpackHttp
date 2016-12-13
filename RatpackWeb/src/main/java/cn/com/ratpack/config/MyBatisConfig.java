package cn.com.ratpack.config;

import cn.com.ratpack.settings.AppSettings;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.scenario.Settings;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Howell on 13/12/16.
 */

@Configuration
@Slf4j
public class MyBatisConfig {

    @Autowired
    AppSettings appSettings;

    @Bean
    public DataSource getDataSource() throws Exception{
        Properties props = new Properties();
        props.put("driverClassName",appSettings.getMysql_aliyun_driver());
        props.put("url", appSettings.getMysql_aliyun_url());
        props.put("username", appSettings.getMysql_aliyun_user());
        props.put("password", appSettings.getMysql_aliyun_pass());
//        props.put("maxActive", appSettings.getMysql_aliyun_maxActive());
//        props.put("maxIdle",appSettings.getMysql_aliyun_maxIdel());
//        props.put("maxWait",appSettings.getMysql_aliyun_maxWait());
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     *  根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();



        fb.setDataSource(ds);//指定数据源(这个必须有，否则报错)
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage("cn.com.ratpack");//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));//指定xml文件位置
        return fb.getObject();
    }



}
