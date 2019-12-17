package com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank;

import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankRedemptionApplyListsInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionApplyListsOutDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @类名称 CyberBankRedemptionApplyListsApi
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/17 18:12
 * @版本 1.00
 */


@Api(tags = "赎货申请列表查询")
public interface CyberBankRedemptionApplyListsApi {

    /**
     * 赎货申请列表
     *
     * @param cyberBankRedemptionApplyListsInpDto
     * @return
     */
    @PostMapping("queryRedemptionApplyLists")
    CyberBankRedemptionApplyListsOutDto queryCybankApplyListsInfo
    (@RequestBody CyberBankRedemptionApplyListsInpDto cyberBankRedemptionApplyListsInpDto) throws Exception;


}
