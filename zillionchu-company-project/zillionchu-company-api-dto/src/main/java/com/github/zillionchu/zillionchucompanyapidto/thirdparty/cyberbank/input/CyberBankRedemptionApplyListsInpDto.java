package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankRequestBaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @类名称 CyberBankRedemptionApplyListsInpDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/17 17:33
 * @版本 1.00
 */

@ApiModel(value = "赎货申请列表查询（网银）传入参数")
@Getter
@Setter
@ToString
public class CyberBankRedemptionApplyListsInpDto extends CyBankRequestBaseDto {


    @ApiModelProperty(value = "页数")
    @JsonProperty("PAGENUM")
    @NotNull(message = "pageNum不能为空！")
    @Max(value = 32, message = "pageNum超长")
    private String pageNum;

    @ApiModelProperty(value = "每页多少条")
    @JsonProperty("PAGESIZE")
    @NotNull(message = "pageSize不能为空！")
    @Max(value = 32, message = "pageSize超长")
    private String pageSize;


    @ApiModelProperty(value = "借款企业编号")
    @NotNull(message = "借款企业编号不能为空！")
    @Max(value = 32, message = "借款企业编号超长")
    @JsonProperty("CSTID")
    private String cstId;

    @ApiModelProperty(value = "赎货申请单号")
    @JsonProperty("REDPAPLYID")
    private String redpAplyId;

    @ApiModelProperty(value = "监管企业编号")
    @JsonProperty("REGENTID")
    private String regEntId;

    @ApiModelProperty(value = "监管企业名称")
    @JsonProperty("REGENTNM")
    private String regEntNm;

    @ApiModelProperty(value = "赎货申请人")
    @JsonProperty("REDPAPLYPSN")
    private String redpAplyPsn;

    @ApiModelProperty(value = "融资申请编号")
    @JsonProperty("FNCAPLYID")
    private String fncAplyId;

    @ApiModelProperty(value = "赎货申请日期从")
    @JsonProperty("REDPAPLYDTFRM")
    private String redpAplyDtFrm;

    @ApiModelProperty(value = "赎货申请日期到")
    @JsonProperty("REDPAPLYDTTO")
    private String redpAplyDtTo;

}
