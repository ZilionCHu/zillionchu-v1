package com.github.zillionchu.zillionchucompanybiz.thirdparty.cyberbank;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank.CyberBankQueryCarInfoApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankCarInfoInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankCarInfoListsOutDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankCarInfoOutDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.AbstractFeign;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

//import com.jeedev.msdp.utlis.internal.exception.UtilException;

/**
 * @类名称 CyberBankQueryCarInfoBiz
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 20:39
 * @版本 1.00
 */
@RestController
public class CyberBankQueryCarInfoBiz extends AbstractFeign implements CyberBankQueryCarInfoApi, LoggerBase {

    private static final FastDateFormat DAY_FORMAT = FastDateFormat.getInstance("yyyyMMdd");
    private static final FastDateFormat TIMESTAMP_FORMAT = FastDateFormat.getInstance("hhmmss");
    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public CyberBankCarInfoListsOutDto queryCyberBankQueryCarInfos(@RequestBody CyberBankCarInfoInpDto
                                                                           cyberBankCarInfoInpDt) throws Exception {
        PageInfo<Map<String, Object>> resp = (PageInfo<Map<String, Object>>) redemptionPosts(CyberBankEnum
                .QUERYCARINFO, cyberBankCarInfoInpDt);
        String respJsonString = JSONObject.toJSONString(resp);
        List<CyberBankCarInfoOutDto> reptCarList = listsConvertToBean(respJsonString, CyberBankCarInfoOutDto
                .class, "list");
        CyberBankCarInfoListsOutDto carInfoListsOutDto = new CyberBankCarInfoListsOutDto();
        this.convertBaseDto(cyberBankCarInfoInpDt, carInfoListsOutDto);
        Long rowSize = 0L;
        if (!CollectionUtils.isEmpty(reptCarList)) {
            rowSize = reptCarList.stream().collect(Collectors.counting());
        } else {
            reptCarList = Collections.emptyList();
        }
        carInfoListsOutDto.setRowSize(String.valueOf(rowSize));
        carInfoListsOutDto.setTotal(String.valueOf(resp.getTotal()));
        carInfoListsOutDto.setData(reptCarList);
        info("redemptionPosts resp is : {}", JSON.toJSONString(carInfoListsOutDto));
        return carInfoListsOutDto;
    }

}
