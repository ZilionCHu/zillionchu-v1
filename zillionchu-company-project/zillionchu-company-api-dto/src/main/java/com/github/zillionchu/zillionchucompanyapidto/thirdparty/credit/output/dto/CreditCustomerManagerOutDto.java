package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @类名称 CreditCustomerManagerOutDto
 * @类描述 客户信息中客户经理信息
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/11 19:05
 * @版本 1.00
 */
@ApiModel(value = "客户信息客户经理接入（金融）参数")
@Getter
@Setter
@ToString
public class CreditCustomerManagerOutDto {


    @ApiModelProperty(value = "客户经理")
    private String cstMgr;

    @ApiModelProperty(value = "管理类型")
    private String mgtTp;

    @ApiModelProperty(value = "所属机构")
    private String blngInst;
}
