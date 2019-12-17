package com.github.zillionchu.zillionchucompanybiz.thirdparty.cyberbank;

import com.alibaba.fastjson.JSON;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank.CyberBankRedemptionRevokeApplyApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankRedemptionRevokeApplyInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionRevokeApplyOutDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.AbstractFeign;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @类名称 CyberBankRedemptionRevokeApplyBiz
 * @类描述 赎货申请撤销业务逻辑
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 15:32
 * @版本 1.00
 */
@RestController
public class CyberBankRedemptionRevokeApplyBiz extends AbstractFeign implements CyberBankRedemptionRevokeApplyApi {

    /**
     * @param cyberBankRedemptionRevokeApplyInpDto
     * @return
     */
    @Override
    public CyberBankRedemptionRevokeApplyOutDto revokeCyberBankRedemptionApply
    (@RequestBody CyberBankRedemptionRevokeApplyInpDto cyberBankRedemptionRevokeApplyInpDto) throws Exception {

        Map<String, Object> resp = (Map<String, Object>) this.redemptionPosts(CyberBankEnum.REDEMPTION_REVOKEAPPLY,
                cyberBankRedemptionRevokeApplyInpDto);
        info("redemptionPosts resp is : {}", JSON.toJSONString(resp));
//        CyberBankRedemptionRevokeApplyOutDto cyberBankRedemptionRevokeApplyOutDto = BeanUtil.mapToBean(resp,
//                CyberBankRedemptionRevokeApplyOutDto
//                        .class, true);
        CyberBankRedemptionRevokeApplyOutDto cyberBankRedemptionRevokeApplyOutDto = null;
        info("paramsCBRevokeApplyOutDto is : {}", JSON.toJSONString(cyberBankRedemptionRevokeApplyOutDto));
        this.convertBaseDto(cyberBankRedemptionRevokeApplyInpDto, cyberBankRedemptionRevokeApplyOutDto);
        info("revokeCyberBankRedemptionApply is : {}", JSON.toJSONString(cyberBankRedemptionRevokeApplyOutDto));
        return cyberBankRedemptionRevokeApplyOutDto;
    }
}
