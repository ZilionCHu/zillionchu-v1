package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.DemoEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 10:42
 * @Description: 业务接口-{主要用于Feign继承和具体业务实现}
 */
@Api(tags = "This is Demo")
public interface DemoAPI {

    @ApiOperation(value = "This is test method")
    @PostMapping("/demo")
    Map test(DemoEntity demoEntity);

}
