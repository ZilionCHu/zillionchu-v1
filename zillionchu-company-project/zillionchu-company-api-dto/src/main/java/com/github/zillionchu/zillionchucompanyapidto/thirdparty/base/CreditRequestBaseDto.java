package com.github.zillionchu.zillionchucompanyapidto.thirdparty.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @类名称 requestBaseDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/24 11:54
 * @版本 1.00
 */

@ApiModel(value = "请求公共报文")
@Getter
@Setter
@ToString
public class CreditRequestBaseDto {


    @ApiModelProperty(value = "渠道标识码")
    private String chnlNo = "30";

    /**
     * //0-正常 1-重发 2-恢复
     */
    @ApiModelProperty(value = "服务性质")
    private String tradeflag = "0";

    /**
     * 17个字节的定长数字
     */
    @ApiModelProperty(value = "流水号")
    private String seqNo;

    /**
     * 格式：hhmmss
     */
    @JsonFormat(pattern = "hhmmss", timezone = "GMT+8")
    @ApiModelProperty(value = "本地时间")
    private String localTime;  //

    /**
     * 格式：YYYYMMDD  年月日
     */
    @JsonFormat(pattern = "yyyyMMdd", timezone = "GMT+8")
    @ApiModelProperty(value = "本地日期")
    private String localDate;

    /**
     * 格式：YYYYMMDD  年月日
     */
    @JsonFormat(pattern = "yyyyMMdd", timezone = "GMT+8")
    @ApiModelProperty(value = "会计日期")
    private String clearDate;

    /**
     * 信贷：99710670000
     */
    @ApiModelProperty(value = "消费方系统代码（信贷）")
    private String transInst = "99710670000";

    /**
     * 信贷：99710670000
     */
    @ApiModelProperty(value = "请求方系统代码（信贷）")
    private String sendInst = "99460000000";

    @ApiModelProperty(value = "系统跟踪号")
    /**
     * 34位定长的字母、数字和/或特殊符号字符。
     * 由服务消费方系统（如：银联前置系统、网点前台等）产生，由一个初始值开始，
     * 以日期为单位，每笔交易生成系统内唯一标识号；
     * 交易过程中不可更改，跨系统交易原样传输。其由3部分组成，34位数字组合码，如下：
     ××××××××××× ××××××××  ×××××××××××××××
     生成系统代码            日期             交易唯一标识号
     */
    private String sysTrackNo;

    /**
     * 公贷：99460000000
     */
    @ApiModelProperty(value = "提供方系统代码(公贷)")
    private String destInst = "99460000000";

    @ApiModelProperty(value = "报文鉴别码")
    private String mac;

}
