package com.github.zillionchu.zillionchucompanybiz.thirdparty.feign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankRequestBaseDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankResponseBaseDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.RequestDtoHandler;
import com.github.zillionchu.zillionchucompanycore.thirdparty.enums.ThirdPartyStatusEnum;
import com.github.zillionchu.zillionchucompanycore.thirdparty.exception.ThirdPartyException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @类名称 AbstractFeign
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/2 19:58
 * @版本 1.00
 */
@Component
public abstract class AbstractFeign implements LoggerBase {


    //赎货
    @Autowired(required = true)
    protected CyberBankRedemptionFeign cyberBankRedemptionFeign;

    //业务方案
    @Autowired(required = true)
    protected CyberBankBusinessPlanFeign cyberBankBusinessPlanFeign;

    //车辆
    @Autowired(required = true)
    protected CyberBankQueryCarInfoFeign cyberBankQueryCarInfoFeign;

    @Autowired
    protected RequestDtoHandler requestDtoHandler;


    private static final FastDateFormat DAY_FORMAT = FastDateFormat.getInstance("yyyyMMdd");
    private static final FastDateFormat TIMESTAMP_FORMAT = FastDateFormat.getInstance("hhmmss");
    private static AtomicInteger count = new AtomicInteger(0);


    /**
     * 转换内部返回List类型报文
     *
     * @param var3
     * @param t
     * @param var4 JsonAarry  key
     * @param <T>
     * @return
     */
    public static <T> List<T> listsConvertToBean(String var3, Class<T> t, String var4) {
        JSONObject jsonObject = JSON.parseObject(var3);
        JSONArray jsonArray = jsonObject.getJSONArray(var4);
        String var1 = JSONObject.toJSONString(jsonArray);
        List<T> var2 = JSONObject.parseArray(var1,
                t);
        return var2;

    }


    /**
     * @param jsonString
     * @param t
     * @param jsonkey
     * @param <T>
     * @param <T>
     * @param <T>
     * @return
     */
    public <T> List<Map<String, Object>> jSONArrayConver(String jsonString, Class t, String jsonkey) {
        JSONObject jsonObject = JSON.parseObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray(jsonkey);
        String s1 = JSONObject.toJSONString(jsonArray);
        List<T> objectss = JSONObject.parseArray(s1,
                t);
        List<Map<String, Object>> listParams = Lists.newArrayList();
        objectss.forEach(CyberBankCarInfoOutDto -> {
            Map<String, Object> stringObjectMap = null;
            try {
                stringObjectMap = beanToMap(CyberBankCarInfoOutDto, true, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            listParams.add(stringObjectMap);
        });

        return listParams;
    }


    /**
     * 组织返回公共报文
     *
     * @param
     */
    public void convertBaseDto(CyBankRequestBaseDto cyBankRequestBaseDto, CyBankResponseBaseDto cyBankResponseBaseDto) {
        cyBankResponseBaseDto.setChnlNO(cyBankRequestBaseDto.getChnlNO());
        cyBankResponseBaseDto.setTradeflag(cyBankRequestBaseDto.getTradeflag());
        cyBankResponseBaseDto.setSeqNo(cyBankRequestBaseDto.getSeqNo());
        cyBankResponseBaseDto.setLocalTime(cyBankRequestBaseDto.getLocalTime());
        cyBankResponseBaseDto.setLocalDate(cyBankRequestBaseDto.getLocalDate());
        cyBankResponseBaseDto.setClearDate(cyBankRequestBaseDto.getClearDate());
        cyBankResponseBaseDto.setTransInst(cyBankRequestBaseDto.getTransInst());
        cyBankResponseBaseDto.setSendInst(cyBankRequestBaseDto.getSendInst());
        cyBankResponseBaseDto.setSysTrackNo(cyBankRequestBaseDto.getSysTrackNo());
        cyBankResponseBaseDto.setDestInst(cyBankRequestBaseDto.getDestInst());
        cyBankResponseBaseDto.setMac(cyBankRequestBaseDto.getMac());
        // BeanUtils.copyProperties(cyBankRequestBaseDto, cyBankRequestBaseDto);
        cyBankResponseBaseDto.setRespCode(ThirdPartyStatusEnum.T_PARTY_SUCCESS.getCode());
        cyBankResponseBaseDto.setRespInfo(ThirdPartyStatusEnum.T_PARTY_SUCCESS.getName());
    }


    /**
     * @param type
     * @param dto
     * @return
     * @throws Exception
     */
    public Object redemptionPosts(CyberBankEnum type, Object dto) throws Exception {
        info("[   内部服务   ]-------------------------------------");
        info("[ Sever Method ]--------------" + type.toString());
        info("[ Carfinance   ]---######################--start--#########################");
        CyBankRequestBaseDto cyBankRequestBaseDto = (CyBankRequestBaseDto) dto;
        String seqno = cyBankRequestBaseDto.getSeqNo();
        CyBankRequestBaseDto thredLocalBaseDtoBefore = requestDtoHandler.get();
        info("thredLocalBaseDtoBefore  is = {}", JSONObject.toJSONString(thredLocalBaseDtoBefore));
        requestDtoHandler.set(cyBankRequestBaseDto);
        CyBankRequestBaseDto thredLocalBaseDto = requestDtoHandler.get();
        info("thredLocalBaseDtoAfter  is = {}", JSONObject.toJSONString(thredLocalBaseDto));
        info("redemptionPosts  request  seqno = {}", seqno);
        info("请求流水号={}", seqno);
        info("redemptionPosts  request   dto = {}", JSONObject.toJSONString
                (dto));
        String checkParams = checkParams(dto);
        info("parms  checkParams  is = {} ", checkParams);
        if (StringUtils.isNotEmpty(checkParams)) {
            throw new ThirdPartyException(checkParams);
        }
        Map<String, Object> prams = beanToMap(dto, true, false);
        info("dao  prams  is = {}", JSON.toJSONString(prams));
        info("转换后台查询参数={}", JSON.toJSONString(prams));
        switch (type) {
            case REDEMPTION_APPLYLISTS:
                PageInfo<Map<String, Object>> var1 = cyberBankRedemptionFeign.findReptListIntf(prams);
                redemptionPostsEnd(var1);
                return var1;
            case REDEMPTION_TAKEGOODS:
                PageInfo<Map<String, Object>> var2 = cyberBankRedemptionFeign.findReptCstIntf(prams);
                redemptionPostsEnd(var2);
                return var2;
            case REDEMPTION_REVOKEAPPLY:
                Map<String, Object> var3 = cyberBankRedemptionFeign.saveOrUpdateBackBizReptInfoTrans(prams);
                // Map<String, Object> convertRevokeParams = convertAParams(var3);
                redemptionPostsEnd(var3);
                return var3;
            case REDEMPTION_AWAITLISTS:
                PageInfo<Map<String, Object>> var4 = cyberBankRedemptionFeign.findReptFncIntf(prams);
                redemptionPostsEnd(var4);
                return var4;
            case REDEMPTION_APPLYINFO:
                Map<String, Object> var5 = cyberBankRedemptionFeign.viewReptListIntf(prams);
                redemptionPostsEnd(var5);
                return var5;
            case REDEMPTION_SUBAPPLY:
                Map<String, Object> var6 = cyberBankRedemptionFeign.saveReptListIntf(prams);
                redemptionPostsEnd(var6);
                return var6;
            case BUSINESSPLAN:
                PageInfo<Map<String, Object>> var7 = cyberBankBusinessPlanFeign
                        .findBizPreCtrBscInfListByParams(prams);
                redemptionPostsEnd(var7);
                return var7;
            case QUERYCARINFO:
                PageInfo<Map<String, Object>> var8 = cyberBankQueryCarInfoFeign.findCarIvntInfPageInfo
                        (prams);
                redemptionPostsEnd(var8);
                return var8;
            default:
                break;

        }
        return null;
    }

    public void redemptionPostsEnd(Object obj) {
        info("redemptionPosts http  reponse  dto = {}", JSONObject.toJSONString
                (obj));
        info("返回查询后台报文= {}", JSONObject.toJSONString
                (obj));
        info("[ Carfinance   ]---######################--end--#########################");
    }


    /**
     * 转换大写参数
     *
     * @param <T>
     * @param t
     */
    public <T> Map<String, Object> convertAParams(T t) {

        if (t instanceof Map) {
            HashMap<String, Object> newParam = Maps.newHashMap();
            ((Map) t).forEach((k, v) -> {
                newParam.put(v.toString().toUpperCase(), v);
            });
            return newParam;
        }

        return null;
    }


    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) throws IntrospectionException {
        return Introspector.getBeanInfo(clazz).getPropertyDescriptors();
    }


    protected enum CyberBankEnum {
        REDEMPTION_APPLYLISTS, //赎货申请列表
        REDEMPTION_APPLYINFO, //赎货申请详情
        REDEMPTION_AWAITLISTS, //待提货融资列表
        REDEMPTION_SUBAPPLY, //提交赎货申请
        REDEMPTION_REVOKEAPPLY, //撤销赎货
        REDEMPTION_TAKEGOODS, //提货人列表

        BUSINESSPLAN, //业务方案
        QUERYCARINFO; // 车辆列表
    }


    public static String fileToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
    }

    public static <T> Map<String, Object> beanToMap(T bean, boolean ignoreNullValue, boolean flag) throws Exception {
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
                            if (flag) {
                                map.put(key.toUpperCase(), value);
                            } else {
                                String var3 = value.toString().trim();
                                if (StringUtils.isNotBlank(var3)) {
                                    map.put(key, var3);
                                }

                            }

                        }
                    }
                }

                return map;
            } catch (Exception var12) {
                throw new Exception(var12);
                //var12.printStackTrace();
            }
        }
        //  return null;
    }

    /**
     * @param obj
     * @return
     */
    public String checkParams(Object obj) {
        Field[] fs = obj.getClass().getDeclaredFields();
        StringBuffer returnMsg = new StringBuffer();
        String substring = null;
        for (Field f : fs) {
            if (f.isAnnotationPresent(NotNull.class)) {
                NotNull not = f.getAnnotation(NotNull.class);
                String fn = f.getName();
                String fv = getFieldValueByFieldName(fn, obj);
                if (validateNotNull(fv)) {
                    returnMsg.append(not.message() + "，");
                }
            }
            if (f.isAnnotationPresent(Max.class)) {
                Max max = f.getAnnotation(Max.class);
                String fn = f.getName();
                String fv = getFieldValueByFieldName(fn, obj);
                boolean maxLength = validateMax(fv, max.value());
                if (maxLength) {
                    returnMsg.append(max.message() + "，");
                }

            }

        }
        String rtnMsgString = returnMsg.toString();
        if (StringUtils.isNotBlank(rtnMsgString)) {
            substring = rtnMsgString.substring(0, rtnMsgString.lastIndexOf("，"));
        }
        return substring;

    }


    private boolean validateMax(String str, Long size) {
       // return str.length() * 3 > size ? true : false;
        return str.length() > size ? true : false;
    }

    private boolean validateNotNull(String str) {
        if (str == null || str.equals("") || str.equals("null") || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    private String getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return String.valueOf(field.get(object));
        } catch (Exception e) {
            return null;
        }
    }


}





