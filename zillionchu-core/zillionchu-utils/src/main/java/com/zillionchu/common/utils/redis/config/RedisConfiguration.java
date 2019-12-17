package com.zillionchu.common.utils.redis.config;/*
package com.github.zilionchu.core.zillionchucore.utils.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitbub.zillionchu.admin.portal.utils.redis.IdGenerator;
import com.gitbub.zillionchu.admin.portal.utils.redis.RedisTemplate;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.util.Pool;

import java.util.*;


*/
/**
 * redis配置
 *
 *
 *//*

@Configuration
public class RedisConfiguration implements EnvironmentAware {

    private String host;
    private int port;
    private int maxTotal;
    private int timeout;
    private String clusterNodes;
    private String mymaster;
    private Integer readTimeout;

    @Override
    public void setEnvironment(Environment environment) {
        this.host = environment.getProperty("spring.redis.host");
        this.port = Integer.valueOf(environment.getProperty("spring.redis.port"));
        this.maxTotal = Integer.valueOf(environment.getProperty("spring.redis.pool.max-active"));
        this.timeout = Integer.valueOf(environment.getProperty("spring.redis.timeout"));
        this.clusterNodes = environment.getProperty("spring.redis.nodes");
        this.mymaster = environment.getProperty("spring.redis.mymaster");
        this.readTimeout = Integer.valueOf(environment.getProperty("spring.redis.readTimeout"));
        Pool<Jedis> jedisPool = jedisPool();
        buildRedisTemplate(jedisPool);
        buildIdGenerator(jedisPool);
    }

    @Bean
    protected Pool<Jedis> jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(this.maxTotal);
        Set<String> nodes = new HashSet<>(Arrays.asList(this.clusterNodes.split(",")));
        return new JedisSentinelPool(this.mymaster, nodes, jedisPoolConfig, readTimeout);
    }


    @Bean
    protected RedisTemplate buildRedisTemplate(Pool<Jedis> jedisPool) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setJedisPool(jedisPool);
        Jackson2JsonRedisSerializerExpand jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializerExpand(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }

    @Bean
    protected RedisLockTemplate buildRedisLockTemplate(Pool<Jedis> jedisPool) {
        RedisLockTemplate redisTemplate = new RedisLockTemplate();
        redisTemplate.setJedisPool(jedisPool);
        return redisTemplate;
    }

    @Bean
    protected IdGenerator buildIdGenerator(Pool<Jedis> jedisPool) {
        List<Pool<Jedis>> jedisPools = new ArrayList<>();
        jedisPools.add(jedisPool);
        IdGenerator idGenerator = new IdGenerator();
        //idGenerator.setJedisPools(jedisPools);
        return idGenerator;
    }

}
*/
