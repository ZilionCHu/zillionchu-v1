package com.github.zillionchu.zillionchucompanybiz.thirdparty.cyberbank;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank.CyberBankRedemptionAwaitListsApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankRedemptionAwaitListsInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionAwaitListsOutDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionAwaitListsOutListDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.AbstractFeign;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @类名称 CyberBankRedemptionAwaitListsBiz
 * @类描述 待提货融资列表查询业务逻辑
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 15:31
 * @版本 1.00
 */
@RestController
public class CyberBankRedemptionAwaitListsBiz extends AbstractFeign implements CyberBankRedemptionAwaitListsApi {

    /**
     * @param cyberBankRedemptionAwaitListsInpDto
     * @return
     */
    @Override
    public CyberBankRedemptionAwaitListsOutListDto queryCyberBankRedemptionAwaitLists
    (@RequestBody CyberBankRedemptionAwaitListsInpDto cyberBankRedemptionAwaitListsInpDto) throws Exception {

        PageInfo<Map<String, Object>> resp = (PageInfo<Map<String, Object>>) this.redemptionPosts(CyberBankEnum
                        .REDEMPTION_AWAITLISTS,
                cyberBankRedemptionAwaitListsInpDto);

        String respJsonString = JSONObject.toJSONString(resp);
        List<CyberBankRedemptionAwaitListsOutDto> reptFncList = listsConvertToBean(respJsonString,
                CyberBankRedemptionAwaitListsOutDto
                        .class, "list");

        //############################################
//        reptFncList.forEach(c -> {
//            c.setDsbrDt("20191107");
//            c.setLoanExDy("20191107");
//        });
        //############################################
        CyberBankRedemptionAwaitListsOutListDto cyberBankRedemptionAwaitListsOutListDto = new
                CyberBankRedemptionAwaitListsOutListDto();
        //cyberBankRedemptionAwaitListsOutListDto.setData(reptFncList);
        this.convertBaseDto(cyberBankRedemptionAwaitListsInpDto, cyberBankRedemptionAwaitListsOutListDto);
        cyberBankRedemptionAwaitListsOutListDto.setTotal(String.valueOf(resp.getTotal()));
        Long rowSize = 0L;
        if (!CollectionUtils.isEmpty(reptFncList)) {
            rowSize = reptFncList.stream().collect(Collectors.counting());
        } else {
            reptFncList = Collections.emptyList();
        }
        cyberBankRedemptionAwaitListsOutListDto.setRowSize(String.valueOf(rowSize));
        cyberBankRedemptionAwaitListsOutListDto.setData(reptFncList);
        info("redemptionPosts resp is : {}", JSON.toJSONString(cyberBankRedemptionAwaitListsOutListDto));
        return cyberBankRedemptionAwaitListsOutListDto;
    }
}
