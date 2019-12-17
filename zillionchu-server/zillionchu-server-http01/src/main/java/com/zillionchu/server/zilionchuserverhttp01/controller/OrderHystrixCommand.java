package com.zillionchu.server.zilionchuserverhttp01.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.*;
import com.zillionchu.server.zilionchuserverhttp01.feign.Http02Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/4 20:16
 * @Description:
 */
public class OrderHystrixCommand extends HystrixCommand<JSONObject> {


    @Autowired
    private Http02Service http02Service;

    /**
     * Description: OrderHystrixCommand
     * Version: 1.0
     * Date: 2019/11/5 上午11:21
     * Author: ZiLlioNCHu
     *
     * @param http02Service
     * @return
     */

    public OrderHystrixCommand(Http02Service http02Service) {
        super(setter());
        this.http02Service = http02Service;
    }

    @Override
    protected JSONObject run() {
        try {
            JSONObject resp = http02Service.getHttp02Service("http01");
            System.out.println("当前线程名称:" + Thread.currentThread().getName() + ",调用http02服务resp  :" + resp);
            return resp;

        } catch (Exception e) {
           // e.printStackTrace();
        }

        return null;

    }

    private static Setter setter() {

        // 服务分组
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("members");
        // 服务标识
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("member");
        // 线程池名称
        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("member-pool");
        // #####################################################
        // 线程池配置 线程池大小为10,线程存活时间15秒 队列等待的阈值为100,超过100执行拒绝策略
        HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties.Setter().withCoreSize(10)
                .withKeepAliveTimeMinutes(15).withQueueSizeRejectionThreshold(100);
        // ########################################################
        // 命令属性配置Hystrix 开启超时
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter()
                // 采用线程池方式实现服务隔离
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                // 禁止
                .withExecutionTimeoutEnabled(false);
        return HystrixCommand.Setter.withGroupKey(groupKey).andCommandKey(commandKey).andThreadPoolKey(threadPoolKey)
                .andThreadPoolPropertiesDefaults(threadPoolProperties).andCommandPropertiesDefaults(commandProperties);

    }

    @Override
    protected JSONObject getFallback() {
        // 如果Hystrix发生熔断，当前服务不可用,直接执行Fallback方法
        System.out.println("系统错误！");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 500);
        jsonObject.put("msg", "系统错误！");
        return jsonObject;
    }
}
