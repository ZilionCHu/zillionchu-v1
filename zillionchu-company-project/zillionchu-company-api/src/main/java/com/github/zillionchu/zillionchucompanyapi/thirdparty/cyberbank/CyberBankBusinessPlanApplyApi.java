package com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank;


import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankBusinessPlanInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankBusinessPlanOutDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @类名称 CyberBankQueryCarInfoApi
 * @类描述 业务方案申请
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 20:28
 * @版本 1.00
 */

@Api(tags = "业务方案申请")
public interface CyberBankBusinessPlanApplyApi {


    @PostMapping("bankBusinessPlanApply")
    @ApiOperation(value = "业务方案申请")
    CyberBankBusinessPlanOutDto bankBusinessPlanApply(@RequestBody CyberBankBusinessPlanInpDto
                                                              cyberBankBusinessPlanInpDto) throws Exception;


}
