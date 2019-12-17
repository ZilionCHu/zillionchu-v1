package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankResponseBaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @类名称 CyberBankRedemptionApplyOutInpDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/17 17:35
 * @版本 1.00
 */

@ApiModel(value = "赎货申请详情（供应链）返回参数")
@Getter
@Setter
@ToString
public class CyberBankRedemptionApplyInfoOutDto extends CyBankResponseBaseDto {

   /* @ApiModelProperty(value = "业务方案编号")
    @JsonProperty("BSN_SCM_ID")
    private String bsnScmId;

    @ApiModelProperty(value = "业务协议编号")
    @JsonProperty("BSN_AGRM_ID")
    private String bsnAgrmId;

    @ApiModelProperty(value = "赎货申请单号")
    @JsonProperty("REDPAPLYID")
    private String redpAplyId;

    @ApiModelProperty(value = "融资申请编号")
    @JsonProperty("FNCAPLYID")
    private String fncAplyId;*/

    @ApiModelProperty(value = "核心企业名称")
    @JsonProperty("COREENTNM")
    private String coreEntpNm;

    @ApiModelProperty(value = "核心企业编号")
    @JsonProperty("COREENTID")
    private String coreEntpId;

    /*@ApiModelProperty(value = "监管企业编号")
    @JsonProperty("REGENTID")
    private String regEntId;

    @ApiModelProperty(value = "监管企业名称")
    @JsonProperty("REGENTNM")
    private String regEntNm;*/

    @ApiModelProperty(value = "放款日期")
    @JsonProperty("DSBRDT")
    private String dsbrDt;

    @ApiModelProperty(value = "贷款期限")
    @JsonProperty("LOANTRM")
    private BigDecimal loanTrm;

   /* @ApiModelProperty(value = "融资金额")
    @JsonProperty("FNCAMT")
    private BigDecimal fncAmt;*/

    @ApiModelProperty(value = "融资余额")
    @JsonProperty("FNCBAL")
    private BigDecimal fncBal;

    @ApiModelProperty(value = "保证金账号")
    @JsonProperty("MRGNACCNO")
    private String mrgnAccNo;

    @ApiModelProperty(value = "保证金还款模式")
    @JsonProperty("MRGNREPYMODE")
    private String mrgnRepyMode;

    @ApiModelProperty(value = "首笔保证金金额")
    @JsonProperty("FIRMRGNAMT")
    private BigDecimal firMrgnAmt;

    @ApiModelProperty(value = "回款保证金金额")
    @JsonProperty("RFNDMRGNAMT")
    private BigDecimal rfndMrgnAmt;

    @ApiModelProperty(value = "在库车辆金额")
    @JsonProperty("EXSTVHCLAMT")
    private BigDecimal exstvhclAmt;

    @ApiModelProperty(value = "可赎货金额")
    @JsonProperty("CANRDPAMT")
    private BigDecimal canRdpAmt;

   /* @ApiModelProperty(value = "本次赎货金额")
    @JsonProperty("THSREDPAMT")
    private BigDecimal thsRedpAmt;

    @ApiModelProperty(value = "提货人名称")
    @JsonProperty("PCKUPGDSPSN")
    private String pckUpGdsPsn;

    @ApiModelProperty(value = "提货人身份证")
    @JsonProperty("PCKUPGDSPSNIDCARD")
    private String pckUpGdsPsnIdCard;

    @ApiModelProperty(value = "赎货申请人")
    @JsonProperty("REDPAPLYPSN")
    private String redpAplyPsn;*/

    @ApiModelProperty(value = "车辆集合")
    @JsonProperty("DATA")
    private List<Map<String, Object>> data;

}
