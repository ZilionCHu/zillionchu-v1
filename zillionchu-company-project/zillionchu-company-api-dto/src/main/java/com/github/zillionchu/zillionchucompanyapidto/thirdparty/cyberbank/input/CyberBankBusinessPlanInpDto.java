package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankRequestBaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @类名称 CyberBankBusinessPlanInpDao
 * @类描述 业务方案申请
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 16:34
 * @版本 1.00
 */
@ApiModel(value = "业务方案申请（网银）传入参数")
@Getter
@Setter
@ToString
public class CyberBankBusinessPlanInpDto extends CyBankRequestBaseDto implements Serializable {

    @ApiModelProperty(value = "页数")
    @JsonProperty("PAGENUM")
    @NotNull(message = "pageNum不能为空！")
    @Max(value = 32, message = "pageNum超长")
    private String pageNum;

    @ApiModelProperty(value = "每页多少条")
    @JsonProperty("PAGESIZE")
    @NotNull(message = "pageSize不能为空！")
    @Max(value = 32, message = "pageSize超长")
    private String pageSize;


    @ApiModelProperty(value = "信贷客户号")
    @NotNull(message = "信贷客户号不能为空！")
    @Max(value = 32, message = "信贷客户号超长")
    @JsonProperty("CRCST_NO")
    private String cstId;

    @ApiModelProperty(value = "客户名称")
    @JsonProperty("CST_NM")
    @Max(value = 32, message = "客户名称超长")
    @NotNull(message = "客户名称不能为空！")
    private String cstNm;

//    @ApiModelProperty(value = "业务协议编号")
//    @JsonProperty("BSN_AGRM_ID")
//    @Max(value = 32, message = "业务协议编号超长")
//    @NotNull(message = "业务协议编号不能为空！")
//    // private String bsnAgrmID;
//    private String ctrNo;

}
