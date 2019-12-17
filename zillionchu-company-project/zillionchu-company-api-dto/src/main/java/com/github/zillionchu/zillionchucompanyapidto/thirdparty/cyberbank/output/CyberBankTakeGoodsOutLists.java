package com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankResponseBaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @类名称 CyberBankTakeGoodsOutLists
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/11 16:52
 * @版本 1.00
 */
@Getter
@Setter
@ToString
public class CyberBankTakeGoodsOutLists extends CyBankResponseBaseDto {

    @JsonProperty("DATA")
    private List<CyberBankTakeGoodsOutDto> reptCstLis;
}
