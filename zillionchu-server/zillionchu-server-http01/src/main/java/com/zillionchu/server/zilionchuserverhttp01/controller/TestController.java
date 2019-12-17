package com.zillionchu.server.zilionchuserverhttp01.controller;

import com.alibaba.fastjson.JSONObject;
import com.zillionchu.server.zilionchuserverhttp01.feign.Http02Service;
import com.zillionchu.server.zilionchuserverhttp01.feign.Http02ServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/4 17:02
 * @Description:
 */
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private Http02Service http02Service;

    @Autowired
    private Http02ServiceFeign http02ServiceFeign;

    @RequestMapping("index")
    public Object testIndex() {
        // return http02Service.getHttp02Service("11");
        return new OrderHystrixCommand(http02Service).execute();
    }

    @RequestMapping("getIndex")
    public String getIndex() {
        JSONObject http02Service = this.http02Service.getHttp02Service("11");
        System.out.println("当前线程名称:" + Thread.currentThread().getName() + "调用https:" + http02Service);
        return "getIndex success";
    }

    @RequestMapping("getFeign")
    public String getFeign() {
        String resp = http02ServiceFeign.testFegin();
        return "getFeign " + resp;
    }
}

