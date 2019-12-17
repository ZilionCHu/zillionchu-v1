package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @类名称 CreditFinancVeh
 * @类描述
 * @作者 tykj@tansun.cn
 * @创建时间 2019/9/12 15:23
 * @版本 1.00
 */
@ApiModel(value = "融资申请车辆信息接入参数")
@Getter
@Setter
@ToString
public class CreditFinancVehOutInfoDto {

    @ApiModelProperty(value = "融资申请号")
    @NotNull(message = "融资申请号不能为空！")
    private String FncAplyNo;

    @ApiModelProperty(value = "品牌")
    private String Brnd;

    @ApiModelProperty(value = "车型")
    private String Modl;

    @ApiModelProperty(value = "合格证号")
    private String QlfdNo;

    @ApiModelProperty(value = "生产批号")
    private String PdBtchNo;

    @ApiModelProperty(value = "生产日期")
    private Date PdDt;

    @ApiModelProperty(value = "车辆型号")
    @NotNull(message = "车辆型号不能为空！")
    private String VhclModl;

    @ApiModelProperty(value = "车辆价格")
    @NotNull(message = "车辆价格不能为空！")
    private BigDecimal VhclPrc;

    @ApiModelProperty(value = "监管企业")
    @NotNull(message = "监管企业不能为空！")
    private String RegEntp;

}
