package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.biz;

import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api.DemoAPI;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.base.BaseBiz;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.HttpStrategy;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.DemoInputDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
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
public class DemoBiz extends BaseBiz<DemoInputDto, Map> implements DemoAPI, LoggerBase {

    @Resource(name = "demoHttpPost")
    HttpStrategy httpStrategy;


    @Override
    public BaseResponse<Map<String,Object>> test(@RequestBody DemoInputDto demoInputDto) {
        BaseResponse result = new BaseResponse();
//        Map execute = execute(demoInputDto);
//        return execute;
//        String chkMsg = checkPostParams(demoInputDto);
//        if (StringUtils.isNotBlank(chkMsg)) {
//            result.setFail();
//            return result;
//        }
//        /**
//         *
//         */
       // Boolean manMade = thirdPartyProperties.getManMade();
       // super.convertBaseDto(demoInputDto);
        Map execute = execute(demoInputDto);
        result.setSuccess(execute);
        return result;


    }

    @Override
    public HttpStrategy httpStrategy() {
        return httpStrategy;
    }


}
