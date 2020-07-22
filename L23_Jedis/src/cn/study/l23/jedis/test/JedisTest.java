package cn.study.l23.jedis.test;

import cn.study.l23.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Jedis测试类
 * @author Harlan
 * @date 2020/7/22 15:57
 */
public class JedisTest {

    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        jedis.set("username", "Jack");
        String username = jedis.get("username");

        System.out.println(username);
        //3.关闭
        jedis.close();
    }

    /**
     * 测试连接池工具类
     */
    @Test
    public void pool(){
        Jedis jedis = JedisPoolUtils.getJedis();
        String username = jedis.get("username");
        System.out.println(username);
        JedisPoolUtils.close(jedis);
    }
}
