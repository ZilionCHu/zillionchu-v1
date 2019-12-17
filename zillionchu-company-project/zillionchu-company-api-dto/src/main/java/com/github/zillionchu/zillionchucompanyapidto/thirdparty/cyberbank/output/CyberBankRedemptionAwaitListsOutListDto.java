package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankResponseBaseDto;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @类名称 CyberBankRedemptionAwaitListsOutDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 14:50
 * @版本 1.00
 */
@ApiModel(value = "待提货融资列表查询（供应链）返回参数")
@Getter
@Setter
@ToString
public class CyberBankRedemptionAwaitListsOutListDto extends CyBankResponseBaseDto {


    @JsonProperty("DATA")
    private List<CyberBankRedemptionAwaitListsOutDto> data;
}
