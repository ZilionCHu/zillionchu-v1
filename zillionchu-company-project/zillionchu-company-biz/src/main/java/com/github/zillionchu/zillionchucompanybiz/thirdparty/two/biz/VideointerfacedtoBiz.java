package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.biz;
import com.alibaba.fastjson.JSON;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api.VideointerfacedtoAPI;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.base.BaseBiz;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Videointerfacedto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.HttpStrategy;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Map;
/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 10:37
 * @Description: API接口的具体业务实现
 */
@RestController
public class VideointerfacedtoBiz extends BaseBiz<Videointerfacedto, Map> implements VideointerfacedtoAPI, LoggerBase {

    @Resource(name = "videointerfacedtoHttpPost")
    HttpStrategy httpStrategy;

    @Override
    public Map getVideointerfacedto(@RequestBody Videointerfacedto paramEntity) {
        info("Demobiz into test method");
        Map execute = execute(paramEntity);
        info("DemoBiz test result is {}: ", JSON.toJSON(execute));
        return execute;
    }

    @Override
    public HttpStrategy httpStrategy() {
        return httpStrategy;
    }



}