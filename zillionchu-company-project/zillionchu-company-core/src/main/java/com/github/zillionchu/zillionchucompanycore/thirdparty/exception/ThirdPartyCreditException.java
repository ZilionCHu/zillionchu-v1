package com.github.zillionchu.zillionchucompanycore.thirdparty.exception;

/**
 * @类名称 ThirdPartyException
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/17 11:50
 * @版本 1.00
 */
public class ThirdPartyCreditException extends RuntimeException {


    public ThirdPartyCreditException(String message) {
        super(message);
    }

    public ThirdPartyCreditException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThirdPartyCreditException(Throwable cause) {
        super(cause);
    }

    public ThirdPartyCreditException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
