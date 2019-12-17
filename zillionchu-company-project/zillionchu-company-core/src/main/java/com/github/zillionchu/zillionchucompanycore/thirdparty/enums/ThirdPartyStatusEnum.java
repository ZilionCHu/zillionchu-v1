package com.github.zillionchu.zillionchucompanycore.thirdparty.enums;

/**
 * @类名称 ThirdPartyEnum
 * @类描述 交易状态
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 15:10
 * @版本 1.00
 */
public enum ThirdPartyStatusEnum {

    T_PARTY_SUCCESS("000000", "交易成功"),
    T_PARTY_PG_FAIL("100400", "请求失败"),
    T_PARTY_OVERTIME("110022", "交易超时"),
    T_PARTY_SYS_ERROR("999999", "系统错误"),
    T_PARTY_SYS_AVAILABLE("100503", "服务不可用"),
    T_PARTY_ZUUL_OVERTIME("100504", "网关超时"),
    T_PARTY_NO_REPETITION("204015", "无复合条件的记录（查询交易）"),
    T_PARTY_NO_GET_CODE_MSG("777777", "未收到提供方响应码响应信息"),


    //内部状态码
    TB_SUCCESS("200", "交易成功"),
    TB_FAIL("500", "交易失败");

    private final String code;
    private final String name;

    ThirdPartyStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


}
