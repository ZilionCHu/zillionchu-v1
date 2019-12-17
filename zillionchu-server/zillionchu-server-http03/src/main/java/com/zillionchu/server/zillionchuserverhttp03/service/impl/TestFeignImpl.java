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

     //   Integer.parseInt("aaa");
        System.out.println("http03  fegin  return ");
        return "http03  fegin  return ";
    }
}
