package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.biz;
import com.alibaba.fastjson.JSON;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api.EntrstdpybacdtoAPI;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.base.BaseBiz;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.impl.EntrstdpybacdtoHttpPost;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Entrstdpybacdto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.HttpStrategy;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EntrstdpybacdtoBiz extends BaseBiz<Entrstdpybacdto, Map> implements EntrstdpybacdtoAPI, LoggerBase {

    @Autowired
    private EntrstdpybacdtoHttpPost tHttpPost;
    HttpStrategy httpStrategy;

    @Override
    public Map getEntrstdpybacdto(@RequestBody Entrstdpybacdto paramEntity) {
        info("EntrstdpybacdtoBiz into getEntrstdpybacdto method");
        Map execute = execute(paramEntity);
        info("EntrstdpybacdtoBiz getEntrstdpybacdto result is {}: ", JSON.toJSON(execute));
        return execute;
    }

    @Override
    public HttpStrategy httpStrategy() {
        return httpStrategy;
    }



}