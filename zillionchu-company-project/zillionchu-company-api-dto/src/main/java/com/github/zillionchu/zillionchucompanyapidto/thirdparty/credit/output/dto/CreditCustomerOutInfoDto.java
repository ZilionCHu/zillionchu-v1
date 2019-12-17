package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/9/11 16:02
 * @Description:
 */

@ApiModel(value = "客户信息接入（金融）参数")
@Getter
@Setter
@ToString
public class CreditCustomerOutInfoDto {

    @ApiModelProperty(value = "信贷客户编号")
    @NotNull(message = "信贷客户编号不能为空！")
    private String crcstId;

    @ApiModelProperty(value = "客户名称")
    @NotNull(message = "客户名称不能为空！")
    private String cstNm;

    @ApiModelProperty(value = "客户英文名")
    @NotNull(message = "客户英文名不能为空！")
    private String cstEngNm;


    @ApiModelProperty(value = "企业证件类型")
    @NotNull(message = "企业证件类型不能为空！")
    private String entpCrdtTp;

    @ApiModelProperty(value = "企业证件号码")
    @NotNull(message = "企业证件号码不能为空！")
    private String entpCrdtNo;

    @ApiModelProperty(value = "组织机构代码")
    @NotNull(message = "组织机构代码不能为空！")
    private String orcd;

    @ApiModelProperty(value = "电话")
    private String tel;

    @ApiModelProperty(value = "Email地址")
    private String emailAdr;

    @ApiModelProperty(value = "公司网址")
    private String coWebst;

    @ApiModelProperty(value = "传真")
    private String fax;

    @ApiModelProperty(value = "联系人")
    private String ctcpsn;

    @ApiModelProperty(value = "联系人手机号")
    private String ctcPsnMblPhNo;

    @ApiModelProperty(value = "中征码")
    @NotNull(message = "中征码不能为空！")
    private String centerSignCd;

    @ApiModelProperty(value = "评级登记")
    private String rtgRgs;

    @ApiModelProperty(value = "企业规模")
    private String entpSz;

    @ApiModelProperty(value = "企业成立时间")
    private String entpFdTm;

    @ApiModelProperty(value = "币种")
    private String ccy;

    @ApiModelProperty(value = "注册资本（元）")
    private String rgstCptlamt;

    @ApiModelProperty(value = "注册地址")
    private String rgstAdr;

    /**
     * 高管
     */
    private List<CreditCustomerExeOfficerOutDto> creditCustomerExeOfficerOutDtos;

    /**
     * 客户经理
     */
    private List<CreditCustomerManagerOutDto> creditCustomerManagerOutDtos;

    /**
     * 股东
     *
     * @return
     */

    private List<CreditCustomerShareholderOutDto> creditCustomerShareholderOutDtos;

}
