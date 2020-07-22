package cn.study.l23.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 连接池工具类
 *  加载配置文件,配置连接池的参数
 *  提供获取连接的方法
 * @author Harlan
 * @date 2020/7/22 17:05
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;

    static {
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties props = new Properties();
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置config
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(props.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(props.getProperty("maxIdle")));

        //初始化连接池
        jedisPool = new JedisPool(config, props.getProperty("host"), Integer.parseInt(props.getProperty("port")));
    }


    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    public static void close(Jedis jedis){
        jedis.close();
    }
}
