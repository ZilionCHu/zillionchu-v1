package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Warrantyinfodto;
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
 * 担保信息接口
 * @date 2019-12-24 14:54:54
 */
@Api(tags = "汽车金融-担保信息接口",description = "担保信息接口主要做融资担保")
public interface WarrantyinfodtoApi {


    /**
     * @param  Warrantyinfodto
     */
    @PostMapping("getWarrantyinfodto")
    @ApiOperation(value = "getWarrantyinfodto",notes = "该方法主要是担保信息接口！",response = Warrantyinfodto.class)
    Map getWarrantyinfodto(@RequestBody Warrantyinfodto paramDto);

}