package com.github.zillionchu.zillionchucompanybiz.thirdparty.feign;

import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @类名称 CyberBankQueryCarInfoFeign
 * @类描述 车辆
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/2 20:06
 * @版本 1.00
 */
//@FeignClient(value = "tb-cmdty-api-server", url = "http://20.5.160.212:9082")
@FeignClient("carfinance-provider")
public interface CyberBankQueryCarInfoFeign {

    @RequestMapping(value = "/ICmdtyIvntInfApi/findCarIvntInfPageInfo", method = RequestMethod.POST)
    PageInfo<Map<String, Object>> findCarIvntInfPageInfo(@RequestBody Map<String, Object> params);
}
