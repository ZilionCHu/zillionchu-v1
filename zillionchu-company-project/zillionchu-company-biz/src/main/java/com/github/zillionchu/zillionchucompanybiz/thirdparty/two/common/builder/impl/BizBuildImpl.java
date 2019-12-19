package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.builder.impl;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.builder.BaseBuild;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/18 12:01
 * @Description:
 */
@Component
public class BizBuildImpl implements BaseBuild, LoggerBase {

    private RateLimiter rateLimiter = RateLimiter.create(100000);

    /**
     * Limit
     *
     * @return
     */

    @Override
    public Boolean LimitRequest() {
        info("Limit impl");
        boolean tryAcquire = rateLimiter.tryAcquire(0, TimeUnit.SECONDS);
        if (!tryAcquire) {
            return false;
        }
        return true;
    }

    /**
     * Unique
     *
     * @return
     */
    @Override
    public Boolean UniqueRequest() {
        info("Unique impl");
        return true;
    }


}
