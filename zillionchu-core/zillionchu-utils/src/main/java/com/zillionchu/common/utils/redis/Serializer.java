package com.zillionchu.common.utils.redis;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-06-04 16:41
 * @Description:
 */
public abstract interface Serializer {

    public abstract byte[] serialize(Object paramObject);

    public abstract Object deserialize(byte[] paramArrayOfByte);
}
