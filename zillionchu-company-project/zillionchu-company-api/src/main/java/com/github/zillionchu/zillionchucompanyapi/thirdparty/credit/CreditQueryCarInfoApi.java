package com.github.zillionchu.zillionchucompanyapi.thirdparty.credit;


import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.input.dto.CreditCarInfoInpDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @类名称 CreditQueryCarInfoApi
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/12 20:06
 * @版本 1.00
 */

@Api(tags = "融资车辆查询服务接口")
public interface CreditQueryCarInfoApi {

    /**
     * 根据融资申请编号获取车辆信息
     *
     * @param creditCarInfoInpDto
     * @return
     */
    @PostMapping("getCreditCustomerCarInfo")
    @ApiOperation(value = "融资车辆信息接口")
    BaseResponse<Map<String, Object>> getCreditCarInfo(@RequestBody CreditCarInfoInpDto
                                                               creditCarInfoInpDto);


}
