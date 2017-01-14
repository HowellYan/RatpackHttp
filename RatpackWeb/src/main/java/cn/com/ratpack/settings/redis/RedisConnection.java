package cn.com.ratpack.settings.redis;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.io.IOException;


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
        try {
            byte[] key_byte = IOUtils.toByteArray(key);
            byte[] value_byte = IOUtils.toByteArray(value);
            connection.set(key_byte, value_byte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(final String key) {
        try {
            byte[] key_byte = IOUtils.toByteArray(key);
            return IOUtils.toString(connection.get(key_byte));
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public void delete(final String key) {
        try {
            byte[] key_byte = IOUtils.toByteArray(key);
            connection.del(key_byte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
