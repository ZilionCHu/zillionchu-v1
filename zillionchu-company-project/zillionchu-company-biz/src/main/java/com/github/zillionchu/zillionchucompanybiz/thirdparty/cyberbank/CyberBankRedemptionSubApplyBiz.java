package com.github.zillionchu.zillionchucompanybiz.thirdparty.cyberbank;

import com.alibaba.fastjson.JSON;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank.CyberBankRedemptionSubApplyApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankRedemptionSubApplyInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionSubApplyOutDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.AbstractFeign;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @类名称 CyberBankRedemptionSubApplyBiz
 * @类描述 提交赎货申请业务逻辑
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 15:33
 * @版本 1.00
 */
@RestController
public class CyberBankRedemptionSubApplyBiz extends AbstractFeign implements CyberBankRedemptionSubApplyApi {

    /**
     * @param cyberBankRedemptionSubApplyInpDto
     * @return
     */
    @Override
    public CyberBankRedemptionSubApplyOutDto cyberBankRedemptionSubApply
    (@RequestBody CyberBankRedemptionSubApplyInpDto cyberBankRedemptionSubApplyInpDto) throws Exception {

        Map<String, Object> resp = (Map<String, Object>) this.redemptionPosts(CyberBankEnum.REDEMPTION_SUBAPPLY,
                cyberBankRedemptionSubApplyInpDto);
//        CyberBankRedemptionSubApplyOutDto cyberBankRedemptionSubApplyOutDto = BeanUtil.mapToBean(resp,
//                CyberBankRedemptionSubApplyOutDto.class, true);
        CyberBankRedemptionSubApplyOutDto cyberBankRedemptionSubApplyOutDto = null;
        this.convertBaseDto(cyberBankRedemptionSubApplyInpDto, cyberBankRedemptionSubApplyOutDto);
        info("redemptionPosts resp is : {}", JSON.toJSONString(cyberBankRedemptionSubApplyOutDto));
        return cyberBankRedemptionSubApplyOutDto;
    }
}