package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.base;

import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CreditRequestBaseDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.CommonSeqNoFeign;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.builder.BizDirector;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.handler.base.ExecuteClient;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.two.common.strategy.HttpStrategy;
import com.github.zillionchu.zillionchucompanycore.thirdparty.config.ThirdPartyProperties;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/17 11:03
 * @Description:
 */
public abstract class BaseBiz<T, R extends Object> {


    private static final FastDateFormat DAY_FORMAT = FastDateFormat.getInstance("yyyyMMdd");
    private static final FastDateFormat TIMESTAMP_FORMAT = FastDateFormat.getInstance("hhmmss");

    @Autowired
    private ExecuteClient executeClient;


    @Autowired
    private BizDirector<T> bizDirector;

    @Autowired
    protected ThirdPartyProperties thirdPartyProperties;

    @Autowired
    private CommonSeqNoFeign commonSeqNoFeign;


    /**
     * Biz exe
     */
    public R execute(T t) {

        /**
         * 0、限流（熔断）
         *
         * 1、接口幂等性验证
         *
         * 1.5 接口验证签名
         *
         * 2、黑名单白名单（1、接口准入权限 , XSS）
         *
         * 3、参数验证（1.url解析和参数合法性验证 ;
         *            2.扩展加解密方案 非对称RSA和对称DES）
         *
         * 4、参数过滤转换（后台map参数）
         *
         * 5、调用后台接口（策略）
         *
         * 备注：整合与扩展
         *      1、Hystrix 熔断 隔离 降级
         *      2、Sleuth  zipkin
         *      3、redis  RabbitMQ  springboot整合swggerDoc
         *      4、API管理平台
         *
         */

        bizDirector.direcot(t);

        executeClient.executeClient();

        R r = postRequest(t);

        return r;

    }

    public R postRequest(T t) {
        //String s = httpImplIoc();
        //HttpStrategy httpStrategy = HttpStrategyFactory.getHttpStrategy(s);
        HttpStrategy httpStrategy = httpStrategy();
        Object o = httpStrategy.httpRequest(t);
        return (R) o;
    }


    /**
     * 组织请求公共报文
     *
     * @param creditRequestBaseDto
     */
    public void convertBaseDto(CreditRequestBaseDto creditRequestBaseDto) {
        String seqNo = commonSeqNoFeign.buildSerialNum("scf_10045", "");
        creditRequestBaseDto.setChnlNo("30");
        creditRequestBaseDto.setTradeflag("0");
        creditRequestBaseDto.setSeqNo(seqNo);
        creditRequestBaseDto.setLocalTime(TIMESTAMP_FORMAT.format(new Date()));
        creditRequestBaseDto.setLocalDate(DAY_FORMAT.format(new Date()));
        creditRequestBaseDto.setClearDate(DAY_FORMAT.format(new Date()));
        creditRequestBaseDto.setTransInst("99710670000");
        creditRequestBaseDto.setSendInst("99710670000");
        creditRequestBaseDto.setSysTrackNo("99710670000" + DAY_FORMAT.format(new Date()) + seqNo);
        creditRequestBaseDto.setDestInst("99460000000");
        creditRequestBaseDto.setMac("");
    }

    /**
     * check param dto @NotNull ||  @Max
     *
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


    public abstract HttpStrategy httpStrategy();


}
