package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api;

import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditCarInfoOutDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.DemoInputDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 10:42
 * @Description: 业务接口-{主要用于Feign继承和具体业务实现}
 */
@Api(tags = "汽车金融-Demo管理接口", description = "Demo接口主要是Rest APi集成Swagger的基础参照案例")
public interface DemoAPI {

    @ApiOperation(value = "Demo Test测试接口",notes = "该方法主要是Demo管理test接口！",response = CreditCarInfoOutDto.class)
    @PostMapping("/demo")
    BaseResponse<Map<String,Object>> test(DemoInputDto demoInputDto);

}
