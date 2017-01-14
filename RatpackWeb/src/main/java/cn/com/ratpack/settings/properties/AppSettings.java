package cn.com.ratpack.settings.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Howell on 13/12/16.
 */
@Configuration
@ConfigurationProperties(prefix = "app",locations = "classpath:config/app.properties")
public class AppSettings {
    String mysql_aliyun;
    String mysql_aliyun_user;
    String mysql_aliyun_pass;
    String mysql_aliyun_driver;
    String mysql_aliyun_url;
    String mysql_aliyun_maxActive;
    String mysql_aliyun_minIdle;
    String mysql_aliyun_maxWait;
    String mysql_aliyun_timeBetweenEvictionRunsMillis;
    String redis_pool_maxTotal;
    String redis_pool_maxIdle;
    String redis_pool_maxWaitMillis;
    String redis_pool_testOnBorrow;
    String redis_pool_testOnReturn;
    String redis_sentinel_master;
    String redis_sentinel_nodes;

    public String getMysql_aliyun() {
        return mysql_aliyun;
    }

    public void setMysql_aliyun(String mysql_aliyun) {
        this.mysql_aliyun = mysql_aliyun;
    }

    public String getMysql_aliyun_user() {
        return mysql_aliyun_user;
    }

    public void setMysql_aliyun_user(String mysql_aliyun_user) {
        this.mysql_aliyun_user = mysql_aliyun_user;
    }

    public String getMysql_aliyun_pass() {
        return mysql_aliyun_pass;
    }

    public void setMysql_aliyun_pass(String mysql_aliyun_pass) {
        this.mysql_aliyun_pass = mysql_aliyun_pass;
    }

    public String getMysql_aliyun_driver() {
        return mysql_aliyun_driver;
    }

    public void setMysql_aliyun_driver(String mysql_aliyun_driver) {
        this.mysql_aliyun_driver = mysql_aliyun_driver;
    }

    public String getMysql_aliyun_url() {
        return mysql_aliyun_url;
    }

    public void setMysql_aliyun_url(String mysql_aliyun_url) {
        this.mysql_aliyun_url = mysql_aliyun_url;
    }

    public String getMysql_aliyun_maxActive() {
        return mysql_aliyun_maxActive;
    }

    public void setMysql_aliyun_maxActive(String mysql_aliyun_maxActive) {
        this.mysql_aliyun_maxActive = mysql_aliyun_maxActive;
    }

    public String getMysql_aliyun_minIdle() {
        return mysql_aliyun_minIdle;
    }

    public void setMysql_aliyun_minIdle(String mysql_aliyun_minIdle) {
        this.mysql_aliyun_minIdle = mysql_aliyun_minIdle;
    }

    public String getMysql_aliyun_maxWait() {
        return mysql_aliyun_maxWait;
    }

    public void setMysql_aliyun_maxWait(String mysql_aliyun_maxWait) {
        this.mysql_aliyun_maxWait = mysql_aliyun_maxWait;
    }

    public String getMysql_aliyun_timeBetweenEvictionRunsMillis() {
        return mysql_aliyun_timeBetweenEvictionRunsMillis;
    }

    public void setMysql_aliyun_timeBetweenEvictionRunsMillis(String mysql_aliyun_timeBetweenEvictionRunsMillis) {
        this.mysql_aliyun_timeBetweenEvictionRunsMillis = mysql_aliyun_timeBetweenEvictionRunsMillis;
    }

    public String getRedis_pool_maxTotal() {
        return redis_pool_maxTotal;
    }

    public void setRedis_pool_maxTotal(String redis_pool_maxTotal) {
        this.redis_pool_maxTotal = redis_pool_maxTotal;
    }

    public String getRedis_pool_maxIdle() {
        return redis_pool_maxIdle;
    }

    public void setRedis_pool_maxIdle(String redis_pool_maxIdle) {
        this.redis_pool_maxIdle = redis_pool_maxIdle;
    }

    public String getRedis_pool_maxWaitMillis() {
        return redis_pool_maxWaitMillis;
    }

    public void setRedis_pool_maxWaitMillis(String redis_pool_maxWaitMillis) {
        this.redis_pool_maxWaitMillis = redis_pool_maxWaitMillis;
    }

    public String getRedis_pool_testOnBorrow() {
        return redis_pool_testOnBorrow;
    }

    public void setRedis_pool_testOnBorrow(String redis_pool_testOnBorrow) {
        this.redis_pool_testOnBorrow = redis_pool_testOnBorrow;
    }

    public String getRedis_pool_testOnReturn() {
        return redis_pool_testOnReturn;
    }

    public void setRedis_pool_testOnReturn(String redis_pool_testOnReturn) {
        this.redis_pool_testOnReturn = redis_pool_testOnReturn;
    }

    public String getRedis_sentinel_master() {
        return redis_sentinel_master;
    }

    public void setRedis_sentinel_master(String redis_sentinel_master) {
        this.redis_sentinel_master = redis_sentinel_master;
    }

    public String getRedis_sentinel_nodes() {
        return redis_sentinel_nodes;
    }

    public void setRedis_sentinel_nodes(String redis_sentinel_nodes) {
        this.redis_sentinel_nodes = redis_sentinel_nodes;
    }
}
