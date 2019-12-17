package com.github.zillionchu.zillionchucompanybiz.thirdparty.credit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.credit.CreditMarginInfoApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.input.dto.CreditMarginInfoInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditMarginOutInfoDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.CommonSeqNoFeign;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.github.zillionchu.zillionchucompanycore.thirdparty.enums.ThirdPartyStatusEnum;
import com.github.zillionchu.zillionchucompanycore.thirdparty.http.AbstractHttpPostUrlTemplate;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @类名称 CreditMarginInfoApiBiz
 * @类描述 保证金
 * @作者 tykj@tansun.cn
 * @创建时间 2019/9/11 19:35
 * @版本 1.00
 */
@RestController
public class CreditMarginInfoApiBiz extends AbstractHttpPostUrlTemplate implements CreditMarginInfoApi, LoggerBase {


    @Value("${thirdparty.config.url.credit.sufx.credit-margin}")
    private String sufxURL;
    @Autowired
    private CommonSeqNoFeign commonSeqNoFeign;

    /**
     * 保证金信息查询接口
     *
     * @param creditMarginInfoInpDto
     * @return
     */
    @ApiOperation(
            value = "保证金",
            response = BaseResponse.class)
    @Override
    public BaseResponse<Map<String, Object>> getCreditMarginInfo(@RequestBody CreditMarginInfoInpDto
                                                                         creditMarginInfoInpDto) {
        info("http    post  Request  dto   is :{}", JSONObject.toJSONString(creditMarginInfoInpDto));
        BaseResponse baseResponse = new BaseResponse();
        String chkMsg = checkPostParams(creditMarginInfoInpDto);
        info("http    post  Request  checkDto  is :{}", chkMsg);
        //校验必输选项
        if (StringUtils.isNotBlank(chkMsg)) {
            baseResponse.setFail();
            return baseResponse;
        }
        Boolean manMade = thirdPartyProperties.getManMade();
        info("------------------------------获取保证金信息------------------------");
        info("thirdparty  config  manMade is :  {}", manMade);
        info("thirdparty  config   creditMarginInfoInpDto is :  {}", creditMarginInfoInpDto
                .toString());
        if (manMade && creditMarginInfoInpDto.getFlag()) {
            return getCreditMarginInfoDB();
        }
        //公共报文
        String seqNo = commonSeqNoFeign.buildSerialNum("scf_10045", "");
        super.convertBaseDto(creditMarginInfoInpDto, seqNo);
        JSONObject jsonObject = httpClientPost(creditMarginInfoInpDto);
        if (jsonObject == null) {
            baseResponse.setFail();
            return baseResponse;
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
        info("BIZ   creditIousInfoInpDto :{}", JSONObject.toJSONString(baseResponse));
        return baseResponse;
    }

    /**
     * 挡板
     */
    public BaseResponse<Map<String, Object>> getCreditMarginInfoDB() {
        info("挡板ManMade--------------------------获取保证金信息------------------------");
        info("ManMade-----------start--------getCreditMarginInfoDB--------------");
        BaseResponse baseResponse = new BaseResponse();
        CreditMarginOutInfoDto creditMarginOutInfoDto = new CreditMarginOutInfoDto();
        creditMarginOutInfoDto.setMrgnAccNm("9");
        creditMarginOutInfoDto.setMrgnAccNo("2");
        creditMarginOutInfoDto.setMrgnAccSt("00003");
        creditMarginOutInfoDto.setMrgnAccAvlBal(new BigDecimal(60030));
        Map<String, Object> stringObjectMap = null;
        try {
            stringObjectMap = beanToMap(creditMarginOutInfoDto, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseResponse.setSuccess(stringObjectMap);
        info("ManMade   return   BaseResponse  :{}", JSON.toJSONString(baseResponse));
        info("ManMade-----------end-----getCreditMarginInfoDB--------------------");
        return baseResponse;

    }

    @Override
    public String httpPostUrl() {
        return sufxURL;
    }
}
