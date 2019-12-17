package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @类名称 CyberBankRedemptionRevokeApplyInpDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 14:50
 * @版本 1.00
 */
@Getter
@Setter
@ToString
public class ParamsCBRevokeApplyOutDto {

    @ApiModelProperty(value = "成功标识")
    private String dataId;
}
