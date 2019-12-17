package com.github.zillionchu.zillionchucompanycore.thirdparty.common;

import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankRequestBaseDto;
import org.springframework.stereotype.Component;

/**
 * @类名称 RequestDtoThredLocal
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/20 13:09
 * @版本 1.00
 */
@Component
public class RequestDtoHandler {

    private final static ThreadLocal<CyBankRequestBaseDto> requestDaoHandler = new ThreadLocal();

    public static void set(CyBankRequestBaseDto cyBankRequestBaseDto) {
        requestDaoHandler.set(cyBankRequestBaseDto);
    }

    public static CyBankRequestBaseDto get() {
        return requestDaoHandler.get();
    }

    public static void remove() {
        requestDaoHandler.remove();
    }

}
