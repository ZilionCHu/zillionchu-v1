package com.zillionchu.server.zilionchuserverhttp01.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/5 11:17
 * @Description:
 */
@FeignClient("${url.feign}")
public interface Http02ServiceFeign {

    @PostMapping("feign")
    String testFegin();
}
