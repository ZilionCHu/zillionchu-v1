package com.github.zillionchu.zillionchucompanyapi.thirdparty.credit;


import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.input.dto.CreditMarginInfoInpDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @类名称 CreditMarginInfoApi
 * @类描述
 * @作者 tykj@tansun.cn
 * @创建时间 2019/9/11 19:25
 * @版本 1.00
 */
@Api(tags = "保证金信息服务接口")
public interface CreditMarginInfoApi {

    /**
     * 根据保证金账户名，保证金账号查询保证金信息
     * @param creditMarginInfoInpDto
     */
    @PostMapping("getCreditMarginInfo")
    @ApiOperation(value = "保证金信息接口")
    BaseResponse<Map<String,Object>> getCreditMarginInfo(@RequestBody CreditMarginInfoInpDto creditMarginInfoInpDto);
}

