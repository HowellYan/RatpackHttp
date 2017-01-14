package cn.com.ratpack.settings.redis;

import cn.com.ratpack.settings.properties.AppSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Created by Howell on 13/1/17.
 */
@Configuration
@Slf4j
public class RedisConnection {
    @Autowired
    AppSettings appSettings;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /**
     * redis sentinel config
     */
    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration() .master("mymaster")
                .sentinel("127.0.0.1", 26379) .sentinel("127.0.0.1", 26380) .sentinel("127.0.0.1", 26381);
        return new JedisConnectionFactory(sentinelConfig, jedisPoolConfig());
    }

    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxWaitMillis(300);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        return jedisPoolConfig;
    }

    public void set(final String key, final String value) {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key, value);
    }

    public String get(final String key) {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        return opsForValue.get(key);
    }

    public void delete(final String key) {
       redisTemplate.delete(key);
    }


}
