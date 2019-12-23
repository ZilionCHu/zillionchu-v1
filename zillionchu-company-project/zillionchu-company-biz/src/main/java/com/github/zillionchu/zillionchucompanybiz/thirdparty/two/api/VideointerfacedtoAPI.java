package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Videointerfacedto;
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
 * @date 2019-12-23 17:28:53
 */
@Api(tags = "getVideointerfacedto")
public interface VideointerfacedtoAPI {


    /**
     * @param  Videointerfacedto
     */
    @PostMapping("/getVideointerfacedto")
    @ApiOperation(value = "getVideointerfacedto")
    Map getVideointerfacedto(@RequestBody Videointerfacedto paramDto);

}