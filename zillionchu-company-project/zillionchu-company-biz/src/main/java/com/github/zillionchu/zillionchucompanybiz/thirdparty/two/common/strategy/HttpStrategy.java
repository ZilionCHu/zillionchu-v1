package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/16 16:41
 * @Description:
 */
public interface HttpStrategy<R, T> {

    T httpRequest(R r);


    String URL_PREFIX = "http://";

    default String getURl(String suffix) {
        return URL_PREFIX + suffix;
    }

}
