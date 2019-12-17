package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @类名称 CyberBankQueryCarInfosDto
 * @类描述 网银车辆查询 参数转换类
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/10 9:37
 * @版本 1.00
 */
@Getter
@Setter
@ToString
public class ParamsCBQueryCarsDto {


    private String fncAplyId;

    private String lndEntpID;

    private String pageNum;

    private String pageSize;

}
