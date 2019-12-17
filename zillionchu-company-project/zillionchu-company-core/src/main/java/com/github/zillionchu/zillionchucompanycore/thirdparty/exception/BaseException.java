package com.github.zillionchu.zillionchucompanycore.thirdparty.exception;

/**
 * @类名称 BaseException
 * @类描述 接口异常基础类
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 15:05
 * @版本 1.00
 */
public class BaseException extends RuntimeException {

    private Integer status = 000000;    // 000000代表成功标识

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BaseException() {
    }

    public BaseException(String message, Integer status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
