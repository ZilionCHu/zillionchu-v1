package com.github.zillionchu.zillionchucompanybiz;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base.ExecuteHandler;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.util.ServiceBootstrap;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

//@SpringBootTest
class ZillionchuCompanyBizApplicationTests {

    @Test
    void contextLoads() {
        ExecuteHandler executeHandler = ServiceBootstrap.loadFirst(ExecuteHandler.class);
      //  assertTrue(executeHandler instanceof LimitRequestHandler);
    }

    @Test
    void contextLoads01() {
        Iterator<ExecuteHandler> executeHandlerIterator = ServiceBootstrap.loadAll(ExecuteHandler.class);
        while (executeHandlerIterator.hasNext()){
            ExecuteHandler next = executeHandlerIterator.next();
            System.out.println(next.getClass().getName());
        }
    }
}
