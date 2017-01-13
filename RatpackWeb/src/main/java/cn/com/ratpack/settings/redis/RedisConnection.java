package cn.com.ratpack.settings.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import redis.clients.util.IOUtils;

/**
 * Created by Howell on 13/1/17.
 */
@Configuration
public class RedisConnection {
    private RedisClusterConnection connection;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    public RedisConnection(){
        connection = redisConnectionFactory.getClusterConnection();
    }

    public void set(final String key, final String value) {

        connection.set();
    }

    public String get(final String key) {
        return connection.get();
    }

    public void delete(final String key) {
        connection.del();
    }


}
