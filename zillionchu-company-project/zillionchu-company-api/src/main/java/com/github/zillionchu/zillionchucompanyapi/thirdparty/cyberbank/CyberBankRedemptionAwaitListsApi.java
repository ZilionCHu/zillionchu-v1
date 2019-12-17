package com.github.zillionchu.zillionchucompanyapi.thirdparty.cyberbank;

import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input.CyberBankRedemptionAwaitListsInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionAwaitListsOutListDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @类名称 CyberBankRedemptionAwaitListsApi
 * @类描述 待提货融资
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 14:45
 * @版本 1.00
 */
@Api(tags = "待提货融资列表查询")
public interface CyberBankRedemptionAwaitListsApi {

    /**
     * 待提货融资列表查询
     *
     * @param cyberBankRedemptionAwaitListsInpDto
     * @return
     */
    @PostMapping("queryRedemptionAwaitLists")
    CyberBankRedemptionAwaitListsOutListDto queryCyberBankRedemptionAwaitLists
    (@RequestBody CyberBankRedemptionAwaitListsInpDto cyberBankRedemptionAwaitListsInpDto) throws Exception;
}
