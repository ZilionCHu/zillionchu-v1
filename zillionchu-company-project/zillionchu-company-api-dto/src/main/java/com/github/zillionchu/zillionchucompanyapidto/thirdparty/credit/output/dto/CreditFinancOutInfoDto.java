package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @类名称 CreditFinancOutInfoDto
 * @类描述
 * @作者 tykj@tansun.cn
 * @创建时间 2019/9/12 15:13
 * @版本 1.00
 */

@ApiModel(value = "融资信息接入参数")
@Getter
@Setter
@ToString
public class CreditFinancOutInfoDto {

    @ApiModelProperty(value = "业务方案编号")
    @NotNull(message = "业务方案编号不能为空！")
    private String BsnScmID;

    @ApiModelProperty(value = "信贷客户编号")
    @NotNull(message = "信贷客户编号不能为空！")
    private String CrCstID;

    @ApiModelProperty(value = "客户名称")
    @NotNull(message = "客户名称不能为空！")
    private String CstNm;

    /**
     * 融资申请信息
     */
    @ApiModelProperty(value = "融资申请信息")
    List<CreditFinancApplyOutInfoDto> applyOutInfoDtoList;

    /**
     * 车辆信息
     */
    @ApiModelProperty(value = "融资申请车辆信息")
    List<CreditFinancVehOutInfoDto> vehOutInfoDtoList;

}
