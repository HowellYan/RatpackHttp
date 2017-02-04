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
     * @return RedisConnectionFactory
     */
    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration();

        String master = appSettings.getRedis_sentinel_master();
        String nodes = appSettings.getRedis_sentinel_nodes();
        String[] nodesArray = nodes.split(",");

        sentinelConfig.master(master);
        for (int i=0; i < nodesArray.length; i++){
            String[] node = nodesArray[i].split(":");
            sentinelConfig.sentinel(node[0], Integer.parseInt(node[1]));
        }
        return new JedisConnectionFactory(sentinelConfig, jedisPoolConfig());
    }


    /**
     * redis pool config
     * @return JedisPoolConfig
     */
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
