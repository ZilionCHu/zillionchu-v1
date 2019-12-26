package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.impl;

import com.netflix.hystrix.*;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/25 18:11
 * @Description:
 */
public class AbstractHttpPost {

    public static HystrixCommand.Setter setter(String key, String commKey, String thredPoolKey) {

        // 服务分组
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey(key);
        // 服务标识
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey(commKey);
        // 线程池名称
        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey(thredPoolKey);
        // 线程池配置 线程池大小为10,线程存活时间15秒 队列等待的阈值为100,超过100执行拒绝策略
        HystrixThreadPoolProperties.Setter threadPoolProperties =
                HystrixThreadPoolProperties.Setter().withCoreSize(10)
                        .withKeepAliveTimeMinutes(15).withQueueSizeRejectionThreshold(100);
        // 命令属性配置Hystrix 开启超时
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter()
                // 采用线程池方式实现服务隔离
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                // 禁止
                .withExecutionTimeoutEnabled(false);
        return HystrixCommand.Setter.withGroupKey(groupKey).andCommandKey(commandKey).andThreadPoolKey(threadPoolKey)
                .andThreadPoolPropertiesDefaults(threadPoolProperties).andCommandPropertiesDefaults(commandProperties);

    }
}
