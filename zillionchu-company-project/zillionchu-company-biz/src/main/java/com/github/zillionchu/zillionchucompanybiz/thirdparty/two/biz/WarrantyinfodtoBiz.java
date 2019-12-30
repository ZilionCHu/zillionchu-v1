package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.biz;
import com.alibaba.fastjson.JSON;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api.WarrantyinfodtoApi;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.base.BaseBiz;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.impl.WarrantyinfodtoHttpPost;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Warrantyinfodto;
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
public class WarrantyinfodtoBiz extends BaseBiz<Warrantyinfodto, Map> implements WarrantyinfodtoApi, LoggerBase {

    @Autowired
    private WarrantyinfodtoHttpPost post;

    HttpStrategy httpStrategy;

    @Override
    public Map getWarrantyinfodto(@RequestBody Warrantyinfodto paramEntity) {
        info("WarrantyinfodtoBiz into getWarrantyinfodto method");
        Map execute = execute(paramEntity);
        info("WarrantyinfodtoBiz getWarrantyinfodto result is {}: ", JSON.toJSON(execute));
        return execute;
    }

    @Override
    public HttpStrategy httpStrategy() {
        return httpStrategy;
    }



}