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
 * @类名称 CyberBankTakeGoodsInpDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 16:28
 * @版本 1.00
 */

@ApiModel(value = "提货人信息（网银）传入参数")
@Getter
@Setter
@ToString
public class CyberBankTakeGoodsInpDto extends CyBankRequestBaseDto {


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
    @NotNull(message = "融资申请编号不能为空！")
    @Max(value = 32, message = "融资申请编号超长")
    @JsonProperty("FNCAPLYID")
    private String fncAplyId;

    @ApiModelProperty(value = "监管企业编号")
    @JsonProperty("REGENTID")
    @NotNull(message = "监管企业编号不能为空！")
    @Max(value = 32, message = "监管企业编号超长")
    private String regEntId;
}
