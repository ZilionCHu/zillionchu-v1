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
 * @Auther: ZiLlionChu
 * @Date: 2019/9/11 16:02
 * @Description:
 */
@ApiModel(value = "客户信息传入（信贷）参数")
@Getter
@Setter
@ToString
public class CreditCustomerInfoInpDto extends CreditRequestBaseDto {

    @ApiModelProperty(value = "客户编号", name = "CstID", example = "石家庄天缘乳业有限公司")
    @NotNull(message = "客户编号不能为空！")
    @Max(value = 21, message = "客户编号超长")
    private String cstId;

    @ApiModelProperty(value = "客户名称", name = "CstID", example = "10000006511472")
    private String cstNm;

    private transient boolean flag;

    public boolean getFlag() {
        return flag;
    }
}
