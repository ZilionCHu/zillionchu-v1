package com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank;


import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankCarInfoInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankCarInfoListsOutDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @类名称 CyberBankQueryCarInfoApi
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 20:28
 * @版本 1.00
 */

@Api(tags = "网银查看车辆列表")
public interface CyberBankQueryCarInfoApi {


    @PostMapping("queryCyberBankQueryCarInfos")
    @ApiOperation(value = "车辆列表接口")
    CyberBankCarInfoListsOutDto queryCyberBankQueryCarInfos(@RequestBody CyberBankCarInfoInpDto
                                                                    cyberBankCarInfoInpDt) throws Exception;


}
