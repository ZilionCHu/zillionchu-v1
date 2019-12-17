package com.github.zillionchu.zillionchucompanybiz.thirdparty.cyberbank;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank.CyberBankBusinessPlanApplyApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankBusinessPlanInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankBusinessPlanInfoOutDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankBusinessPlanOutDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.AbstractFeign;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @类名称 CyberBankBusinessPlanApplyBiz
 * @类描述 业务方案申请业务类
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 20:38
 * @版本 1.00
 */
@RestController
public class CyberBankBusinessPlanApplyBiz extends AbstractFeign implements CyberBankBusinessPlanApplyApi {
    @Override
    public CyberBankBusinessPlanOutDto bankBusinessPlanApply(@RequestBody CyberBankBusinessPlanInpDto
                                                                     cyberBankBusinessPlanInpDto) throws Exception {

        PageInfo<Map<String, Object>> resp = (PageInfo<Map<String, Object>>) this.redemptionPosts(CyberBankEnum
                        .BUSINESSPLAN,
                cyberBankBusinessPlanInpDto);

        String respJsonString = JSONObject.toJSONString(resp);
        List<CyberBankBusinessPlanInfoOutDto> reptBankList = listsConvertToBean(respJsonString,
                CyberBankBusinessPlanInfoOutDto
                        .class, "list");
        CyberBankBusinessPlanOutDto cyberBankBusinessPlanOutDto = new
                CyberBankBusinessPlanOutDto();

        this.convertBaseDto(cyberBankBusinessPlanInpDto, cyberBankBusinessPlanOutDto);
        cyberBankBusinessPlanOutDto.setTotal(String.valueOf(resp.getTotal()));
        Long rowSize = 0L;
        if (!CollectionUtils.isEmpty(reptBankList)) {
            rowSize = reptBankList.stream().collect(Collectors.counting());
        } else {
            reptBankList = Collections.emptyList();
        }
        cyberBankBusinessPlanOutDto.setRowSize(String.valueOf(rowSize));
        cyberBankBusinessPlanOutDto.setData(reptBankList);

        info("redemptionPosts resp is : {}", JSON.toJSONString(cyberBankBusinessPlanOutDto));
        return cyberBankBusinessPlanOutDto;
    }

}
