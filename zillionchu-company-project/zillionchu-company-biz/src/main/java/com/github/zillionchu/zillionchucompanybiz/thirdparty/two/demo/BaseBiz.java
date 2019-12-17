package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.demo;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base.ExecuteClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 11:03
 * @Description:
 */
public abstract class BaseBiz {
    
    @Autowired
    private ExecuteClient executeClient;

    /**
     * Biz exe
     */
    public void execute() {

        /**
         * 0、限流（熔断）
         *
         * 1、接口幂等性验证
         *
         * 2、黑名单白名单（1、接口准入权限 , XSS）
         *
         * 3、参数验证（1.url解析和参数合法性验证 ;
         *            2.扩展加解密方案 非对称RSA和对称DES）
         *
         * 4、参数过滤转换（后台map参数）
         *
         * 5、调用后台接口（策略）
         *
         * 备注：整合与扩展
         *      1、Hystrix 熔断 隔离 降级
         *      2、Sleuth  zipkin
         *      3、redis  RabbitMQ  springboot整合swggerDoc
         *      4、API管理平台
         *
         */

        executeClient.executeClient();

    }

    /**
     * child post httpStrategy Impl
     *
     * @return
     */
    public abstract String httpImplIoc();

}
