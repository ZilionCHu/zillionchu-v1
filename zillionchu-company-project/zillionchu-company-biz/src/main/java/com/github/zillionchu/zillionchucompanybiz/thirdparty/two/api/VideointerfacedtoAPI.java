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
 * @date 2019-12-24 10:50:29
 */
@Api(tags = "汽车金融-影像重发接口",description = "影像重发接口主要功能支持相关附件重新发送")
public interface VideointerfacedtoAPI {


    /**
     * @param  Videointerfacedto
     */
    @PostMapping("getVideointerfacedto")
    @ApiOperation(value = "getVideointerfacedto",notes = "该方法主要是影像重发接口管理indexPost接口！",response = Videointerfacedto.class)
    Map getVideointerfacedto(@RequestBody Videointerfacedto paramDto);

}