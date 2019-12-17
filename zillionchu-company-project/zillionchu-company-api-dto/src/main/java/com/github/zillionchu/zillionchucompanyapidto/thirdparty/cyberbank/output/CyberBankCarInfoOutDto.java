package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @类名称 CyberBankCarInfoOutDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 16:26
 * @版本 1.00
 */

@ApiModel(value = "车辆信息（供应链）返回参数")
@Getter
@Setter
@ToString
public class CyberBankCarInfoOutDto {

    @ApiModelProperty(value = "融资申请编号")
    @NotNull(message = "融资申请编号不能为空！")
    @JsonProperty("FNCAPLYID")
    private String fncAplyId;

    @ApiModelProperty(value = "订单编号")
    @NotNull(message = "订单编号不能为空！")
    @JsonProperty("ORDRID")
    private String ordrID;

    @ApiModelProperty(value = "车辆型号")
    @JsonProperty("VHCLMODL")
    @NotNull(message = "车辆型号不能为空！")
    private String vhclModl;

    @ApiModelProperty(value = "车辆描述")
    @JsonProperty("VHCLDSC")
    @NotNull(message = "车辆描述不能为空！")
    private String vhclDsc;

    @ApiModelProperty(value = "车架号")
    @NotNull(message = "车架号不能为空！")
    @JsonProperty("FRMNO")
    private String frmNo;

    @ApiModelProperty(value = "合格证编号")
    @NotNull(message = "合格证编号不能为空！")
    @JsonProperty("QLFDID")
    private String qlfdId;

    @ApiModelProperty(value = "车辆价格")
    @NotNull(message = "车辆价格不能为空！")
    @JsonProperty("VHCLPRC")
    private BigDecimal vhclPrc;

    @ApiModelProperty(value = "发动机编号")
    @NotNull(message = "信贷客户号不能为空！")
    @JsonProperty("ENGID")
    private String engId;

    @ApiModelProperty(value = "车钥匙数量")
    @NotNull(message = "车钥匙数量不能为空！")
    @JsonProperty("CARKYNUM")
    private Integer carKyNum;

    @ApiModelProperty(value = "出厂日期")
    @NotNull(message = "出厂日期不能为空！")
    @JsonProperty("PDDT")
    private String pdDt;

    @ApiModelProperty(value = "车辆状态")
    @NotNull(message = "车辆状态不能为空！")
    @JsonProperty("VHCLST")
    private String vhclSt;

    @ApiModelProperty(value = "所在仓库编号")
    @NotNull(message = "所在仓库编号不能为空！")
    @JsonProperty("WBTSTGID")
    private String wbtStgId;

    @ApiModelProperty(value = "所在仓库名称")
    @NotNull(message = "所在仓库名称不能为空！")
    @JsonProperty("WBTSTGNM")
    private String wbtStgNm;

    @ApiModelProperty(value = "所在仓库名称")
    @JsonProperty("INDATE")
    private String storageDate;


}
