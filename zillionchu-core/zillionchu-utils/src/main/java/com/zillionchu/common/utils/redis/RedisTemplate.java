package com.zillionchu.common.utils.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.io.Serializable;
import java.util.Set;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-06-04 16:35
 * @Description:
 */
public class RedisTemplate {
    private Serializer serializer;
    private JedisPool jedisPool;

    public Serializer getSerializer()
    {
        return this.serializer;
    }
    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }
    public JedisPool getJedisPool() {
        return this.jedisPool;
    }
    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public Object execute(RedisCallback redisCallback)
    {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return redisCallback.doInRedis(jedis, this.serializer);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public long incr(String key) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.incr(key).longValue();
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public boolean exists(String key)
    {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key).booleanValue();
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public boolean exists(byte[] key) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key).booleanValue();
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long del(String key) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(key);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long del(byte[] key) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(key);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public String setex(String key, int seconds, String value)
    {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.setex(key, seconds, value);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public String set(String key, String value)
    {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.set(key, value);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public String get(String key)
    {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public String hget(String key, String field) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.hget(key, field);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long hset(String key, String field, String value)
    {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.hset(key, field, value);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long hsetex(String key, int seconds, String field, String value) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            String luaScript = "\r\nlocal ret = tonumber(redis.call('HSET', '" + key + "','" + field + "','" + value + "'));\r\nredis.call('EXPIRE','" + key + "','" + seconds + "');\r\nreturn ret";

            Long ret = (Long)jedis.eval(luaScript);
            return ret;
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long setnxex(String key, int seconds, String value) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            String luaScript = "\r\nlocal ret = tonumber(redis.call('SETNX', '" + key + "','" + value + "'));\r\nredis.call('EXPIRE','" + key + "','" + seconds + "');\r\nreturn ret";

            Long ret = (Long)jedis.eval(luaScript);
            return ret;
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Object get(byte[] key) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            byte[] ret = jedis.get(key);
            Object localObject1;
            if (ret == null) { localObject1 = null;
                return localObject1; }
            return this.serializer.deserialize(ret);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Object getex(byte[] key, int seconds) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            byte[] ret = jedis.get(key);
            Object localObject1;
            if (ret == null) { localObject1 = null;
                return localObject1; }
            jedis.expire(key, seconds);
            return this.serializer.deserialize(ret);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Object hget(byte[] key, byte[] field) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            byte[] ret = jedis.hget(key, field);
            Object localObject1;
            if (ret == null) { localObject1 = null;
                return localObject1; }
            return this.serializer.deserialize(ret);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public void set(byte[] key, Serializable obj)
    {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, this.serializer.serialize(obj));
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public void setex(byte[] key, int seconds, Serializable obj)
    {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            jedis.setex(key, seconds, this.serializer.serialize(obj));
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public void hset(byte[] key, byte[] field, Serializable obj) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(key, field, this.serializer.serialize(obj));
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long sadd(String key, String[] members) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.sadd(key, members);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long sadd(byte[] key, Serializable[] members) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            byte[][] arrays = new byte[members.length][];
            int i = 0;
            for (Serializable m : members) {
                arrays[(i++)] = this.serializer.serialize(m);
            }
            return jedis.sadd(key, arrays);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Set<String> smembers(String key) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.smembers(key);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long srem(String key, String[] members) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.srem(key, members);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long srem(byte[] key, Serializable[] members) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            byte[][] arrays = new byte[members.length][];
            int i = 0;
            for (Serializable m : members) {
                arrays[(i++)] = this.serializer.serialize(m);
            }
            return jedis.srem(key, arrays);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Set<byte[]> smembers(byte[] key) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.smembers(key);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Set<String> keys(String key) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.keys(key);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long expire(String key, int seconds) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.expire(key, seconds);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public Long expire(byte[] key, int seconds) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = null; boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return jedis.expire(key, seconds);
        }
        catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public static void main(String[] args) {
        JedisPool jp = new JedisPool("127.0.0.1", 6379);
        RedisTemplate rt = new RedisTemplate();
        rt.setJedisPool(jp);
        rt.setSerializer(new JavaSerializer());
        rt.set("abc11","aaaaaazzzz");
        System.out.println(rt.get("abc"));
    }
}
