package com.github.zillionchu.zillionchucompanybiz.thirdparty.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @类名称 Test01
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/25 10:59
 * @版本 1.00
 */
public class Test01 {

    private static AtomicInteger count = new AtomicInteger(0);

    // DateTimeFormat
    private static final FastDateFormat DAY_FORMAT = FastDateFormat.getInstance("yyyyMMdd");
    private static final FastDateFormat TIMESTAMP_FORMAT = FastDateFormat.getInstance("hhmmss");


    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//
//            int y = count.incrementAndGet();
//            System.out.println(String.format("%1$017d", y));
//        }

        // System.out.println(String.format("%1$017d",0));
//        System.out.println(DAY_FORMAT.format(new Date()));
//        System.out.println(TIMESTAMP_FORMAT.format(new Date()));

        // System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
        //System.out.println(LocalDateTime.now().format());
        // DateTime dateTime=new DateTime();
        // System.out.println(dateTime.toString("yyyy-MM-dd HH:MM:SS"));

        //   String s = this.getClass().getClassLoader().getResource("01.txt").toString();


        try {
            ClassPathResource classPathResource = new ClassPathResource("01.json");
            File file = classPathResource.getFile();
            FileInputStream inputStream = new FileInputStream(file);
            String s = fileToString(inputStream);

            JSONObject jsonObject = JSON.parseObject(s);
            //  System.out.println(jsonObject.get("cstNm"));

//
//            /***/
//            JSONArray creditCustomerManagerOutDtos = jsonObject.getJSONArray("creditCustomerManagerOutDtos");
//            String s1 = JSONObject.toJSONString(creditCustomerManagerOutDtos);
//            List<CreditCustomerManagerOutDto> creditCustomerManagerOutDtos1 = JSONObject.parseArray(s1,
//                    CreditCustomerManagerOutDto.class);
//            /***/
//            System.out.println("------------" + JSON.toJSONString(creditCustomerManagerOutDtos1));
//
//            /***/
//            JSONArray creditCustomerShareholderOutDtos = jsonObject.getJSONArray("creditCustomerShareholderOutDtos");
//            String s2 = JSONObject.toJSONString(creditCustomerShareholderOutDtos);
//            List<CreditCustomerShareholderOutDto> creditCustomerShareholderOutDtos1 = JSONObject.parseArray(s2,
//                    CreditCustomerShareholderOutDto.class);
//            System.out.println("------------" + JSON.toJSONString(creditCustomerShareholderOutDtos1));
//            /***/

//            Map map = JSON.toJavaObject(jsonObject, Map.class);
//            map.forEach((o, o2) -> System.out.println(o + "---" + o2));

            //  System.out.println("------------" + JSON.toJSONString(map));


            //
            //System.out.println(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));

            String test = "\"CYBERBANKCARINFOOUTDTOS\":[{\"carKyNum\":1,\"engId\":\"21332432e\"," +
                    "\"fncAplyId\":\"RZBH190420000213\",\"frmNo\":\"we1234erdsweq2345\"," +
                    "\"ordrID\":\"HETO190408000003\",\"pdDt\":\"20190929\",\"qlfdId\":\"2019876542\"," +
                    "\"vhclDsc\":\"宝马\",\"vhclModl\":\"宝马\",\"vhclPrc\":40000,\"vhclSt\":\"1\",\"wbtStgId\":\"长久仓库\"," +
                    "\"wbtStgNm\":\"123\"}]".toUpperCase();

//            String s1 = JSONObject.toJSONString(test);
//            System.out.println(s1);
//
//            List<CyberBankCarInfoOutDto> cyberBankCarInfoOutDtos = JSONObject.parseArray(s1, CyberBankCarInfoOutDto
//                    .class);
//
//            System.out.println(cyberBankCarInfoOutDtos);


            String ff="pdkskks".toUpperCase();
            System.out.println(test);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fileToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
    }


}
