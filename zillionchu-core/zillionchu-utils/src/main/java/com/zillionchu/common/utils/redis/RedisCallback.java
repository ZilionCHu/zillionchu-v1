package com.zillionchu.common.utils.redis;

import redis.clients.jedis.Jedis;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-06-04 16:42
 * @Description:
 */
public abstract interface RedisCallback {

    public abstract Object doInRedis(Jedis paramJedis, Serializer paramSerializer);
}
