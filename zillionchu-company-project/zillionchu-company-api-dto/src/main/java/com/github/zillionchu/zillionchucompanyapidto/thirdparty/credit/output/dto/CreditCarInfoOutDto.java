package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @类名称 CreditCarInfoOutDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/12 20:10
 * @版本 1.00
 */

@ApiModel(value = "车辆信息接入（金融）参数")
@Getter
@Setter
@ToString
public class CreditCarInfoOutDto {

    @ApiModelProperty(value = "融资申请编号")
    private String FncAplyID;

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
    private String VhclModl;

    @ApiModelProperty(value = "车辆数量")
    private Integer VhclNum;

    @ApiModelProperty(value = "车辆价格")
    private BigDecimal VhclPrc;


}
