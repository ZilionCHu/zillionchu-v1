package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/16 16:41
 * @Description:
 */
public interface HttpStrategy<R, T> {

    T httpRequest(R r);

    String APPLICATION_NAME = "zilionchu-server-http02";

    default String getURl() {
        return "http://" + APPLICATION_NAME + "/";
    }



    String url="http://zilionchu-server-http02/";

}
