package com.zillionchu.server.zillionchuserverhttp03.service;

import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/13 15:16
 * @Description:
 */

public interface TestFeign {

    @PostMapping("feign")
    String testFegin();
}
