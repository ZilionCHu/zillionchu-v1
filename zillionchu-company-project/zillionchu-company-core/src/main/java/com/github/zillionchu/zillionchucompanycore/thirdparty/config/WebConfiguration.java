package com.github.zillionchu.zillionchucompanycore.thirdparty.config;

import com.github.zillionchu.zillionchucompanycore.thirdparty.common.RequestHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @类名称 WebConfiguration
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/20 11:01
 * @版本 1.00
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(new RequestHandler());
    }

}
