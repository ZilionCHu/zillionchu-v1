package com.github.zillionchu.zillionchucompanybiz.thirdparty.credit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.credit.CreditQueryCarInfoApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.input.dto.CreditCarInfoInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditCarInfoListsOutDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditCarInfoOutDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.CommonSeqNoFeign;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.github.zillionchu.zillionchucompanycore.thirdparty.enums.ThirdPartyStatusEnum;
import com.github.zillionchu.zillionchucompanycore.thirdparty.http.AbstractHttpPostUrlTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @类名称 CreditQueryCarInfoApiBiz
 * @类描述 融资车辆
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/12 20:22
 * @版本 1.00
 */

@RestController
public class CreditQueryCarInfoApiBiz extends AbstractHttpPostUrlTemplate implements CreditQueryCarInfoApi, LoggerBase {

    @Value("${thirdparty.config.url.credit.sufx.credit-carinfo}")
    private String sufxURL;

    @Autowired
    private CommonSeqNoFeign commonSeqNoFeign;

    /**
     * 查询融资车辆
     *
     * @param creditCarInfoInpDto
     * @return
     */
    @Override
    public BaseResponse<Map<String, Object>> getCreditCarInfo(@RequestBody CreditCarInfoInpDto creditCarInfoInpDto) {
        info("http    post  Request  dto   is :{}", JSONObject.toJSONString(creditCarInfoInpDto));
        BaseResponse baseResponse = new BaseResponse();
        String chkMsg = checkPostParams(creditCarInfoInpDto);
        info("http    post  Request  checkDto  is :{}", chkMsg);
        //校验必输选项
        if (StringUtils.isNotBlank(chkMsg)) {
            baseResponse.setFail();
            return baseResponse;
        }
        Boolean manMade = thirdPartyProperties.getManMade();
        info("------------------------------获取车辆信息------------------------");
        info("thirdparty  config  manMade is :  {}", manMade);
        info("thirdparty  config   creditCarInfoInpDto is :  {}", creditCarInfoInpDto
                .toString());
        if (manMade && creditCarInfoInpDto.getFlag()) {
            return getCreditCarInfoDB();
        }
        //公共报文
        String seqNo = commonSeqNoFeign.buildSerialNum("scf_10045", "");
        super.convertBaseDto(creditCarInfoInpDto, seqNo);
        JSONObject jsonObject = httpClientPost(creditCarInfoInpDto);
        String sJson = jsonObject.toJSONString(jsonObject.get("creditCarInfoOutDtos"));


        if (jsonObject == null) {
            baseResponse.setFail();
            return baseResponse;
        }
        if ("null".equals(sJson)){
            String respMsg = (String) jsonObject.get("respInfo");
            baseResponse.setFail();
            if (StringUtils.isNotBlank(respMsg)) {
                baseResponse.setRespInfo("交易失败:查询业务方案为空");
                return baseResponse;
            }
        }

        Map map = JSON.toJavaObject(jsonObject, Map.class);

        /**
         * 交易失败
         */
        String respCode = (String) jsonObject.get("respCode");
        if (!ThirdPartyStatusEnum.T_PARTY_SUCCESS.getCode().equals(respCode)) {
            String respMsg = (String) jsonObject.get("respInfo");
            baseResponse.setFail();
            if (StringUtils.isNotBlank(respMsg)) {
                baseResponse.setRespInfo(respMsg);
            }
            return baseResponse;
        }
        Map<String, Object> converParam = this.convertParam(map);
        baseResponse.setSuccess(converParam);
        info("BIZ   creditCarInfoInpDto :{}", JSONObject.toJSONString(baseResponse));
        return baseResponse;
    }

    /**
     * 挡板
     *
     * @return
     */
    public BaseResponse<Map<String, Object>> getCreditCarInfoDB() {
        info("挡板ManMade--------------------------获取车辆信息------------------------");
        info("ManMade-----------start--------getCreditCarInfoDB--------------");
        BaseResponse baseResponse = new BaseResponse();
        CreditCarInfoListsOutDto creditCarInfoListsOutDto = new CreditCarInfoListsOutDto();
        CreditCarInfoOutDto creditCarInfoOutDto = new CreditCarInfoOutDto();
        creditCarInfoOutDto.setFncAplyID("9999070114190743783");
        creditCarInfoOutDto.setBrnd("梅赛德斯");
        creditCarInfoOutDto.setModl("BENZ");
        creditCarInfoOutDto.setQlfdNo("888888");
        creditCarInfoOutDto.setPdBtchNo("1234242111");
        creditCarInfoOutDto.setPdDt(new Date());
        creditCarInfoOutDto.setVhclModl("10000");
        creditCarInfoOutDto.setVhclNum(000000001);
        creditCarInfoOutDto.setVhclPrc(new BigDecimal("10000"));
        List<CreditCarInfoOutDto> creditCarInfoOutDtos = Arrays.asList(creditCarInfoOutDto);
        creditCarInfoListsOutDto.setCreditCarInfoOutDtos(creditCarInfoOutDtos);
        Map<String, Object> stringObjectMap = null;
        try {
            stringObjectMap = beanToMap(creditCarInfoListsOutDto, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseResponse.setSuccess(stringObjectMap);
        info("ManMade   return   BaseResponse  :{}", JSON.toJSONString(baseResponse));
        info("ManMade-----------end-----getCreditCarInfoDB--------------------");
        return baseResponse;


    }

    @Override
    public String httpPostUrl() {
        return sufxURL;
    }
}
