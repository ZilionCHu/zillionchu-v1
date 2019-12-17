package com.github.zillionchu.zillionchucompanybiz.thirdparty.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @类名称 CyberBankBusinessPlanFeign
 * @类描述 业务方案申请
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/2 20:01
 * @版本 1.00
 */

//@FeignClient(value = "carfinance-provider", url = "http://20.5.160.207:8830")
@FeignClient("carfinance-provider")
public interface CommonSeqNoFeign {

    @RequestMapping(value = "/carfinance/common/buildSerialNum", method = RequestMethod.POST)
    String buildSerialNum(@RequestParam("encodeTypeCode") String encodeTypeCode,
                          @RequestParam("operator") String operator);
}
