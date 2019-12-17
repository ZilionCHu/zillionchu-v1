package com.zillionchu.server.zilionchuserverhttp01.config;

import com.alibaba.fastjson.JSONObject;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;

/**
 * @类名称 FeignExceptionDecoderHandler
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/22 18:35
 * @版本 1.00
 */
@Configuration
public class FeignExceptionDecoderHandler implements ErrorDecoder{

    @Override
    public Exception decode(String s, Response response) {

        String json = null;
        try {
            json = Util.toString(response.body().asReader());
            Map map = JSONObject.parseObject(json, Map.class);
           // info("FeignExceptionDecoderHandler  feign is = {}", json);
           // return new ThirdPartyException((String) map.get("message"));
        } catch (IOException e) {
            //info("FeignExceptionDecoderHandler  is {}", e);
            e.printStackTrace();
        }
        return new RuntimeException(json);

    }
}
