package com.github.zillionchu.zillionchucompanyapi.thirdparty.credit;


import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.input.dto.CreditCustomerInfoInpDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @类名称 CreditCustomerInfo
 * @类描述 客户信息接口
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/11 17:22
 * @版本 1.00
 */
@Api(tags = "客户信息服务接口")
public interface CreditCustomerInfoApi {


    /**
     * @param creditCustomerInfoInpDto 根据客户名称、客户编号获取客户信息
     */
    @PostMapping("getCreditCustomerInfo")
    @ApiOperation(value = "客户信息接口")
    BaseResponse<Map<String,Object>> getCreditCustomerInfo(@RequestBody CreditCustomerInfoInpDto
                                                                   creditCustomerInfoInpDto);
}

