package com.github.zillionchu.zillionchucompanybiz.thirdparty.cyberbank;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank.CyberBankRedemptionApplyListsApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankRedemptionApplyListsInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CBRedemptionApplyListInfoOutDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionApplyListsOutDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.AbstractFeign;
import io.swagger.annotations.Api;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @类名称 CyberBankRedemptionApplyListsBiz
 * @类描述 赎货申请列表查询
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/17 18:23
 * @版本 1.00
 */
@Api(tags = "赎货申请列表查询")
@RestController
public class CyberBankRedemptionApplyListsBiz extends AbstractFeign implements CyberBankRedemptionApplyListsApi {


    @Override
    public CyberBankRedemptionApplyListsOutDto queryCybankApplyListsInfo(@RequestBody
                                                                                 CyberBankRedemptionApplyListsInpDto
                                                                                 cyberBankRedemptionApplyListsInpDto)
            throws Exception {

        PageInfo<Map<String, Object>> resp = (PageInfo<Map<String, Object>>) this.redemptionPosts(CyberBankEnum
                        .REDEMPTION_APPLYLISTS,
                cyberBankRedemptionApplyListsInpDto);
        String respJsonString = JSONObject.toJSONString(resp);
        // CyberBankRedemptionApplyInfoOutDto
        CyberBankRedemptionApplyListsOutDto cyberBankRedemptionApplyListsOutDto = new
                CyberBankRedemptionApplyListsOutDto();
        List<CBRedemptionApplyListInfoOutDto> redemptionApplyList = this.listsConvertToBean(respJsonString,
                CBRedemptionApplyListInfoOutDto.class, "list");
        this.convertBaseDto(cyberBankRedemptionApplyListsInpDto, cyberBankRedemptionApplyListsOutDto);
        cyberBankRedemptionApplyListsOutDto.setTotal(String.valueOf(resp.getTotal()));
        Long rowSize = 0L;
        if (!CollectionUtils.isEmpty(redemptionApplyList)) {
            rowSize = redemptionApplyList.stream().collect(Collectors.counting());
        } else {
            redemptionApplyList = Collections.emptyList();
        }
        cyberBankRedemptionApplyListsOutDto.setRowSize(String.valueOf(rowSize));
        cyberBankRedemptionApplyListsOutDto.setData(redemptionApplyList);
        info("redemptionPosts resp is : {}", JSON.toJSONString(cyberBankRedemptionApplyListsOutDto));
        return cyberBankRedemptionApplyListsOutDto;

    }
}
