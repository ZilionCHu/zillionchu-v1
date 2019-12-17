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
 * @类名称 CyberBankRedemptionApplyInfoInpDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/17 17:34
 * @版本 1.00
 */

@ApiModel(value = "赎货申请详情（网银）传入参数")
@Getter
@Setter
@ToString
public class CyberBankRedemptionApplyInfoInpDto extends CyBankRequestBaseDto {


    @ApiModelProperty(value = "赎货申请单号")
    @JsonProperty("REDPAPLYID")
    @Max(value = 32, message = "赎货申请单号超长")
    @NotNull(message = "赎货申请单号不能为空！")
    private String redpAplyId;

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

}
