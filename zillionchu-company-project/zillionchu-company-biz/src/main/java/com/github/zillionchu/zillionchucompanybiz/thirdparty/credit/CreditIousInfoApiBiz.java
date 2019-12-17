package com.github.zillionchu.zillionchucompanybiz.thirdparty.credit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.credit.CreditIousInfoApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.input.dto.CreditIousInfoInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditIousOutInfoDto;
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
import java.util.Date;
import java.util.Map;

/**
 * @类名称 CreditIousInfoApiBiz
 * @类描述 借据接口
 * @作者 tykj@tansun.cn
 * @创建时间 2019/9/11 19:34
 * @版本 1.00
 */

@RestController
public class CreditIousInfoApiBiz extends AbstractHttpPostUrlTemplate implements CreditIousInfoApi, LoggerBase {


    @Value("${thirdparty.config.url.credit.sufx.credit-ious}")
    private String sufxURL;
    @Autowired
    private CommonSeqNoFeign commonSeqNoFeign;


    @ApiOperation(
            value = "借据",
            response = BaseResponse.class)
    @Override
    public BaseResponse<Map<String, Object>> getCreditIousInfo(@RequestBody CreditIousInfoInpDto creditIousInfoInpDto) {

        info("http    post  Request  dto   is :{}", JSONObject.toJSONString(creditIousInfoInpDto));
        BaseResponse baseResponse = new BaseResponse();
        String chkMsg = checkPostParams(creditIousInfoInpDto);
        info("http    post  Request  checkDto  is :{}", chkMsg);
        //校验必输选项
        if(StringUtils.isNotBlank(chkMsg)){
            baseResponse.setFail();
            return baseResponse;
        }
        Boolean manMade = thirdPartyProperties.getManMade();
        info("------------------------------获取借据信息------------------------");
        info("thirdparty  config  manMade is :  {}", manMade);
        info("thirdparty  config   creditIousInfoInpDto is :  {}", creditIousInfoInpDto
                .toString());
        if (manMade && creditIousInfoInpDto.getFlag()) {
            return getCreditIousInfoDB();
        }
        //公共报文
        String seqNo = commonSeqNoFeign.buildSerialNum("scf_10045","");
        super.convertBaseDto(creditIousInfoInpDto,seqNo);
        JSONObject jsonObject = httpClientPost(creditIousInfoInpDto);
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
    public BaseResponse<Map<String, Object>> getCreditIousInfoDB() {
        info("挡板ManMade--------------------------获取借据信息------------------------");
        info("ManMade-----------start--------getCreditIousInfoDB--------------");
        BaseResponse baseResponse = new BaseResponse();
        CreditIousOutInfoDto creditIousOutInfoDto = new CreditIousOutInfoDto();
        creditIousOutInfoDto.setBillID("123456789");
        creditIousOutInfoDto.setFncDsbrDt(new Date());
        creditIousOutInfoDto.setFncExDat(new Date());
        creditIousOutInfoDto.setFncAmt(new BigDecimal(12345));
        creditIousOutInfoDto.setBillMod("流贷");
        creditIousOutInfoDto.setBillBal(new BigDecimal(123456));

        Map<String, Object> stringObjectMap = null;
        try {
            stringObjectMap = beanToMap(creditIousOutInfoDto, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseResponse.setSuccess(stringObjectMap);
        info("ManMade   return   BaseResponse  :{}", JSON.toJSONString(baseResponse));
        info("ManMade-----------end-----getCreditIousInfoDB--------------------");
        return baseResponse;

    }

    @Override
    public String httpPostUrl() {
        return sufxURL;
    }
}
