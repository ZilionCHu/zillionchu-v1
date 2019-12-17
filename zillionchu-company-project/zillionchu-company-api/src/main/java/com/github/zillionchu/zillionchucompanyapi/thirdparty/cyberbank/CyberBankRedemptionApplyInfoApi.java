package com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank;


import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankRedemptionApplyInfoInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionApplyInfoOutDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @类名称 CyberBankRedemptionApplyInfoApi
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/17 18:11
 * @版本 1.00
 */

@Api(tags = "赎货申请详情")
public interface CyberBankRedemptionApplyInfoApi {

    /**
     * 根据赎货申请单号查询
     *
     * @param cyberBankRedemptionApplyInfoInpDto
     * @return
     */
    @PostMapping("cyberBankRedemptionApply")
    @ApiOperation(value = "赎货申请详情")
    CyberBankRedemptionApplyInfoOutDto queryCybankApplyInfo(@RequestBody
                                                                    CyberBankRedemptionApplyInfoInpDto
                                                                    cyberBankRedemptionApplyInfoInpDto) throws
            Exception;
}
