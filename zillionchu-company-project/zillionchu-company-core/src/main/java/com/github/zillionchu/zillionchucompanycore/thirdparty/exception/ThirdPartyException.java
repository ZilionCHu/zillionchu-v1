package com.github.zillionchu.zillionchucompanycore.thirdparty.exception;

/**
 * @类名称 ThirdPartyException
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/17 11:50
 * @版本 1.00
 */
public class ThirdPartyException extends RuntimeException {


    public ThirdPartyException(String message) {
        super(message);
    }

    public ThirdPartyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThirdPartyException(Throwable cause) {
        super(cause);
    }

    public ThirdPartyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
