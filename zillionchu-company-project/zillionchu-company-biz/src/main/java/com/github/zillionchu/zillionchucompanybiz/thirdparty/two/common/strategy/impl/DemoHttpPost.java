package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.impl;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.HttpStrategy;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.DemoEntity;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.feign.DemoFeign;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/16 16:49
 * @Description:
 */
@Component
public class DemoHttpPost implements HttpStrategy<DemoEntity, Map>, LoggerBase {


//    @Autowired
//    @LoadBalanced
//    protected RestTemplate restTemplate;

    @Autowired
    DemoFeign demoFeign;


    @Override
    public Map httpRequest(DemoEntity demoEntity) {
        return new DemoPostHystrixCommand(demoFeign).execute();
    }

}
