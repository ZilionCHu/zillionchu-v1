package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.biz;
import com.alibaba.fastjson.JSON;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api.HycmdtyvrtyclassdtoAPI;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.base.BaseBiz;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.impl.HycmdtyvrtyclassdtoHttpPost;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Hycmdtyvrtyclassdto;
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
public class HycmdtyvrtyclassdtoBiz extends BaseBiz<Hycmdtyvrtyclassdto, Map> implements HycmdtyvrtyclassdtoAPI, LoggerBase {

    @Autowired
    private HycmdtyvrtyclassdtoHttpPost tHttpPost;
    HttpStrategy httpStrategy;

    @Override
    public Map getHycmdtyvrtyclassdto(@RequestBody Hycmdtyvrtyclassdto paramEntity) {
        info("HycmdtyvrtyclassdtoBiz into getHycmdtyvrtyclassdto method");
        Map execute = execute(paramEntity);
        info("HycmdtyvrtyclassdtoBiz getHycmdtyvrtyclassdto result is {}: ", JSON.toJSON(execute));
        return execute;
    }

    @Override
    public HttpStrategy httpStrategy() {
        return httpStrategy;
    }



}