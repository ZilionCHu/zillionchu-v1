package com.zillionchu.server.zillionchuserverhttp03.service.impl;

import com.zillionchu.server.zillionchuserverhttp03.service.TestFeign;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/13 15:22
 * @Description:
 */

@RestController
public class TestFeignImpl implements TestFeign {
    @Override
    public String testFegin() {

       // Integer.parseInt("aaa");
//        try {
//            Thread.sleep(60000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("http02  fegin  return  ffffffqqqqqqqqqqqqqqqqq");
        return "http02  fegin  return ";
    }
}
