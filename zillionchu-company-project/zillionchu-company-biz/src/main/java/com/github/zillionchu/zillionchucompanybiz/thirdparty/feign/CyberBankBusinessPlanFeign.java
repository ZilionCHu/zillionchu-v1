package com.github.zillionchu.zillionchucompanybiz.thirdparty.feign;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @类名称 CyberBankBusinessPlanFeign
 * @类描述 业务方案申请
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/2 20:01
 * @版本 1.00
 */

//@FeignClient(value = "carfinance-provider", url = "http://20.5.160.207:8830")
@FeignClient("carfinance-provider")
public interface CyberBankBusinessPlanFeign {

    @ApiOperation(tags = "业务规则组件/合同模块/scf", value = "查询合同基础信息分页列表", notes = "查询合同基础信息分页列表")
    @RequestMapping(method = RequestMethod.POST, value = "/carfinanceOutInt/findBizPreCtrBscInfByParams")
    PageInfo<Map<String, Object>> findBizPreCtrBscInfListByParams(@RequestBody Map<String, Object> params);
}
