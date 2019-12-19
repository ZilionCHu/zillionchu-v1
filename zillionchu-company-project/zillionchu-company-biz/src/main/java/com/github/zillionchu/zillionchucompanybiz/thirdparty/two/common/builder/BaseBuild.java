package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.builder;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/18 10:40
 * @Description:
 */
public interface BaseBuild {


    /**
     * 限流
     *
     * @return
     */
    Boolean LimitRequest();


    /**
     * 幂等
     *
     * @return
     */
    Boolean UniqueRequest();
}
