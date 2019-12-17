package com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank;


import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankTakeGoodsInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankTakeGoodsOutLists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @类名称 CyberBankQueryCarInfoApi
 * @类描述 提货人列表查询
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 20:28
 * @版本 1.00
 */

@Api(tags = "提货人列表查询")
public interface CyberBankQueryTakeGoodsApi {


    @PostMapping("queryBankQueryTakeGoods")
    @ApiOperation(value = "提货人列表查询")
    CyberBankTakeGoodsOutLists queryBankQueryTakeGoods(@RequestBody CyberBankTakeGoodsInpDto
                                                               cyberBankTakeGoodsInpDto) throws Exception;


}
