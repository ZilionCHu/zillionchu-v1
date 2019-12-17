package com.github.zillionchu.zillionchucompanybiz.thirdparty.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.cyberbank.output.CyberBankRedemptionAwaitListsOutDto;
import org.springframework.core.io.ClassPathResource;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @类名称 Test06
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/8 15:35
 * @版本 1.00
 */
public class Test06 {
    public static void main(String[] args) {
        try {
            ClassPathResource classPathResource = new ClassPathResource("01.json");
            File file = null;
            file = classPathResource.getFile();
            FileInputStream inputStream = new FileInputStream(file);
            String s = fileToString(inputStream);
            //  System.out.println(s);
          /*  JSONObject jsonObject = JSON.parseObject(s);

            JSONArray cyberBankCarInfoOutDtos = jsonObject.getJSONArray("data");
            String s1 = JSONObject.toJSONString(cyberBankCarInfoOutDtos);
            List<CyberBankCarInfoOutDto> cyberBankCarInfoOutDtoss = JSONObject.parseArray(s1,
                    CyberBankCarInfoOutDto.class);


            //Map<String, Object> map = Maps.newHashMap();
            List<Map<String, Object>> listParams = Lists.newArrayList();


            cyberBankCarInfoOutDtoss.forEach(CyberBankCarInfoOutDto -> {
                Map<String, Object> stringObjectMap = beanToMap(CyberBankCarInfoOutDto, true);
                listParams.add(stringObjectMap);
            });

*/
          //  System.out.println(s);

//            JSONObject jsonObject = JSON.parseObject(s);
//            String sss = (String) jsonObject.get("regEntNm");
//            System.out.println(sss);
//            JSONObject pageInfo = jsonObject.getJSONObject("pageInfo");
//
//            PageInfo pageInfo1 = JSON.toJavaObject(pageInfo, PageInfo.class);
//            System.out.println(pageInfo1.getTotal());


//            List<CyberBankTakeGoodsOutDto> reptCstList = jSONArrayConver(s, CyberBankTakeGoodsOutDto.class,
//                    "reptCstList");
//
//            reptCstList.forEach(cyberBankTakeGoodsOutDto -> {
//                System.out.println(cyberBankTakeGoodsOutDto.getPckUpGdsRspbPsnNm());
//                System.out.println(cyberBankTakeGoodsOutDto.getPckUpGdsRspbPsnCtcMod());
//            });

//            JSONObject jsonObject = JSON.parseObject(s);
//            JSONArray jsonArray = jsonObject.getJSONArray("data");
//            String s1 = JSONObject.toJSONString(jsonArray);
            //   maps.stream().flatMap(stringObjectMap -> stringObjectMap.get());
            //  System.out.println("11111" + maps);


            List<CyberBankRedemptionAwaitListsOutDto> reptFncList = jSONArrayConver(s,
                    CyberBankRedemptionAwaitListsOutDto
                            .class, "list");

            reptFncList.forEach(e -> {
                System.out.println(e.getCanRdpAmt());
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static <T> List<T> jSONArrayConver(String jsonString, Class<T> t, String jsonkey) {

        JSONObject jsonObject = JSON.parseObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray(jsonkey);
        String s1 = JSONObject.toJSONString(jsonArray);
        List<T> objectss = JSONObject.parseArray(s1,
                t);
//        List<Map<String, Object>> listParams = Lists.newArrayList();
//        objectss.forEach(CyberBankCarInfoOutDto -> {
//            Map<String, Object> stringObjectMap = beanToMap(CyberBankCarInfoOutDto, true);
//            listParams.add(stringObjectMap);
//        });

        //return listParams;


        return objectss;

    }

    public static String fileToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
    }

    public static <T> Map<String, Object> beanToMap(T bean, boolean ignoreNullValue) {
        if (bean == null) {
            return null;
        } else {
            HashMap map = new HashMap();

            try {
                PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(bean.getClass());
                PropertyDescriptor[] var5 = propertyDescriptors;
                int var6 = propertyDescriptors.length;

                for (int var7 = 0; var7 < var6; ++var7) {
                    PropertyDescriptor property = var5[var7];
                    String key = property.getName();
                    if (!key.equals("class") && !key.equals("declaringClass")) {
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(bean, new Object[0]);
                        if (!ignoreNullValue || null != value && !value.equals(bean)) {
                            map.put(key.toUpperCase(), value);
                        }
                    }
                }

                return map;
            } catch (Exception var12) {
                // throw new Exception(var12);
            }
        }
        return null;
    }

    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) throws IntrospectionException {
        return Introspector.getBeanInfo(clazz).getPropertyDescriptors();
    }
}
