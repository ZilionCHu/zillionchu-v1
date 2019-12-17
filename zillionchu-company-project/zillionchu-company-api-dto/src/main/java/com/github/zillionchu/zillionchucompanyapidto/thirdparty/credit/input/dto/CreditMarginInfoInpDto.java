package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.input.dto;

import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CreditRequestBaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @类名称 CreditIousInfoInpDto
 * @类描述
 * @作者 tykj@tansun.cn
 * @创建时间 2019/9/11 17:06
 * @版本 1.00
 */
@ApiModel(value = "保证金信息接入参数")
@Getter
@Setter
@ToString
public class CreditMarginInfoInpDto extends CreditRequestBaseDto {

    @ApiModelProperty(value = "融资申请编号")
    @NotNull(message = "融资申请编号不能为空！")
    @Max(value = 40, message = "融资申请编号超长")
    private String fncAplyId;

    @ApiModelProperty(value = "保证金账户名")
    private String mrgnAccNm;

    @ApiModelProperty(value = "保证金账号")
    private String mrgnAccno;


    private transient boolean flag;

    public boolean getFlag() {
        return flag;
    }


}
