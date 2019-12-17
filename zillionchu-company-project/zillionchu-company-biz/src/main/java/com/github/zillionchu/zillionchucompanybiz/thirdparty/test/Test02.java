package com.github.zillionchu.zillionchucompanybiz.thirdparty.test;//package com.tansun.thirdparty;
//
//import com.alibaba.fastjson.JSON;
//import com.jeedev.msdp.utlis.internal.exception.UtilException;
//import com.tansun.thirdparty.cyberbank.output.CyberBankCarInfoListsOutDto;
//import com.tansun.thirdparty.cyberbank.output.CyberBankCarInfoOutDto;
//
//import java.beans.IntrospectionException;
//import java.beans.Introspector;
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.Method;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @类名称 Test02
// * @类描述
// * @作者 chuyuefeng@tansun.cn
// * @创建时间 2019/9/29 11:11
// * @版本 1.00
// */
//public class Test02 {
//
//    public static void main(String[] args) {
//        CyberBankCarInfoOutDto cyberBankCarInfoOutDto = new CyberBankCarInfoOutDto();
//        cyberBankCarInfoOutDto.setFncAplyId("RZBH1904200002131");
//        cyberBankCarInfoOutDto.setOrdrID("HETO190408000003");
//        cyberBankCarInfoOutDto.setVhclModl("宝马");
//        cyberBankCarInfoOutDto.setVhclDsc("宝马");
//        cyberBankCarInfoOutDto.setFrmNo("we1234erdsweq2345");
//        cyberBankCarInfoOutDto.setQlfdId("2019876542");
//        cyberBankCarInfoOutDto.setVhclPrc(new BigDecimal(40000));
//        cyberBankCarInfoOutDto.setEngId("21332432e");
//        cyberBankCarInfoOutDto.setCarKyNum(1);
//        cyberBankCarInfoOutDto.setPdDt(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
//        cyberBankCarInfoOutDto.setVhclSt("1");
//        cyberBankCarInfoOutDto.setWbtStgId("长久仓库");
//        cyberBankCarInfoOutDto.setWbtStgNm("123");
//
//
//        CyberBankCarInfoOutDto cyberBankCarInfoOutDto1 = new CyberBankCarInfoOutDto();
//        cyberBankCarInfoOutDto1.setFncAplyId("RZBH190419000171");
//        cyberBankCarInfoOutDto1.setOrdrID("HETO190408000013");
//        cyberBankCarInfoOutDto1.setVhclModl("奔驰");
//        cyberBankCarInfoOutDto1.setVhclDsc("奔驰");
//        cyberBankCarInfoOutDto1.setFrmNo("we1234235rfeq2345");
//        cyberBankCarInfoOutDto1.setQlfdId("2019876543");
//        cyberBankCarInfoOutDto1.setVhclPrc(new BigDecimal(40000));
//        cyberBankCarInfoOutDto1.setEngId("21332432e");
//        cyberBankCarInfoOutDto1.setCarKyNum(1);
//        cyberBankCarInfoOutDto1.setPdDt(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
//        cyberBankCarInfoOutDto1.setVhclSt("1");
//        cyberBankCarInfoOutDto1.setWbtStgId("华阳仓库");
//        cyberBankCarInfoOutDto1.setWbtStgNm("124");
//
//
//        CyberBankCarInfoOutDto cyberBankCarInfoOutDto2 = new CyberBankCarInfoOutDto();
//        cyberBankCarInfoOutDto2.setFncAplyId("RZBH190420000213");
//        cyberBankCarInfoOutDto2.setOrdrID("HETO190408000003");
//        cyberBankCarInfoOutDto2.setVhclModl("宝马");
//        cyberBankCarInfoOutDto2.setVhclDsc("宝马");
//        cyberBankCarInfoOutDto2.setFrmNo("we1234erdsweq2345");
//        cyberBankCarInfoOutDto2.setQlfdId("2019876542");
//        cyberBankCarInfoOutDto2.setVhclPrc(new BigDecimal(40000));
//        cyberBankCarInfoOutDto2.setEngId("21332432e");
//        cyberBankCarInfoOutDto2.setCarKyNum(1);
//        cyberBankCarInfoOutDto2.setPdDt(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
//        cyberBankCarInfoOutDto2.setVhclSt("1");
//        cyberBankCarInfoOutDto2.setWbtStgId("宝马仓库");
//        cyberBankCarInfoOutDto2.setWbtStgNm("125");
//
////        List<CyberBankCarInfoOutDto> cyberBankCarInfoOutDtos = Arrays.asList(cyberBankCarInfoOutDto,
////                cyberBankCarInfoOutDto1, cyberBankCarInfoOutDto2);
//        List<CyberBankCarInfoOutDto> listc = new ArrayList<>();
//        listc.add(cyberBankCarInfoOutDto2);
//        listc.add(cyberBankCarInfoOutDto1);
//        listc.add(cyberBankCarInfoOutDto);
//
//
////        Map<String, CyberBankCarInfoOutDto> collect = listc.stream().collect(Collectors.toMap
////                (CyberBankCarInfoOutDto::getFncAplyId, c -> c, (k1, k2) -> k1));
//
//
//        //List<CyberBankCarInfoOutDto> cyberBankCarInfoOutDtos = Arrays.asList(cyberBankCarInfoOutDto);
//
//        CyberBankCarInfoListsOutDto cyberBankCarInfoListsOutDto = new CyberBankCarInfoListsOutDto();
////
//        cyberBankCarInfoListsOutDto.setCyberBankCarInfoOutDtos(listc);
//        cyberBankCarInfoListsOutDto.setChnlNo("30");
//        cyberBankCarInfoListsOutDto.setTradeflag("0");
//
//        cyberBankCarInfoListsOutDto.setDestInst("99710670000");
//        cyberBankCarInfoListsOutDto.setMac("");
//
//        cyberBankCarInfoListsOutDto.setRespCode("000000");
//        cyberBankCarInfoListsOutDto.setRespInfo("交易成功");
////
////        List<CyberBankCarInfoOutDto> cyberBankCarInfoOutDtos1 = cyberBankCarInfoListsOutDto
////                .getCyberBankCarInfoOutDtos();
////
////
////        cyberBankCarInfoOutDtos1
////       collect.forEach((s, cyberBankCarInfoOutDto3) -> {
////           System.out.println(s);
////           System.out.println(beanToMap(cyberBankCarInfoOutDto3, true));
////       });
//
//        String s = JSON.toJSONString(beanToMap(cyberBankCarInfoListsOutDto, true));
////
//        System.out.println(s);
//
////
////        JSONObject jsonObject = JSON.parseObject(s);
////
////        JSONArray creditCustomerManagerOutDtos = jsonObject.getJSONArray("CYBERBANKCARINFOOUTDTOS");
////        String s1 = JSONObject.toJSONString(creditCustomerManagerOutDtos);
////        List<CyberBankCarInfoOutDto> CyberBankCarInfoOutDtoss = JSONObject.parseArray(s,
////                CyberBankCarInfoOutDto.class);
////
////        CyberBankCarInfoOutDtoss.forEach(cyberBankCarInfoOutDto3 -> {
////            //System.out.println(cyberBankCarInfoOutDto3);
////            System.out.println(beanToMap(cyberBankCarInfoOutDto3, true));
////        });
//
//
//        // System.out.println(CyberBankCarInfoOutDtoss);
//
//    }
//
//    public static <T> Map<String, Object> beanToMap(T bean, boolean ignoreNullValue) {
//        if (bean == null) {
//            return null;
//        } else {
//            HashMap map = new HashMap();
//
//            try {
//                PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(bean.getClass());
//                PropertyDescriptor[] var5 = propertyDescriptors;
//                int var6 = propertyDescriptors.length;
//                for (int var7 = 0; var7 < var6; ++var7) {
//                    PropertyDescriptor property = var5[var7];
//                    Class<?> propertyType = property.getPropertyType();
//                    String key = property.getName();
//                    if (!key.equals("class") && !key.equals("declaringClass")) {
//                        Method getter = property.getReadMethod();
//                        Object value = getter.invoke(bean, new Object[0]);
//                        if (!ignoreNullValue || null != value && !value.equals(bean)) {
//                            if (property.getPropertyType() == List.class) {
//                                //value
//                                //
////                                List<CyberBankCarInfoOutDto> list1 = (List<CyberBankCarInfoOutDto>) value;
////                                Map<CyberBankCarInfoOutDto, Integer> collect = list1.stream().collect(Collectors
////                                        .toMap(v -> v, v -> 1));
////                                map.put(key, collect);
//                            }
//                            map.put(key.toUpperCase(), value);
//                        }
//                    }
//                }
//
//                return map;
//            } catch (Exception var12) {
//                throw new UtilException(var12);
//            }
//        }
//    }
//
//    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) throws IntrospectionException {
//        return Introspector.getBeanInfo(clazz).getPropertyDescriptors();
//    }
//}
