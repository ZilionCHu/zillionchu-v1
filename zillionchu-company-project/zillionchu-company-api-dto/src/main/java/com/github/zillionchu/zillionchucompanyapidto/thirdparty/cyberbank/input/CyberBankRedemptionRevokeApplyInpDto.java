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
 * @类名称 CyberBankRedemptionRevokeApplyInpDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 14:50
 * @版本 1.00
 */
@ApiModel(value = "赎货申请撤销（网银）传入参数")
@Getter
@Setter
@ToString
public class CyberBankRedemptionRevokeApplyInpDto extends CyBankRequestBaseDto {

    @ApiModelProperty(value = "赎货申请单号")
    @JsonProperty("REDPAPLYID")
    @Max(value = 32, message = "赎货申请单号超长")
    @NotNull(message = "赎货申请单号不能为空！")
    private String redpAplyId;

}
