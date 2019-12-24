package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.impl;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.HttpStrategy;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.DemoEntity;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.feign.DemoFeign;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.netflix.hystrix.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/16 16:49
 * @Description:
 */
@Component
public class DemoHttpPost extends AbstractOpenApiService implements HttpStrategy<DemoEntity, Map>, LoggerBase {

    @Autowired
    DemoFeign demoFeign;


    private static final String H_HYSTRIXCOMMAND_GROUPKEY = "DdemoBiz";


    static RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000)
            .setSocketTimeout(3000).build();

    static CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(requestConfig)
            .setDefaultHeaders(Lists.newArrayList(new BasicHeader("Authorization", "1a2b3c5d"))).build();
    static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();


    DemoHttpPost() {
        super(client, "", gson);
    }


    @Override
    public Map httpRequest(DemoEntity demoEntity) {

        return new DemoHttpPost.DemoPostHystrixCommand(demoFeign).execute();
    }


    static class DemoPostHystrixCommand extends HystrixCommand<Map> implements LoggerBase {

        private DemoFeign demoFeign;

        protected DemoPostHystrixCommand(DemoFeign demoFeign) {
            super(setter());
            this.demoFeign = demoFeign;
        }

        @Override
        protected Map run() throws Exception {
            Map forObject = null;
            try {
                forObject = (Map) demoFeign.indexPost(Maps.asMap(Sets.newHashSet("1", "2"), s -> s + "v"));
                info("################################ DemoHttpPost  :" + forObject);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return forObject;
        }

        /**
         *
         */
        public static HystrixCommand.Setter setter() {

            // 服务分组
            HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey(H_HYSTRIXCOMMAND_GROUPKEY);
            // 服务标识
            HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("DdemoBiz");
            // 线程池名称
            HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("DdemoBiz-pool");
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

}
