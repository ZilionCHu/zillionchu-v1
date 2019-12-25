package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.biz;
import com.alibaba.fastjson.JSON;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api.FinancinginfodtoAPI;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.base.BaseBiz;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.impl.FinancinginfodtoHttpPost;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Financinginfodto;
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
public class FinancinginfodtoBiz extends BaseBiz<Financinginfodto, Map> implements FinancinginfodtoAPI, LoggerBase {

    @Autowired
    private FinancinginfodtoHttpPost fpost;
    HttpStrategy httpStrategy;

    @Override
    public Map getFinancinginfodto(@RequestBody Financinginfodto paramEntity) {
        info("FinancinginfodtoBiz into getFinancinginfodto method");
        Map execute = execute(paramEntity);
        info("FinancinginfodtoBiz getFinancinginfodto result is {}: ", JSON.toJSON(execute));
        return execute;
    }

    @Override
    public HttpStrategy httpStrategy() {
        return httpStrategy;
    }



}