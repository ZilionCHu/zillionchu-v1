package com.zillionchu.common.utils.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-06-04 16:59
 * @Description:
 */
public class IdGenerator {

    private List<JedisPool> jedisPools;
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'};

    public List<JedisPool> getJedisPools() {
        return this.jedisPools;
    }

    public void setJedisPools(List<JedisPool> jedisPools) {
        this.jedisPools = jedisPools;
    }

    private List<Long> generatIdMeta(int jedisPoolIdx, String miliSecondKey) {
        if ((this.jedisPools == null) || (this.jedisPools.size() == 0)) {
            return new ArrayList();
        }
        JedisPool jedisPool = (JedisPool) this.jedisPools.get(jedisPoolIdx);
        int startStep = jedisPoolIdx;
        int step = this.jedisPools.size();
        String luaScript = "\r\nlocal step = " + step + ";\r\nlocal key = '" + miliSecondKey + "';\r\nlocal count;" +
                "\r\nrepeat\r\n  count = tonumber(redis.call('INCRBY', key, step));\r\nuntil count < (1024 - step)" +
                "\r\nif count == step then\r\n  redis.call('PEXPIRE', key, 1);\r\nend\r\nlocal now = redis.call" +
                "('TIME');\r\nreturn {tonumber(now[1]), tonumber(now[2]), count + " + startStep + "}";

        Jedis jedis = null;
        boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            return (List) jedis.eval(luaScript);
        } catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public long generatIdByIncr(String key) {
        key = "_incr_" + key;
        if ((this.jedisPools == null) || (this.jedisPools.size() == 0)) {
            return -1L;
        }
        JedisPool jedisPool = (JedisPool) this.jedisPools.get(0);
        int maxMantissa = 4194304;
        String luaScript = "\r\nlocal count = tonumber(redis.call('INCR', '" + key + "'));\r\nif count >= " +
                (maxMantissa - 1) + " then\r\n  redis.call('DEL', '" + key + "');\r\nend\r\nlocal now = redis.call" +
                "('TIME');\r\nreturn {tonumber(now[1]), tonumber(now[2]), count}";

        Jedis jedis = null;
        boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            List rs = (List) jedis.eval(luaScript);
            long second = ((Long) rs.get(0)).longValue();
            long microSecond = ((Long) rs.get(1)).longValue();
            long seq = ((Long) rs.get(2)).longValue();
            return buildIdBit(second, microSecond, seq);
        } catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public long generatIdByIncr(String key, int expire) {
        key = "_incr_" + key;
        if ((this.jedisPools == null) || (this.jedisPools.size() == 0)) {
            return -1L;
        }
        JedisPool jedisPool = (JedisPool) this.jedisPools.get(0);
        String luaScript = "\r\nlocal count = tonumber(redis.call('INCR', '" + key + "'));\r\nredis.call('EXPIRE', '"
                + key + "', " + expire + ");\r\nreturn count";

        Jedis jedis = null;
        boolean broken = false;
        try {
            jedis = jedisPool.getResource();
            Long ret = (Long) jedis.eval(luaScript);
            return ret.longValue();
        } catch (JedisException e) {
            throw e;
        } finally {
            JedisUtils.closeResource(jedisPool, jedis, broken);
        }
    }

    public long generatShardId(String shardName, long shardId) {
        int startStep = (int) shardId % this.jedisPools.size();
        shardId %= 4096L;
        List meta = generatIdMeta(startStep, "_gsid_" + shardName + "_" + shardId);
        return buildId64Bit(((Long) meta.get(0)).longValue(), ((Long) meta.get(1)).longValue(), ((Long) meta.get(2))
                .longValue(), shardId);
    }

    private static long buildId64Bit(long second, long microSecond, long seq, long shardId) {
        long miliSecond = second * 1000L + microSecond / 1000L;
        return (miliSecond << 22) + (shardId << 10) + seq;
    }

    private static long buildIdBit(long second, long microSecond, long seq) {
        long miliSecond = second * 1000L + microSecond / 1000L;
        return (miliSecond << 10) + seq;
    }

    protected static List<Long> parseId(long id) {
        long miliSecond = id >>> 22;

        long shardId = (id & 0x3FFC00) >> 10;
        long seq = id & 0x3FF;

        List re = new ArrayList(4);
        re.add(Long.valueOf(miliSecond));
        re.add(Long.valueOf(shardId));
        re.add(Long.valueOf(seq));
        return re;
    }

    public static long parseShardId(long id) {
        long shardId = (id & 0x3FFC00) >> 10;
        return shardId;
    }

    public static long parseMiliSecond(long id) {
        return id >>> 22;
    }

    public String randomId(int size) {
        Random random = new Random();
        char[] cs = new char[size];
        for (int i = 0; i < cs.length; ++i) {
            cs[i] = digits[random.nextInt(digits.length)];
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        //System.out.println(new IdGenerator().randomId(12));
        IdGenerator idGenerator = new IdGenerator();
        List<JedisPool> jedisPools = Arrays.asList(new JedisPool("127.0.0.1", 6379));
        idGenerator.setJedisPools(jedisPools);
        long going = idGenerator.generatIdByIncr("going");
        System.out.println(going);

    }
}
