package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankResponseBaseDto;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @类名称 CyberBankRedemptionApplyListsOutDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/17 17:34
 * @版本 1.00
 */

@ApiModel(value = "赎货申请列表查询（供应链）返回参数")
@Getter
@Setter
@ToString
public class CyberBankRedemptionApplyListsOutDto extends CyBankResponseBaseDto {


    @JsonProperty("DATA")
    private List<CBRedemptionApplyListInfoOutDto> data;

}
