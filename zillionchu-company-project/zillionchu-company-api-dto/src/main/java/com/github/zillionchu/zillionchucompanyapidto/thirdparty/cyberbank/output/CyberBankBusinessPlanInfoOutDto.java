package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @类名称 CyberBankBusinessPlanInfoOutDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 16:49
 * @版本 1.00
 */

@ApiModel(value = "业务方案申请信息（供应链）返回参数")
@Getter
@Setter
@ToString
public class CyberBankBusinessPlanInfoOutDto {


    @ApiModelProperty(value = "业务协议编号")
    @NotNull(message = "信贷客户号不能为空！")
    @JsonProperty("BSN_AGRM_ID")
    private String ctrNo;

    @ApiModelProperty(value = "业务方案编号")
    @NotNull(message = "业务方案编号不能为空！")
    @JsonProperty("BSN_SCM_ID")
    private String ctrId;

    @ApiModelProperty(value = "业务方案状态")
    @NotNull(message = "业务方案状态不能为空！")
    @JsonProperty("BSN_SCM_ST")
    private String ctrStcd;

}
