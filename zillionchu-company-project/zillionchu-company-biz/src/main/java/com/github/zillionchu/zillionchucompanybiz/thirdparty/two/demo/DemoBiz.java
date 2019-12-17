package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.demo;

import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 10:37
 * @Description: API接口的具体业务实现
 */
@RestController
public class DemoBiz extends BaseBiz implements DemoAPI, LoggerBase {

    @Override
    public void test(@RequestBody DemoEntity demoEntity) {
        info("Demobiz into test method");
        execute();
    }

    @Override
    public String httpImplIoc() {
        return null;
    }
}
