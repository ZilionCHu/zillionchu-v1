package com.zillionchu.server.zilionchuserverhttp01.feign;

import com.alibaba.fastjson.JSONObject;
import com.zillionchu.server.zilionchuserverhttp01.utils.HttpClientUtils;
import org.springframework.stereotype.Service;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/5 11:17
 * @Description:
 */
@Service
public class Http02Service {

    public JSONObject getHttp02Service(String http01) {
        JSONObject result = HttpClientUtils.httpGet("http://127.0.0.1:8502/index?param=" + http01 + "");
        return result;
    }
}
