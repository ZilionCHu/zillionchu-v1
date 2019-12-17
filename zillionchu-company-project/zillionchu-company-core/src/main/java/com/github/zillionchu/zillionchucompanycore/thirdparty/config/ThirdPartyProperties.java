package com.github.zillionchu.zillionchucompanycore.thirdparty.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @类名称 ThirdPartyProperties
 * @类描述 外部配置统一在这添加
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/17 14:36
 * @版本 1.00
 */
@Configuration
@ConfigurationProperties(prefix = "thirdparty.config")
public class ThirdPartyProperties {

    private Boolean manMade;

    public Boolean getManMade() {
        return manMade;
    }

    public void setManMade(Boolean manMade) {
        this.manMade = manMade;
    }





}
