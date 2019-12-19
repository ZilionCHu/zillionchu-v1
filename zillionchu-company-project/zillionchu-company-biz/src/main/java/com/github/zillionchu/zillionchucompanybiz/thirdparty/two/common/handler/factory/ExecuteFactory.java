package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.factory;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base.ExecuteHandler;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.util.ServiceBootstrap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 14:37
 * @Description:
 */
public class ExecuteFactory {

    /**
     * link execuete impl
     *
     * @return
     */
    public static ExecuteHandler getHandler() {
        Iterator<ExecuteHandler> executeHandlerIterator = ServiceBootstrap.loadAll(ExecuteHandler.class);
        LinkedList<ExecuteHandler> var1 = Lists.newLinkedList();
        while (executeHandlerIterator.hasNext()) {
            ExecuteHandler var2 = executeHandlerIterator.next();
            var1.add(var2);
        }

        for (int i = 0; i < var1.size(); ++i) {
            int next = i + 1;
            ExecuteHandler var3 = var1.get(i);
            if (next != var1.size()) {
                ExecuteHandler var5 = var1.get(next);
                var3.setNextHandler(var5);
            }
        }

        return var1.getFirst();

    }

    public static void main(String[] args) {
        LinkedList<String> var1 = Lists.newLinkedList(Sets.newHashSet("a", "b"));
        for (int i = 0; i < var1.size(); i++) {
            int next = i + 1;
            if (next != var1.size()) {
                System.out.println(String.format(" next value is : %s %s", i, var1.get(next)));
            }
        }
        System.out.println(String.format(" var1 first is : %s ", var1.getFirst()));

    }

}
