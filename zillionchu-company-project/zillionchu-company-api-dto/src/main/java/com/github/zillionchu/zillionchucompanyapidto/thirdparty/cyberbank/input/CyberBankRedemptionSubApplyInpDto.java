package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input;

/**
 * @类名称 CyberBankRedemptionSubApplyInpDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 14:48
 * @版本 1.00
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankRequestBaseDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankCarInfoOutDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(value = "提交赎货申请（网银）传入参数")
@Getter
@Setter
@ToString
public class CyberBankRedemptionSubApplyInpDto extends CyBankRequestBaseDto {


    @ApiModelProperty(value = "业务方案编号")
    @JsonProperty("BSN_SCM_ID")
    @Max(value = 32, message = "业务方案编号超长")
    @NotNull(message = "业务方案编号不能为空！")
    private String bsnScmId;

    @ApiModelProperty(value = "业务协议编号")
    @JsonProperty("BSN_AGRM_ID")
    private String bsnAgrmID;

    @ApiModelProperty(value = "赎货申请单号")
    @JsonProperty("REDPAPLYID")
    @Max(value = 32, message = "赎货申请单号超长")
    @NotNull(message = "赎货申请单号不能为空！")
    private String redpAplyId;

    @ApiModelProperty(value = "融资申请编号")
    @JsonProperty("FNCAPLYID")
    @Max(value = 32, message = "融资申请编号超长")
    @NotNull(message = "融资申请编号不能为空！")
    private String fncAplyId;

    @ApiModelProperty(value = "核心企业名称")
    @JsonProperty("COREENTNM")
    private String coreEntNm;

    @ApiModelProperty(value = "核心企业编号")
    @JsonProperty("COREENTID")
    private String coreEntId;

    @ApiModelProperty(value = "监管企业编号")
    @JsonProperty("REGENTID")
    @Max(value = 32, message = "监管企业编号超长")
   // @NotNull(message = "监管企业编号不能为空！")
    private String regEntId;

    @ApiModelProperty(value = "监管企业名称")
    @JsonProperty("REGENTNM")
    private String regEntNm;

    @ApiModelProperty(value = "放款日期")
    @JsonProperty("DSBRDT")
    private Date dsbrDt;

    @ApiModelProperty(value = "贷款期限")
    @JsonProperty("LOANTRM")
    private BigDecimal loanTrm;

    @ApiModelProperty(value = "融资金额")
    @JsonProperty("FNCAMT")
    private BigDecimal fncAmt;

    @ApiModelProperty(value = "融资余额")
    @JsonProperty("FNCBAL")
    @NotNull(message = "融资余额不能为空！")
    private BigDecimal fncBal;

    @ApiModelProperty(value = "保证金账号")
    @JsonProperty("MRGNACCNO")
    @Max(value = 32, message = "保证金账号超长")
    //  @NotNull(message = "保证金账号不能为空！")
    private String mrgnAccNo;

    @ApiModelProperty(value = "保证金还款模式")
    @JsonProperty("MRGNREPYMODE")
    @Max(value = 32, message = "保证金还款模式超长")
    // @NotNull(message = "保证金还款模式不能为空！")
    private String mrgnRepyMode;

    @ApiModelProperty(value = "首笔保证金金额")
    @JsonProperty("FIRMRGNAMT")
    // @NotNull(message = "首笔保证金金额不能为空！")
    private BigDecimal firMrgnAmt;

    @ApiModelProperty(value = "回款保证金金额")
    @JsonProperty("RFNDMRGNAMT")
    // @NotNull(message = "回款保证金金额不能为空！")
    private BigDecimal rfndMrgnAmt;

    @ApiModelProperty(value = "在库车辆金额")
    @JsonProperty("EXSTVHCLAMT")
    private BigDecimal exstVhclAmt;

    @ApiModelProperty(value = "可赎货金额")
    @JsonProperty("CANRDPAMT")
    private BigDecimal canRdpAmt;

    @ApiModelProperty(value = "本次赎货金额")
    @JsonProperty("THSREDPAMT")
    @NotNull(message = "本次赎货金额不能为空！")
    private BigDecimal thsRedpAmt;

    @ApiModelProperty(value = "提货人名称")
    @JsonProperty("PCKUPGDSPSN")
    @Max(value = 32, message = "提货人名称超长")
    @NotNull(message = "提货人名称不能为空！")
    private String pckUpGdsPsn;

    @ApiModelProperty(value = "提货人身份证")
    @JsonProperty("PCKUPGDSPSNIDCARD")
    @NotNull(message = "提货人身份证不能为空！")
    private String pckUpGdsPsnIdCard;

    @ApiModelProperty(value = "赎货申请人")
    @JsonProperty("REDPAPLYPSN")
    @Max(value = 32, message = "赎货申请人超长")
    @NotNull(message = "赎货申请人不能为空！")
    private String redpAplyPsn;

    @ApiModelProperty(value = "车辆列表")
    @JsonProperty("DATA")
    private List<CyberBankCarInfoOutDto> DATA;


    @ApiModelProperty(value = "车辆字符串集合")
    @JsonProperty("CARSINFO")
    private String carsInfo;


}
