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
 * @类名称 CyberBankRedemptionAwaitListsInpDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 14:49
 * @版本 1.00
 */
@ApiModel(value = "待提货融资列表查询（网银）传入参数")
@Getter
@Setter
@ToString
public class CyberBankRedemptionAwaitListsInpDto extends CyBankRequestBaseDto {


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


    @ApiModelProperty(value = "融资申请编号")
    @JsonProperty("FNCAPLYID")
    private String fncAplyId;

    @ApiModelProperty(value = "核心企业名称")
    @JsonProperty("COREENTNM")
    private String coreEntNm;

    @ApiModelProperty(value = "核心企业编号")
    @JsonProperty("COREENTID")
    private String coreEntId;

    @ApiModelProperty(value = "放款开始日期")
    @JsonProperty("DSBRSTDT")
    private String dsbrStDt;

    @ApiModelProperty(value = "放款结束日期")
    @JsonProperty("DSBREDDT")
    private String dsbrEdDt;

    @ApiModelProperty(value = "借款企业名称")
    @JsonProperty("CSTNM")
    @Max(value = 200, message = "借款企业名称超长")
    @NotNull(message = "借款企业名称不能为空！")
    private String cstNm;

    @ApiModelProperty(value = "借款企业编号")
    @JsonProperty("CSTID")
    @Max(value = 32, message = "借款企业编号超长")
    @NotNull(message = "借款企业编号不能为空！")
    private String cstId;


}
