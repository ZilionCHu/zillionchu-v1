package com.github.zillionchu.zillionchucompanyapidto.thirdparty.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @类名称 requestBaseDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/24 11:54
 * @版本 1.00
 */

@ApiModel(value = "网银请求公共报文")
@Getter
@Setter
@ToString
public class CyBankRequestBaseDto implements Serializable {

    @ApiModelProperty(value = "渠道标识码")
    @JsonProperty("CHNLNO")
    private String chnlNO;

    /**
     * //0-正常 1-重发 2-恢复
     */
    @ApiModelProperty(value = "服务性质")
    @JsonProperty("TRADEFLAG")
    private String tradeflag;

    /**
     * 17个字节的定长数字
     */
    @ApiModelProperty(value = "流水号")
    @JsonProperty("SEQNO")
    private String seqNo;

    /**
     * 格式：hhmmss
     */
    @JsonFormat(pattern = "hhmmss", timezone = "GMT+8")
    @ApiModelProperty(value = "本地时间")
    @JsonProperty("LOCALTIME")
    private String localTime;  //

    /**
     * 格式：YYYYMMDD  年月日
     */
    @JsonFormat(pattern = "yyyyMMdd", timezone = "GMT+8")
    @ApiModelProperty(value = "本地日期")
    @JsonProperty("LOCALDATE")
    private String localDate;

    /**
     * 格式：YYYYMMDD  年月日
     */
    @JsonFormat(pattern = "yyyyMMdd", timezone = "GMT+8")
    @ApiModelProperty(value = "会计日期")
    @JsonProperty("CLEARDATE")
    private String clearDate;

    /**
     * 信贷：99710670000
     */
    @ApiModelProperty(value = "消费方系统代码（信贷）")
    @JsonProperty("TRANSINST")
    private String transInst;

    /**
     * 信贷：99710670000
     */
    @ApiModelProperty(value = "请求方系统代码（信贷）")
    @JsonProperty("SENDINST")
    private String sendInst;

    @ApiModelProperty(value = "系统跟踪号")
    /**
     * 34位定长的字母、数字和/或特殊符号字符。
     * 由服务消费方系统（如：银联前置系统、网点前台等）产生，由一个初始值开始，
     * 以日期为单位，每笔交易生成系统内唯一标识号；
     * 交易过程中不可更改，跨系统交易原样传输。其由3部分组成，34位数字组合码，如下：
     ××××××××××× ××××××××  ×××××××××××××××
     生成系统代码            日期             交易唯一标识号
     */
    @JsonProperty("SYSTRACKNO")
    private String sysTrackNo;

    /**
     * 公贷：99460000000
     */
    @ApiModelProperty(value = "提供方系统代码(公贷)")
    @JsonProperty("DESTINST")
    private String destInst;

    @ApiModelProperty(value = "报文鉴别码")
    @JsonProperty("MAC")
    private String mac;

}
