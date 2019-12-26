package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/16 16:41
 * @Description:
 */
public interface HttpStrategy<R, T> {

    T httpRequest(R r);

    String APPLICATION_NAME = "zilionchu-server-http02:8502";
    String APPLICATION_NAME_LOCL = "127.0.0.1:8502";

    default String getURl() {
        return "http://" + APPLICATION_NAME_LOCL + "/%s";

    }

}
