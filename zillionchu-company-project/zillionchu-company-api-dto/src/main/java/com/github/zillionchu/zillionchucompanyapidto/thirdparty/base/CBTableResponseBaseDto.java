package com.github.zillionchu.zillionchucompanyapidto.thirdparty.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @类名称 responseBaseDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/24 11:54
 * @版本 1.00
 */
@ApiModel(value = "返回公共报文")
@Getter
@Setter
@ToString
public class CBTableResponseBaseDto<T> extends CyBankResponseBaseDto {

    @ApiModelProperty(value = "总条数")
    private String TOTAL;

    @ApiModelProperty(value = "返回列表JSONArray")
    private T DATA;

    @ApiModelProperty(value = "JSONArray容量")
    private String ROWSIZE;

}
