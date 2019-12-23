/*
package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/23 10:40
 * @Description:
 *//*


@Configuration
@Primary
public class ApiDocConfig implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
        return resources();
    }

    private List<SwaggerResource> resources() {
        // JSONArray docJsonArray = JSONArray.parseArray("ZilionChu");
        List resources = new ArrayList<>();
        // 遍历集合数组
//        for (Object object : docJsonArray) {
//            JSONObject jsonObject = (JSONObject) object;
//            String name = jsonObject.getString("name");
//            String location = jsonObject.getString("location");
//            String version = jsonObject.getString("version");
//            resources.add(swaggerResource(name, location, version));
//        }
        resources().add(swaggerResource("test", "test", "test"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
*/
