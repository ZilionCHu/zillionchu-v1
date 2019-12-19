package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.impl;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.feign.DemoFeign;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.netflix.hystrix.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/19 14:55
 * @Description:
 */
public class DemoPostHystrixCommand extends HystrixCommand<Map> implements LoggerBase {

    //@LoadBalanced
   // private RestTemplate restTemplate;

    private DemoFeign demoFeign;

    protected DemoPostHystrixCommand(DemoFeign demoFeign) {
        super(setter());
       // this.restTemplate = restTemplate;
        this.demoFeign=demoFeign;
    }

    @Override
    protected Map run() throws Exception {
        Map forObject = null;
        try {
//            String url = "http://zilionchu-server-http02/";
//          //  String url = "http://172.20.10.8:8502/";
//            forObject = restTemplate.postForObject(url + "indexPost",
//                    Maps.asMap(Sets.newHashSet("1", "2"), s -> s + "v"),
//                    Map.class);

            forObject= (Map)demoFeign.indexPost(Maps.asMap(Sets.newHashSet("1", "2"), s -> s + "v"));
            info("################################ DemoHttpPost  :" + forObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return forObject;
    }

    /**
     *
     */
    public static Setter setter() {

        // 服务分组
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("DdemoBiz");
        // 服务标识
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("DdemoBiz");
        // 线程池名称
        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("DdemoBiz-pool");
        // #####################################################
        // 线程池配置 线程池大小为10,线程存活时间15秒 队列等待的阈值为100,超过100执行拒绝策略
        HystrixThreadPoolProperties.Setter threadPoolProperties =
                HystrixThreadPoolProperties.Setter().withCoreSize(10)
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
    protected Map getFallback() {
        // throw new ThirdPartyException("请稍后再试");
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("code", "888888");
        map.put("msg", "请稍后再试呀");

        info("熔断开始了呀！！！！！！！！！！！！！ ###########################");
        return map;
    }

}



