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

    String app_redis_database;
    String app_redis_host;
    String app_redis_password;
    String app_redis_pool_max_active;
    String app_redis_pool_max_idle;
    String app_redis_pool_max_wait;
    String app_redis_pool_min_idle;
    int app_redis_port;
    String app_redis_sentinel_master;
    String app_redis_sentinel_nodes;
    int app_redis_timeout;


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

    public String getApp_redis_database() {
        return app_redis_database;
    }

    public void setApp_redis_database(String app_redis_database) {
        this.app_redis_database = app_redis_database;
    }

    public String getApp_redis_host() {
        return app_redis_host;
    }

    public void setApp_redis_host(String app_redis_host) {
        this.app_redis_host = app_redis_host;
    }

    public String getApp_redis_password() {
        return app_redis_password;
    }

    public void setApp_redis_password(String app_redis_password) {
        this.app_redis_password = app_redis_password;
    }

    public String getApp_redis_pool_max_active() {
        return app_redis_pool_max_active;
    }

    public void setApp_redis_pool_max_active(String app_redis_pool_max_active) {
        this.app_redis_pool_max_active = app_redis_pool_max_active;
    }

    public String getApp_redis_pool_max_idle() {
        return app_redis_pool_max_idle;
    }

    public void setApp_redis_pool_max_idle(String app_redis_pool_max_idle) {
        this.app_redis_pool_max_idle = app_redis_pool_max_idle;
    }

    public String getApp_redis_pool_max_wait() {
        return app_redis_pool_max_wait;
    }

    public void setApp_redis_pool_max_wait(String app_redis_pool_max_wait) {
        this.app_redis_pool_max_wait = app_redis_pool_max_wait;
    }

    public String getApp_redis_pool_min_idle() {
        return app_redis_pool_min_idle;
    }

    public void setApp_redis_pool_min_idle(String app_redis_pool_min_idle) {
        this.app_redis_pool_min_idle = app_redis_pool_min_idle;
    }

    public int getApp_redis_port() {
        return app_redis_port;
    }

    public void setApp_redis_port(int app_redis_port) {
        this.app_redis_port = app_redis_port;
    }

    public String getApp_redis_sentinel_master() {
        return app_redis_sentinel_master;
    }

    public void setApp_redis_sentinel_master(String app_redis_sentinel_master) {
        this.app_redis_sentinel_master = app_redis_sentinel_master;
    }

    public String getApp_redis_sentinel_nodes() {
        return app_redis_sentinel_nodes;
    }

    public void setApp_redis_sentinel_nodes(String app_redis_sentinel_nodes) {
        this.app_redis_sentinel_nodes = app_redis_sentinel_nodes;
    }

    public int getApp_redis_timeout() {
        return app_redis_timeout;
    }

    public void setApp_redis_timeout(int app_redis_timeout) {
        this.app_redis_timeout = app_redis_timeout;
    }
}
