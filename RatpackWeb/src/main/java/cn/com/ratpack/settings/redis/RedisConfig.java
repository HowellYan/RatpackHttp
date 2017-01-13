package cn.com.ratpack.settings.redis;

import cn.com.ratpack.settings.properties.AppSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * Created by Howell on 20/12/16.
 */
@Configuration
@Slf4j
public class RedisConfig {
    @Autowired
    AppSettings appSettings;

    /**
     * jedis
     */
    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration() .master("mymaster")
                .sentinel("127.0.0.1", 26379) .sentinel("127.0.0.1", 26380) .sentinel("127.0.0.1", 26381);
        return new JedisConnectionFactory(sentinelConfig);
    }

    /**
     * lettuce
     */
    @Bean
    public RedisConnectionFactory lettuceConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
                .sentinel("127.0.0.1", 26379) .sentinel("127.0.0.1", 26380) .sentinel("127.0.0.1", 26381);
        return new LettuceConnectionFactory(sentinelConfig);
    }

}
