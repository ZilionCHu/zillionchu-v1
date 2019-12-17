package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @类名称 CreditFinancApplyOutInfoDto
 * @类描述
 * @作者 tykj@tansun.cn
 * @创建时间 2019/9/12 15:21
 * @版本 1.00
 */
@ApiModel(value = "融资申请信息接入参数")
@Getter
@Setter
@ToString
public class CreditFinancApplyOutInfoDto {

    @ApiModelProperty(value = "融资申请号")
    @NotNull(message = "融资申请号不能为空！")
    private String FncAplyNo;

    @ApiModelProperty(value = "借据编号")
    @NotNull(message = "借据编号不能为空！")
    private String BillID;

    @ApiModelProperty(value = "融资放款日期")
    @NotNull(message = "融资放款日期不能为空！")
    private Date FncDsbrDt;

    @ApiModelProperty(value = "融资金额")
    @NotNull(message = "融资金额不能为空！")
    private BigDecimal FncAmt;

    @ApiModelProperty(value = "出账方式")
    @NotNull(message = "出账方式不能为空！")
    private String BillMod;

    @ApiModelProperty(value = "保证金账户")
    @NotNull(message = "保证金账户不能为空！")
    private String MrgnAcc;


    @ApiModelProperty(value = "监管企业")
    @NotNull(message = "监管企业不能为空！")
    private String RegEntp;


    @ApiModelProperty(value = "借据余额/票据余额")
    @NotNull(message = "借据余额/票据余额不能为空！")
    private BigDecimal BillBal;


    @ApiModelProperty(value = "融资到期日期")
    @NotNull(message = "融资到期日期不能为空！")
    private Date FncExDat;

}
