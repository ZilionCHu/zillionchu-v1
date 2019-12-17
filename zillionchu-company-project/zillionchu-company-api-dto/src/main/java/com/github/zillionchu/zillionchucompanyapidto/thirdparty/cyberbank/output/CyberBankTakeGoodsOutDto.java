package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @类名称 CyberBankTakeGoodsOutDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 16:28
 * @版本 1.00
 */
@ApiModel(value = "提货人信息（供应链）返回参数")
@Getter
@Setter
@ToString
public class CyberBankTakeGoodsOutDto {

    @ApiModelProperty(value = "提货人名称")
    @NotNull(message = "提货人名称不能为空！")
    @JsonProperty("PCKUPGDSPSN")
    private String pckUpGdsPsn;


    @ApiModelProperty(value = "提货人身份证")
    @NotNull(message = "提货人身份证不能为空！")
    @JsonProperty("PCKUPGDSPSNIDCARD")
    private String pckUpGdsPsnIDCard;

}
