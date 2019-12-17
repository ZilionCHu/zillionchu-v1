package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.factory;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base.ExecuteHandler;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.util.SpringContextUtil;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 14:37
 * @Description:
 */
public class ExecuteFactory {

    public static ExecuteHandler getHandler() {
        ExecuteHandler handler1 = (ExecuteHandler) SpringContextUtil.getBean("limitRequestHandler");
        ExecuteHandler handler2 = (ExecuteHandler) SpringContextUtil.getBean("uniqueRequestHandler");
        handler1.setNextHandler(handler2);
        return handler1;
    }


}
