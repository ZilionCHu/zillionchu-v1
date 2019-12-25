package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Cargomortgagedto;
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
 * @date 2019-12-24 17:14:12
 */
@Api(tags = "汽车金融-货押商品目录查询接口",description = "货押商品目录查询接口主要查询公贷系统货押商品目录")
public interface CargomortgagedtoAPI {


    /**
     * @param  Cargomortgagedto
     */
    @PostMapping("getCargomortgagedto")
    @ApiOperation(value = "getCargomortgagedto",notes = "货押商品目录查询接口主要查询公贷系统货押商品目录！",response = Cargomortgagedto.class)
    Map getCargomortgagedto(@RequestBody Cargomortgagedto paramDto);

}