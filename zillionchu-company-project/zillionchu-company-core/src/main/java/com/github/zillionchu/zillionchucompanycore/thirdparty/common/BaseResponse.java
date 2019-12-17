package com.github.zillionchu.zillionchucompanycore.thirdparty.common;


import com.github.zillionchu.zillionchucompanycore.thirdparty.enums.ThirdPartyStatusEnum;
import org.springframework.stereotype.Component;

/**
 * @类名称 BaseResponse
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 14:53
 * @版本 1.00
 */
@Component
public class BaseResponse<T> {

    /**
     * 响应码
     */
    private String respCode;

    /**
     * 响应信息
     */
    private String respInfo;


    /**
     * 返回报文
     */
    private T data;

    public BaseResponse() {
    }

    public void setSuccess(T data) {
        this.respCode = ThirdPartyStatusEnum.TB_SUCCESS.getCode();
        this.respInfo = ThirdPartyStatusEnum.TB_SUCCESS.getName();
        this.data = data;
    }

    public void setFail() {
        this.respCode = ThirdPartyStatusEnum.TB_FAIL.getCode();
        this.respInfo = ThirdPartyStatusEnum.TB_FAIL.getName();
    }

    public BaseResponse(String respCode, String respInfo, T data) {
        this.respCode = respCode;
        this.respInfo = respInfo;
        this.data = data;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespInfo() {
        return respInfo;
    }

    public void setRespInfo(String respInfo) {
        this.respInfo = respInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
