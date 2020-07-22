# Jedis

> Java操作redis数据库的工具

1. 使用步骤

   1. 下载jedis的jar包 **https://mvnrepository.com/artifact/redis.clients/jedis**

   2. 操作

      ```java
      @Test
      public void test1(){
      	//1.获取连接
      	Jedis jedis = new Jedis("localhost", 6379);
      	//2.操作
      	jedis.set("username", "Jack");
          
      	//3.关闭
      	jedis.close();
      }
      ```

      

2. Jedis 连接池

   ```java
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
   ```

   