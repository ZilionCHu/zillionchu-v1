package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @类名称 CreditIousInfoInpDto
 * @类描述
 * @作者 tykj@tansun.cn
 * @创建时间 2019/9/11 17:06
 * @版本 1.00
 */
@ApiModel(value = "保证金信息接入参数")
@Getter
@Setter
@ToString
public class CreditMarginOutInfoDto {

    @ApiModelProperty(value = "保证金账户名")
    @NotNull(message = "保证金账户名不能为空！")
    private String MrgnAccNm;

    @ApiModelProperty(value = "保证金账号")
    @NotNull(message = "保证金账号不能为空！")
    private String MrgnAccNo;

    @ApiModelProperty(value = "保证金账户状态")
    @NotNull(message = "保证金账户状态不能为空！")
    private String MrgnAccSt;

    @ApiModelProperty(value = "保证金账户可用余额")
    @NotNull(message = "保证金账户可用余额不能为空！")
    private BigDecimal MrgnAccAvlBal;

}
