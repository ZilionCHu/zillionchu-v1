package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base.BaseHandler;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base.ExecuteHandler;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import org.springframework.stereotype.Component;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 14:27
 * @Description: 接口限流
 */
@Component
public class LimitRequestHandler extends BaseHandler implements ExecuteHandler , LoggerBase {

    @Override
    public void executeBiz() {
     info("###########################Start  one");
     nextExeCuteHandler.executeBiz();
    }


}
