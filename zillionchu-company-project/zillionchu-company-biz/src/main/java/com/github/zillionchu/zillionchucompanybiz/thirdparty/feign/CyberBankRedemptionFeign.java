package com.github.zillionchu.zillionchucompanybiz.thirdparty.feign;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @类名称 CyberBankRedemptionFeign
 * @类描述 赎货相关内接口
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/2 19:53
 * @版本 1.00
 */
//@FeignClient(name = "tb-car-api-server", url = "http://20.5.160.214:9088")
@FeignClient("carfinance-provider")
public interface CyberBankRedemptionFeign {

    @ApiOperation(value = "赎货申请列表查询接口", notes = "赎货申请列表查询接口")
    @RequestMapping(value = "/carfinanceOutInt/findReptListIntf", method = RequestMethod.POST)
    PageInfo<Map<String, Object>> findReptListIntf(@RequestBody Map<String, Object> params);

    @ApiOperation(value = "赎货申请提交接口", notes = "赎货申请提交接口")
    @RequestMapping(value = "/carfinanceOutInt/saveReptListIntf", method = RequestMethod.POST)
    Map<String, Object> saveReptListIntf(@RequestBody Map<String, Object> params);

    @ApiOperation(value = "赎货申请详情接口", notes = "赎货申请详情接口")
    @RequestMapping(value = "/carfinanceOutInt/viewReptListIntf", method = RequestMethod.POST)
    Map<String, Object> viewReptListIntf(@RequestBody Map<String, Object> params) ;

    @ApiOperation(value = "撤回赎货申请接口", notes = "撤回赎货申请接口")
    @RequestMapping(value = "/carfinanceOutInt/saveOrUpdateBackBizReptInfoTrans", method = RequestMethod.POST)
    Map<String, Object> saveOrUpdateBackBizReptInfoTrans(@RequestBody Map<String, Object> params);

    @ApiOperation(value = "待赎货融资列表查询接口", notes = "待赎货融资列表查询接口")
    @RequestMapping(value = "/carfinanceOutInt/findReptFncIntf", method = RequestMethod.POST)
    PageInfo<Map<String, Object>> findReptFncIntf(@RequestBody Map<String, Object> params);

    @ApiOperation(value = "提货人列表查询接口", notes = "提货人列表查询接口")
    @RequestMapping(value = "/carfinanceOutInt/findReptCstIntf", method = RequestMethod.POST)
    PageInfo<Map<String, Object>> findReptCstIntf(@RequestBody Map<String, Object> params);

}
