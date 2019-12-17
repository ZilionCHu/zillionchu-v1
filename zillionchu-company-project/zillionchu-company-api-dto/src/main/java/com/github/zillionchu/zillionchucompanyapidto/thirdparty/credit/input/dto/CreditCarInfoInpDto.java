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
 * @类名称 CreditCarInfoInpDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/12 20:10
 * @版本 1.00
 */
@ApiModel(value = "车辆信息传入（信贷）参数")
@Getter
@Setter
@ToString
public class CreditCarInfoInpDto extends CreditRequestBaseDto {

    @ApiModelProperty(value = "融资申请编号")
    private String fncAplyId;

    @ApiModelProperty(value = "业务方案编号")
    @NotNull(message = "融资放款日期不能为空！")
    @Max(value = 40, message = "bizSchemeNum超长")
    private String bizSchemeNum;


    private transient boolean flag;

    public boolean getFlag() {
        return flag;
    }

}
