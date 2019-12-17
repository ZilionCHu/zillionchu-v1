package com.zillionchu.server.zillionchuserverhttp03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/5 11:36
 * @Description:
 */
@RestController
@RequestMapping
public class TestIndexController {

    @GetMapping("index")
    public Object index(@RequestParam("param") String param) throws InterruptedException {
        System.out.println("into ....................");
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", 200);
        hashMap.put("msg", "Http03  Index");
        //Thread.sleep(150000);
        return hashMap;
       // return String.format("http02%s", param);
    }

//    @GetMapping("index")
//    public String index(@RequestParam("param") String param) throws InterruptedException {
//
//        return String.format("http02 %s",param);
//        // return String.format("http02%s", param);
//    }
}
