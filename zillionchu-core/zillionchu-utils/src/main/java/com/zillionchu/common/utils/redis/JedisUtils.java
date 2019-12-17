package com.zillionchu.common.utils.redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-06-04 16:37
 * @Description:
 */
public class JedisUtils {

    private static final Logger logger = Logger.getLogger(IdGenerator.class);

    public static void closeResource(JedisPool jedisPool, Jedis jedis, boolean conectionBroken) {
        try {
            jedis.close();
        } catch (Exception e) {
            logger.error("return back jedis failed, will fore close the jedis.", e);
            destroyJedis(jedis);
        }
    }

    public static void destroyJedis(Jedis jedis) {
        if ((jedis == null) || (!jedis.isConnected())) return;
        try {
            try {
                jedis.quit();
            } catch (Exception localException) {
            }
            jedis.disconnect();
        } catch (Exception localException1) {
        }
    }

    public static boolean handleJedisException(JedisPool jedisPool, JedisException jedisException) {
        if (jedisException instanceof JedisConnectionException)
            logger.error("Redis connection  lost.", jedisException);
        else if (jedisException instanceof JedisDataException)
            if ((jedisException.getMessage() == null) || (jedisException.getMessage().indexOf("READONLY") == -1)) {
                return false;
            } else {
                logger.error("Jedis exception happen.", jedisException);
            }
        return true;
    }
}
