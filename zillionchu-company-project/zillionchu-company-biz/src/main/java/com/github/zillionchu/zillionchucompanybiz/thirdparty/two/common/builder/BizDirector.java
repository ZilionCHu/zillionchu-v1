package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.builder;

import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.github.zillionchu.zillionchucompanycore.thirdparty.exception.ThirdPartyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/18 11:55
 * @Description:
 */
@Component
public class BizDirector<T> implements LoggerBase {

    @Autowired
    private BaseBuild baseBuild;

    public void direcot(T t) {

        /**
         * 限流
         */
        Boolean limitRequest = baseBuild.LimitRequest();
        if (!limitRequest) {
            throw new ThirdPartyException("请稍后访问");
        }

        /**
         * 幂等
         */
        Boolean uniqueRequest = baseBuild.UniqueRequest();
        if (uniqueRequest) {

        }
    }


}
