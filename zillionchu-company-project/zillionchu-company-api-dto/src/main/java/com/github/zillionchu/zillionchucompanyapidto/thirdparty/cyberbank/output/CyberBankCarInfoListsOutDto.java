package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankResponseBaseDto;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @类名称 CyberBankCarInfoListsOutDto
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/29 10:36
 * @版本 1.00
 */
@ApiModel(value = "车辆信息列表（供应链）返回参数")
@Getter
@Setter
@ToString
public class CyberBankCarInfoListsOutDto extends CyBankResponseBaseDto {


    @JsonProperty("DATA")
    private List<CyberBankCarInfoOutDto> data;

}
