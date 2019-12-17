package com.github.zillionchu.zillionchucompanycore.thirdparty.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @类名称 LoggerBase
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 11:59
 * @版本 1.00
 */
public interface LoggerBase {

    /**
     * @return
     */
    default Logger getLogger() {
        return LoggerFactory.getLogger(this.getClass().getName());
    }

    /**
     * info
     *
     * @param msg
     */
    default void info(String msg) {
        Logger logger = this.getLogger();
        if (logger.isInfoEnabled()) {
            logger.info("  >>>>>>>>>>>>>>>>>>>>>   " + msg);
        }
    }

    /**
     * info
     *
     * @param msg
     * @param obj
     */
    default void info(String msg, Object... obj) {
        Logger logger = this.getLogger();
        if (logger.isInfoEnabled()) {
            logger.info("  >>>>>>>>>>>>>>>>>>>>>   " + msg, obj);
        }
    }

    /**
     * error
     *
     * @param msg
     */
    default void error(String msg) {
        Logger logger = this.getLogger();
        if (logger.isErrorEnabled()) {
            logger.error(msg);
        }
    }

    /**
     * error
     *
     * @param msg
     * @param obj
     */
    default void error(String msg, Object... obj) {
        Logger logger = this.getLogger();
        if (logger.isErrorEnabled()) {
            logger.error(msg, obj);
        }
    }


    /**
     * debug
     *
     * @param msg
     */
    default void debug(String msg) {
        Logger logger = this.getLogger();
        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    /**
     * debug
     *
     * @param msg
     * @param obj
     */
    default void debug(String msg, Object... obj) {
        Logger logger = this.getLogger();
        if (logger.isDebugEnabled()) {
            logger.debug(msg, obj);
        }
    }

    /**
     * warn
     *
     * @param msg
     */
    default void warn(String msg) {
        Logger logger = this.getLogger();
        if (logger.isWarnEnabled()) {
            logger.warn(msg);
        }
    }

    /**
     * warn
     *
     * @param msg
     * @param obj
     */
    default void warn(String msg, Object... obj) {
        Logger logger = this.getLogger();
        if (logger.isWarnEnabled()) {
            logger.warn(msg, obj);
        }
    }


}
