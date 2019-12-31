package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.api;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity.Hycmdtyvrtyclassdto;
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
 * @date 2019-12-24 17:41:03
 */
@Api(tags = "汽车金融-货押商品品种查询接口",description = "货押商品品种查询接口主要查询货物抵押商品种类")
public interface HycmdtyvrtyclassdtoApi {


    /**
     * @param  Hycmdtyvrtyclassdto
     */
    @PostMapping("getHycmdtyvrtyclassdto")
    @ApiOperation(value = "getHycmdtyvrtyclassdto",notes = "该方法主要是货押商品品种查询接口管理indexPost接口！",response = Hycmdtyvrtyclassdto.class)
    Map getHycmdtyvrtyclassdto(@RequestBody Hycmdtyvrtyclassdto paramDto);

}