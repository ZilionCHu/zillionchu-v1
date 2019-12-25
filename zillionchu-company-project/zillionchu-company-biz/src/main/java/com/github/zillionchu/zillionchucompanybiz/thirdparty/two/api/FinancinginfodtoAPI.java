package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Financinginfodto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * 
 *
 * @author Mr.AG
 * @email 463540703@qq.com
 * @date 2019-12-24 16:08:00
 */
@Api(tags = "汽车金融-融资信息接口",description = "融资信息接口主要对融资要术进行描述")
public interface FinancinginfodtoAPI {


    /**
     * @param  Financinginfodto
     */
    @PostMapping("getFinancinginfodto")
    @ApiOperation(value = "getFinancinginfodto",notes = "该方法主要是Financinginfodto管理indexPost接口！",response = Financinginfodto.class)
    Map getFinancinginfodto(@RequestBody Financinginfodto paramDto);

}