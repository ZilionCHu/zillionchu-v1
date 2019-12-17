package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base.BaseHandler;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base.ExecuteHandler;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 14:27
 * @Description: 接口限流
 */
public class LimitRequestHandler extends BaseHandler implements ExecuteHandler , LoggerBase {

    @Override
    public void executeBiz() {
     info("###########################Start  one");
     nextExeCuteHandler.executeBiz();
    }


}
