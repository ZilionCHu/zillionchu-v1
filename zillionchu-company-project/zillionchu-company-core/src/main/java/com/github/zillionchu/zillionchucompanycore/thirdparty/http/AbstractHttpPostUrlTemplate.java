package com.github.zillionchu.zillionchucompanycore.thirdparty.http;

import com.alibaba.fastjson.JSONObject;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CreditRequestBaseDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.github.zillionchu.zillionchucompanycore.thirdparty.config.ThirdPartyProperties;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @类名称 AbstractHttpPostUrlTemplate
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/18 17:10
 * @版本 1.00
 */
@Component
public abstract class AbstractHttpPostUrlTemplate implements LoggerBase {

    private static final FastDateFormat DAY_FORMAT = FastDateFormat.getInstance("yyyyMMdd");
    private static final FastDateFormat TIMESTAMP_FORMAT = FastDateFormat.getInstance("hhmmss");

    protected static final String[] commonParms = new String[]{"chnlNo", "tradeflag", "seqNo", "localTime",
            "localDate", "clearDate", "transInst", "sendInst", "sysTrackNo", "destInst", "mac", "respInfo", "respCode"};

    private static final String URLV_PREVIEW = "preview";

    private static final String URLV_FIXED = "fixed";

    private static final String URLV_PROENV = "proEnv";

    @Value("${thirdparty.config.url.credit.prex.dev-fixed}")
    private String devFixed;  //定版

    @Value("${thirdparty.config.url.credit.prex.dev-preview}")
    private String devPreview;   //预演 pro-env

    //生产
    @Value("${thirdparty.config.url.credit.prex.pro-env}")
    private String proEnv;

    @Value("${thirdparty.config.url-v}")
    private String urlv;  //环境切换变量

    @Autowired
    protected ThirdPartyProperties thirdPartyProperties;





    private static AtomicInteger count = new AtomicInteger(0);


    /**
     * 统一请求业务处理
     *
     * @param obj
     */
    protected JSONObject httpClientPost(Object obj) {
        info("################################--Start  post url--######################");
        String postUrl = null;
        if (urlv.equals(URLV_FIXED)) {
            postUrl = devFixed + httpPostUrl();
        } else if(urlv.equals(URLV_PREVIEW)){
            postUrl = devPreview + httpPostUrl();
        } else if(urlv.equals(URLV_PROENV)){
            postUrl = proEnv + httpPostUrl();
        }else{
            postUrl = devPreview + httpPostUrl();
        }
        info("http    post  Request  url-version  is :{}", urlv);
        info("http    post  Request  postUrl   is :{}", postUrl);

        JSONObject jsonObject = new JSONObject();
        String sJson = jsonObject.toJSONString(obj);
        JSONObject jsonObjectParam = JSONObject.parseObject(sJson);
        JSONObject repJSon = HttpClientUtils.httpPost(postUrl, jsonObjectParam);
        String reposeDToString = repJSon.toJSONString();

        info("http    post  Respose  dto   is :{}", reposeDToString);
        info("################################--End  post url--######################");
        return repJSon;
    }


    /**
     * 组织请求公共报文
     *
     * @param creditRequestBaseDto
     */
    public void convertBaseDto(CreditRequestBaseDto creditRequestBaseDto, String sqlNo) {
        int seq = count.incrementAndGet();
        creditRequestBaseDto.setChnlNo("30");
        creditRequestBaseDto.setTradeflag("0");
        creditRequestBaseDto.setSeqNo(sqlNo);
        creditRequestBaseDto.setLocalTime(TIMESTAMP_FORMAT.format(new Date()));
        creditRequestBaseDto.setLocalDate(DAY_FORMAT.format(new Date()));
        creditRequestBaseDto.setClearDate(DAY_FORMAT.format(new Date()));
        creditRequestBaseDto.setTransInst("99710670000");
        creditRequestBaseDto.setSendInst("99710670000");
        creditRequestBaseDto.setSysTrackNo("99710670000" + DAY_FORMAT.format(new Date()) + sqlNo);
        creditRequestBaseDto.setDestInst("99460000000");
        creditRequestBaseDto.setMac("");
    }


    /**
     * 剔除公共报文
     *
     * @param map
     * @return
     */
    protected Map<String, Object> convertParam(Map<String, Object> map) {
        HashMap<String, Object> reMap = Maps.newHashMap();
        map.forEach((k, v) -> {
            boolean var1 = Arrays.stream(commonParms).anyMatch(ele -> ele.equals(k));
            if (!var1) {
                reMap.put(k, v);
            }
        });
        return reMap;
    }


    /**
     * 报文转换Map
     *
     * @param bean
     * @param ignoreNullValue
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> Map<String, Object> beanToMap(T bean, boolean ignoreNullValue) throws Exception {
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
                            map.put(key, value);
                        }
                    }
                }

                return map;
            } catch (Exception var12) {
                throw new Exception(var12);
            }
        }
    }

    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) throws IntrospectionException {
        return Introspector.getBeanInfo(clazz).getPropertyDescriptors();
    }

    /**
     * @param obj
     * @return
     */
    public String checkPostParams(Object obj) {
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


    public abstract String httpPostUrl();
}
