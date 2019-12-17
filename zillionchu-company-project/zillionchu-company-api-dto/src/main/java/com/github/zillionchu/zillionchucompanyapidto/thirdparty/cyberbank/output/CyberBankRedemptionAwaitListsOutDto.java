package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

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
public class CyberBankRedemptionAwaitListsOutDto {

    @ApiModelProperty(value = "融资申请编号")
    @JsonProperty("FNCAPLYID")
    private String fncAplyId;

    @ApiModelProperty(value = "核心企业名称")
    @JsonProperty("COREENTNM")
    private String coreCstNm;

    @ApiModelProperty(value = "核心企业编号")
    @JsonProperty("COREENTID")
    private String coreCstId;

    @ApiModelProperty(value = "监管企业编号")
    @JsonProperty("REGENTID")
    private String regEntId;

    @ApiModelProperty(value = "监管企业名称")
    @JsonProperty("REGENTNM")
    private String regEntNm;

    @ApiModelProperty(value = "放款日期")
    @JsonProperty("DSBRDT")
    private String dsbrDt;

    @ApiModelProperty(value = "贷款到期日")
    @JsonProperty("LOANEXDY")
    private String loanExDy;

    @ApiModelProperty(value = "融资金额")
    @JsonProperty("FNCAMT")
    private BigDecimal fncAmt;

    @ApiModelProperty(value = "融资余额")
    @JsonProperty("FNCBAL")
    private BigDecimal fncBal;

    @ApiModelProperty(value = "保证金账号")
    @JsonProperty("MRGNACCNO")
    private String mrgnAccNo;

    @ApiModelProperty(value = "赎货策略")
    @JsonProperty("RDPSTRTG")
    private String rdpStrtg;

    @ApiModelProperty(value = "首笔保证金金额")
    @JsonProperty("FIRSTKMRGNAMT")
    private BigDecimal firStkMrgnAmt;

    @ApiModelProperty(value = "回款保证金金额")
    @JsonProperty("RFNDMRGNAMT")
    private BigDecimal rfndMrgnAmt;

    @ApiModelProperty(value = "在库车辆金额")
    @JsonProperty("EXSTDEPOTVHCLAMT")
    private BigDecimal exstDepotVhclAmt;

    @ApiModelProperty(value = "可赎货金额")
    @JsonProperty("CANRDPAMT")
    private BigDecimal canRdpAmt;

    @ApiModelProperty(value = "业务方案编号")
    @JsonProperty("BSNSCMID")
    private String ctrId;

    @ApiModelProperty(value = "借款企业编号")
    @JsonProperty("CSTID")
    private String cstId;

    @ApiModelProperty(value = "借款企业名称")
    @JsonProperty("CSTNM")
    private String cstNm;

}
