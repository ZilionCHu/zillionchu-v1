package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/19 15:47
 * @Description:
 */
@FeignClient("zilionchu-server-http02")
public interface FinancinginfodtoFeign {

    @PostMapping("indexPost")
    public Object indexPost(@RequestBody Map param);

}