package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.HttpStrategy;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.DemoInputDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.github.zillionchu.zillionchucompanycore.thirdparty.http.HttpClientUtils;
import com.google.common.collect.Maps;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/16 16:49
 * @Description:
 */
@Component
public class DemoHttpPost extends AbstractHttpPost implements HttpStrategy<DemoInputDto, Map>, LoggerBase {

    private static final String H_HYSTRIXCOMMAND_GROUPKEY = "demoBiz";
    private static final String H_HYSTRIXCOMMAND_COMMONDKEY = "demoBiz-post";
    private static final String H_HYSTRIXCOMMAND_THREDPOOLKEY = "demoBiz-pool";

    @Override
    public Map httpRequest(DemoInputDto demoInputDto) {
        return (Map) new DemoPostHystrixCommand(demoInputDto).execute();
    }

    public String getUrlString() {
        return getURl();
    }


    class DemoPostHystrixCommand<T> extends HystrixCommand<JSONObject> implements LoggerBase {

        private T t;

        protected DemoPostHystrixCommand(T t) {
            super(setter(H_HYSTRIXCOMMAND_GROUPKEY, H_HYSTRIXCOMMAND_COMMONDKEY, H_HYSTRIXCOMMAND_THREDPOOLKEY));
            this.t=t;
        }

        @Override
        protected JSONObject run() throws Exception {
            JSONObject jsonObject = new JSONObject();
            String sJson = jsonObject.toJSONString(t);
            JSONObject jsonObjectParam = JSONObject.parseObject(sJson);
            String urlString = DemoHttpPost.this.getUrlString();
            JSONObject repJSon = HttpClientUtils.httpPost(String.format(urlString, "indexPost"), jsonObjectParam);
            return repJSon;
        }


        @Override
        protected JSONObject getFallback() {
            // throw new ThirdPartyException("请稍后再试");
            HashMap<String, Object> map = Maps.newHashMap();
            map.put("code", "888888");
            map.put("msg", "请稍后再试呀");
            info("熔断开始了呀！！！！！！！！！！！！！ ###########################");
            return JSONObject.parseObject(map.toString());
        }

    }


}
