package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.factory.ExecuteFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 14:43
 * @Description:
 */
@Component
public class ExecuteClient {

    public void executeClient(){
        ExecuteHandler executeHandler = ExecuteFactory.getHandler();
        executeHandler.executeBiz();
    }

}
