package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.biz;
import com.alibaba.fastjson.JSON;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api.CargomortgagedtoApi;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.base.BaseBiz;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.impl.CargomortgagedtoHttpPost;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Cargomortgagedto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.HttpStrategy;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 10:37
 * @Description: API接口的具体业务实现
 */
@RestController
public class CargomortgagedtoBiz extends BaseBiz<Cargomortgagedto, Map> implements CargomortgagedtoApi, LoggerBase {

    @Autowired
    private CargomortgagedtoHttpPost tHttpPost;
    HttpStrategy httpStrategy;

    @Override
    public Map getCargomortgagedto(@RequestBody Cargomortgagedto paramEntity) {
        info("Cargomortgagedtobiz into getCargomortgagedto method");
        Map execute = execute(paramEntity);
        info("CargomortgagedtoBiz getCargomortgagedt result is {}: ", JSON.toJSON(execute));
        return execute;
    }

    @Override
    public HttpStrategy httpStrategy() {
        return httpStrategy;
    }



}