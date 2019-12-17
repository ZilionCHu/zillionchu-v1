package com.github.zillionchu.zillionchucompanyapi.thirdparty.credit;


import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.input.dto.CreditIousInfoInpDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @类名称 CreditIousInfoApi
 * @类描述
 * @作者 tykj@tansun.cn
 * @创建时间 2019/9/11 19:25
 * @版本 1.00
 */
@Api(tags = "借据信息服务接口")
public interface CreditIousInfoApi {

    /**
     * 根据融资申请编号查询借据信息
     * @param creditIousInfoInpDto
     */
    @PostMapping("getCreditIousInfo")
    @ApiOperation(value = "借据信息接口")
    BaseResponse<Map<String,Object>> getCreditIousInfo(@RequestBody CreditIousInfoInpDto creditIousInfoInpDto);

}
