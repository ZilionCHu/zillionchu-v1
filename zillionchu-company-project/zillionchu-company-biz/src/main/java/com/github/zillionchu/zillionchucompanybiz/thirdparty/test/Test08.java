package com.github.zillionchu.zillionchucompanybiz.thirdparty.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditCustomerOutInfoDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditCustomerShareholderOutDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @类名称 Test08
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/21 16:13
 * @版本 1.00
 */
public class Test08 implements LoggerBase {

    public static void main(String[] args) {
        try {
            ClassPathResource classPathResource = new ClassPathResource("01.json");
            File file = null;
            file = classPathResource.getFile();
            FileInputStream inputStream = new FileInputStream(file);
            String s = fileToString(inputStream);
            ///System.out.println("##########1 : " + s);
            JSONObject jsonObject = JSON.parseObject(s);
            // JSONObject data = jsonObject.getJSONObject("data");
            //String dataString = data.toJSONString();
            String dataString = jsonObject.toJSONString();
            List<CreditCustomerShareholderOutDto> creditCustomerManagerOutDtos = listsConvertToBean(dataString,
                    CreditCustomerShareholderOutDto.class, "creditCustomerShareholderOutDtos");

            creditCustomerManagerOutDtos.forEach(c -> {
                System.out.println(c.getShrhNm());
            });

            CreditCustomerOutInfoDto creditCustomerOutInfoDto = JSON.toJavaObject(jsonObject,
                    CreditCustomerOutInfoDto.class);

            System.out.println(JSON.toJSONString(creditCustomerOutInfoDto));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static <T> List<T> listsConvertToBean(String var3, Class<T> t, String var4) {
        JSONObject jsonObject = JSON.parseObject(var3);
        JSONArray jsonArray = jsonObject.getJSONArray(var4);
        String var1 = JSONObject.toJSONString(jsonArray);
        List<T> var2 = JSONObject.parseArray(var1,
                t);
        return var2;

    }


    public static String fileToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
