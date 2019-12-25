package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Entrstdpybacdto;
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
 * @date 2019-12-24 18:46:35
 */
@Api(tags = "汽车金融-受托支付接口",description = "受托支付接口主要委托支付功能")
public interface EntrstdpybacdtoAPI {


    /**
     * @param  Entrstdpybacdto
     */
    @PostMapping("getEntrstdpybacdto")
    @ApiOperation(value = "getEntrstdpybacdto",notes = "受托支付接口！",response = Entrstdpybacdto.class)
    Map getEntrstdpybacdto(@RequestBody Entrstdpybacdto paramDto);

}