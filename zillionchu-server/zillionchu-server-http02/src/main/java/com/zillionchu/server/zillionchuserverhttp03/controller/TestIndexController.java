package com.zillionchu.server.zillionchuserverhttp03.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

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
        hashMap.put("msg", "Http02  Index");
       // Thread.sleep(150000);
        return hashMap;
       // return String.format("http02%s", param);
    }

    @PostMapping("indexPost")
    public Object indexPost(@RequestBody Map param) throws InterruptedException {
        System.out.println("into ....................");
        System.out.println("into  param   is   :"+JSON.toJSON(param));
       // Map<String, Object> hashMap = new HashMap<String, Object>();
        param.put("code", 200);
        param.put("msg", "Http02  Index");
        // Thread.sleep(150000);
        return param;
        // return String.format("http02%s", param);
    }







//    @GetMapping("index")
//    public String index(@RequestParam("param") String param) throws InterruptedException {
//
//        return String.format("http02 %s",param);
//        // return String.format("http02%s", param);
//    }
}
