package com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank;

import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankRedemptionRevokeApplyInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionRevokeApplyOutDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @类名称 CyberBankRedemptionRevokeApplyApi
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 14:29
 * @版本 1.00
 */

@Api(tags = "赎货申请撤销")
public interface CyberBankRedemptionRevokeApplyApi {

    /**
     * 赎货申请撤销
     *
     * @param cyberBankRedemptionRevokeApplyInpDto
     * @return
     */
    @PostMapping("revokeRedemptionRevokeApply")
    CyberBankRedemptionRevokeApplyOutDto revokeCyberBankRedemptionApply
    (@RequestBody CyberBankRedemptionRevokeApplyInpDto cyberBankRedemptionRevokeApplyInpDto) throws Exception;
}
