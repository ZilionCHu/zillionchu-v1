package com.github.zillionchu.zillionchucompanybiz.thirdparty.cyberbank;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank.CyberBankQueryTakeGoodsApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankTakeGoodsInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankTakeGoodsOutDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankTakeGoodsOutLists;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.AbstractFeign;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @类名称 CyberBankQueryTakeGoodsBiz
 * @类描述 提货人列表查询
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 20:40
 * @版本 1.00
 */
@RestController
public class CyberBankQueryTakeGoodsBiz extends AbstractFeign implements CyberBankQueryTakeGoodsApi {

    @Override
    public CyberBankTakeGoodsOutLists queryBankQueryTakeGoods(@RequestBody CyberBankTakeGoodsInpDto
                                                                      cyberBankTakeGoodsInpDto) throws Exception {

        PageInfo<Map<String, Object>> resp = (PageInfo<Map<String, Object>>) this.redemptionPosts(CyberBankEnum
                        .REDEMPTION_TAKEGOODS,
                cyberBankTakeGoodsInpDto);
        String respJsonString = JSONObject.toJSONString(resp);
        List<CyberBankTakeGoodsOutDto> reptCstList = listsConvertToBean(respJsonString, CyberBankTakeGoodsOutDto
                .class, "list");
        CyberBankTakeGoodsOutLists cyberBankTakeGoodsOutLists = new CyberBankTakeGoodsOutLists();


        this.convertBaseDto(cyberBankTakeGoodsInpDto, cyberBankTakeGoodsOutLists);
        cyberBankTakeGoodsOutLists.setTotal(String.valueOf(resp.getTotal()));
        Long rowSize = 0L;
        if (!CollectionUtils.isEmpty(reptCstList)) {
            rowSize = reptCstList.stream().collect(Collectors.counting());
        } else {
            reptCstList = Collections.emptyList();
        }
        cyberBankTakeGoodsOutLists.setRowSize(String.valueOf(rowSize));
        cyberBankTakeGoodsOutLists.setReptCstLis(reptCstList);

        info("redemptionPosts resp is : {}", JSON.toJSONString(cyberBankTakeGoodsOutLists));
        return cyberBankTakeGoodsOutLists;

    }
}
