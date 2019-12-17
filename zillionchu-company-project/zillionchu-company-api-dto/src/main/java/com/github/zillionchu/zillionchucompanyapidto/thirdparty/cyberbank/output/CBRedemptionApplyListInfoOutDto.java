package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @类名称 CBRedemptionApplyListInfoOutDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/18 11:54
 * @版本 1.00
 */
@Getter
@Setter
@ToString
public class CBRedemptionApplyListInfoOutDto {

    @ApiModelProperty(value = "业务方案编号")
    @JsonProperty("BSN_SCM_ID")
    private String bsnScmID;

    @ApiModelProperty(value = "业务协议编号")
    @JsonProperty("BSN_AGRM_ID")
    private String bsnAgrmID;

    @ApiModelProperty(value = "赎货申请单号")
    @JsonProperty("REDPAPLYID")
    private String redpAplyId;

    @ApiModelProperty(value = "融资申请编号")
    @JsonProperty("FNCAPLYID")
    private String fncAplyId;

    @ApiModelProperty(value = "监管企业编号")
    @JsonProperty("REGENTID")
    private String regEntId;

    @ApiModelProperty(value = "监管企业名称")
    @JsonProperty("REGENTNM")
    private String regEntNm;

    @ApiModelProperty(value = "赎货申请人")
    @JsonProperty("REDPAPLYPSN")
    private String redpAplyPsn;

    @ApiModelProperty(value = "赎货申请日期")
    @JsonProperty("REDPDT")
    private String redpDt;

    @ApiModelProperty(value = "融资金额")
    @JsonProperty("FNCAMT")
    private BigDecimal fncAmt;

    @ApiModelProperty(value = "本次赎货金额")
    @JsonProperty("ThSREDPAMT")
    private BigDecimal thsRedpAmt;

    @ApiModelProperty(value = "本次赎货数量")
    @JsonProperty("THSREDPNUM")
    private BigDecimal thsRedpNum;

    @ApiModelProperty(value = "提货人名称")
    @JsonProperty("PCKUPGDSPSN")
    private String pckUpGdsPsn;

    @ApiModelProperty(value = "提货人身份证")
    @JsonProperty("PCKUPGDSPSNIDCARD")
    private String pckUpGdsPsnIDCard;

    @ApiModelProperty(value = "提货人身份证")
    @JsonProperty("ST")
    private String st;


}