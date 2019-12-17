package com.github.zillionchu.zillionchucompanybiz.thirdparty.test;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/16 15:23
 * @Description:
 */
@RestController
@RequestMapping
public class TestController {

    private static final String APPLICATION_NAME = "zilionchu-server-http02";

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;


    @PostMapping("testGet")
    public Map getString() {
        String name = "testGet";
        Map forObject = restTemplate.getForObject("http://" + APPLICATION_NAME + "/index?param=" + name, Map.class);
        System.out.println("################################:-" + forObject);
        return forObject;
    }


    @PostMapping("testPost")
    public Map getStringPost() {
        Map forObject = restTemplate.postForObject("http://" + APPLICATION_NAME + "/indexPost",
                Maps.asMap(Sets.newHashSet("1", "2"), s -> s + "v"),
                Map.class);
        System.out.println("################################:-" + forObject);
        return forObject;
    }
}
