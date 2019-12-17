package com.github.zillionchu.zillionchucompanybiz.thirdparty.cyberbank;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank.CyberBankRedemptionApplyInfoApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankRedemptionApplyInfoInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionApplyInfoOutDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.AbstractFeign;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类名称 CyberBankRedemptionApplyInfoBiz
 * @类描述 赎货申请详情
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/17 18:23
 * @版本 1.00
 */
@RestController
public class CyberBankRedemptionApplyInfoBiz extends AbstractFeign implements CyberBankRedemptionApplyInfoApi,
        LoggerBase {

    /**
     * @param cyberBankRedemptionApplyInfoInpDto
     * @return
     */
    @Override
    public CyberBankRedemptionApplyInfoOutDto queryCybankApplyInfo(@RequestBody
                                                                           CyberBankRedemptionApplyInfoInpDto
                                                                           cyberBankRedemptionApplyInfoInpDto) throws
            Exception {

        Map<String, Object> resp = (Map<String, Object>) this.redemptionPosts(AbstractFeign.CyberBankEnum
                        .REDEMPTION_APPLYINFO,
                cyberBankRedemptionApplyInfoInpDto);
        String respJsonString = JSONObject.toJSONString(resp);
        JSONObject jsonObject = JSON.parseObject(respJsonString);
        JSONObject pageInfoJSONObject = jsonObject.getJSONObject("pageInfo");
        PageInfo repsePageInfo = JSON.toJavaObject(pageInfoJSONObject, PageInfo.class);
//        CyberBankRedemptionApplyInfoOutDto convertResp = BeanUtil.mapToBean(resp,
//                CyberBankRedemptionApplyInfoOutDto.class, true);
        CyberBankRedemptionApplyInfoOutDto convertResp = null;
        List<Map<String, Object>> carsInfo = repsePageInfo.getList();
        info("######################################  carsInfo size {}", carsInfo.size());
        this.convertBaseDto(cyberBankRedemptionApplyInfoInpDto, convertResp);
        ArrayList<Map<String, Object>> var1 = Lists.newArrayList();
        for (Map<String, Object> map : carsInfo) {
            HashMap<String, Object> var2 = Maps.newHashMap();
            map.forEach((s, o) -> {
                var2.put(s.toUpperCase(), o);
            });
            var1.add(var2);
        }
        info("######################################  var1 size {}", var1.size());
        convertResp.setData(var1);
        convertResp.setRowSize(String.valueOf(carsInfo.size()));
        convertResp.setTotal(String.valueOf(repsePageInfo.getTotal()));
        info("redemptionPosts resp is : {}", JSON.toJSONString(convertResp));
        return convertResp;
    }
}
