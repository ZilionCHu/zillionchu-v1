package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @类名称 CreditCustomerOfficerInfoOut
 * @类描述 客户高管信息
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/11 19:02
 * @版本 1.00
 */

@ApiModel(value = "客户高管信息接入（金融）参数")
@Getter
@Setter
@ToString
public class CreditCustomerExeOfficerOutDto {

    @ApiModelProperty(value = "高管姓名")
    private String executiveNm;

    @ApiModelProperty(value = "担任职务")
    private String position;

    @ApiModelProperty(value = "证件类型")
    private String crdtTp;

    @ApiModelProperty(value = "证件号码")
    private String crdtNo;

    @ApiModelProperty(value = "性别")
    private String gnd;

    @ApiModelProperty(value = "出生日期")
    private String brthDt;

    @ApiModelProperty(value = "学历")
    private String eddgr;

    @ApiModelProperty(value = "相关行业从业年限")
    private String relldyCreryrLmt;

    @ApiModelProperty(value = "联系电话")
    private String ctcTel;

    @ApiModelProperty(value = "固定电话")
    private String fixTel;

}
