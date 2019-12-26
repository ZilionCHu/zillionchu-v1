package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 10:49
 * @Description:
 */
@Data
@ToString
@ApiModel(value = "Demo请求参数",description = "Demo请求参数")
public class DemoInputDto extends BaseEntity{

    @ApiModelProperty(value = "年龄",required = true,example = "28")
    private String demo;

}
