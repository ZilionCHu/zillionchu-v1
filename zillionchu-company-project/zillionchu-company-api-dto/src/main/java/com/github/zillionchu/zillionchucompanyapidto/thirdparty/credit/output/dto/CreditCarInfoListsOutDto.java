package com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @类名称 CreditCarInfoListsOutDto
 * @类描述 车辆列表
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/2 15:23
 * @版本 1.00
 */
@ApiModel(value = "车辆信息输出（网银）汽车列表")
@Getter
@Setter
@ToString
public class CreditCarInfoListsOutDto {

    private List<CreditCarInfoOutDto> creditCarInfoOutDtos;
}
