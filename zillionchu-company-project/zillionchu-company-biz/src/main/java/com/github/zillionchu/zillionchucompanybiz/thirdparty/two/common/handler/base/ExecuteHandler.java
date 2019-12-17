package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 14:21
 * @Description:
 */
public interface ExecuteHandler {


    void executeBiz();


    void setNextHandler(ExecuteHandler executeHandler);

}
