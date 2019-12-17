package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @类名称 CreditCustomerShareholderOutDto
 * @类描述 客户信息股东信息
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/11 19:25
 * @版本 1.00
 */

@ApiModel(value = "客户股东信息接入（金融）参数")
@Getter
@Setter
@ToString
public class CreditCustomerShareholderOutDto {

    @ApiModelProperty(value = "股东名称")
    private String shrhNm;

    @ApiModelProperty(value = "股东类型")
    private String shrhTp;

    @ApiModelProperty(value = "证件类型")
    private String crdtTp;

    @ApiModelProperty(value = "证件号码")
    private String crdtNo;

    @ApiModelProperty(value = "投资金额")
    private String ivsAmt;

    @ApiModelProperty(value = "投资币种")
    private String ivsCcy;

    @ApiModelProperty(value = "出资方式")
    private String fnddMod;

    @ApiModelProperty(value = "是否有效")
    private String wthrVld;

    @ApiModelProperty(value = "持股情况")
    private String holdshrSttn;


}
