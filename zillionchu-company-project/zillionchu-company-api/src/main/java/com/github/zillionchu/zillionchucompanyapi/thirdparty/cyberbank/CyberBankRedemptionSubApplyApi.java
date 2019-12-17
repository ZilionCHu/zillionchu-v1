package com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank;

import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankRedemptionSubApplyInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionSubApplyOutDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @类名称 CyberBankRedemptionSubApplyApi
 * @类描述 提交赎货申请接口
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 14:31
 * @版本 1.00
 */
@Api(tags = "提交赎货申请")
public interface CyberBankRedemptionSubApplyApi {

    /**
     * 提交赎货申请
     *
     * @param cyberBankRedemptionSubApplyInpDto
     * @return
     */
    @PostMapping("subRedemptionApply")
    CyberBankRedemptionSubApplyOutDto cyberBankRedemptionSubApply(@RequestBody CyberBankRedemptionSubApplyInpDto
                                                                          cyberBankRedemptionSubApplyInpDto) throws
            Exception;
}
