package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankResponseBaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @类名称 CyberBankRedemptionSubApplyOutDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 14:48
 * @版本 1.00
 */
@ApiModel(value = "提交赎货申请（供应链）返回参数")
@Getter
@Setter
@ToString
public class CyberBankRedemptionSubApplyOutDto extends CyBankResponseBaseDto {

    @ApiModelProperty(value = "成功标识")
    @JsonProperty("DADA_ID")
    private String dataId;


}
