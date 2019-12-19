package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy;

import com.google.common.collect.Maps;
import org.apache.logging.log4j.util.Strings;

import java.util.Map;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/16 17:19
 * @Description:
 */
public class HttpStrategyFactory {

    private static Map<String, HttpStrategy> strategyMapBean = Maps.newConcurrentMap();

    public static HttpStrategy getHttpStrategy(String classWay) {
        try {
            if (Strings.isBlank(classWay)) {
                return null;
            }
            HttpStrategy httpStrategyMap = strategyMapBean.get(classWay);
            if (httpStrategyMap != null) {
                return httpStrategyMap;
            }
            Class<?> aClass = Class.forName(classWay);
            HttpStrategy httpStrategy = (HttpStrategy) aClass.newInstance();
            strategyMapBean.put(classWay, httpStrategy);
            return httpStrategy;
        } catch (Exception e) {
            return null;
        }
        //return null;
    }

}
