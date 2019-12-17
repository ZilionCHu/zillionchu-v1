package com.zillionchu.common.utils.redis;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019-06-04 16:43
 * @Description:
 */
public class SerializerException extends RuntimeException {

    public SerializerException() {
    }

    public SerializerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SerializerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializerException(String message) {
        super(message);
    }

    public SerializerException(Throwable cause) {
        super(cause);
    }
}
