package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 14:19
 * @Description:
 */
public class BaseHandler {

    protected ExecuteHandler nextExeCuteHandler;

    public void setNextHandler(ExecuteHandler nextExeCuteHandler) {
        this.nextExeCuteHandler = nextExeCuteHandler;
    }

}
