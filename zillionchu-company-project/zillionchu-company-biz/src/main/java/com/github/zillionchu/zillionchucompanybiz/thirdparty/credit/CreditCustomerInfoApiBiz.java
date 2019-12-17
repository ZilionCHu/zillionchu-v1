package com.github.zillionchu.zillionchucompanybiz.thirdparty.credit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.zillionchu.zillionchucompanyapi.thirdparty.credit.CreditCustomerInfoApi;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.input.dto.CreditCustomerInfoInpDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditCustomerExeOfficerOutDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditCustomerManagerOutDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditCustomerOutInfoDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.credit.output.dto.CreditCustomerShareholderOutDto;
import com.github.zillionchu.zillionchucompanybiz.thirdparty.feign.CommonSeqNoFeign;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
import com.github.zillionchu.zillionchucompanycore.thirdparty.common.LoggerBase;
import com.github.zillionchu.zillionchucompanycore.thirdparty.enums.ThirdPartyStatusEnum;
import com.github.zillionchu.zillionchucompanycore.thirdparty.http.AbstractHttpPostUrlTemplate;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @类名称 CreditCustomerInfoAPIBiz
 * @类描述 客户接口
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/11 18:52
 * @版本 1.00
 */

@RestController
public class CreditCustomerInfoApiBiz extends AbstractHttpPostUrlTemplate implements CreditCustomerInfoApi, LoggerBase {


    @Value("${thirdparty.config.url.credit.sufx.credit-customer}")
    private String customerURL;

    @Autowired
    private CommonSeqNoFeign commonSeqNoFeign;


    /**
     * @param creditCustomerInfoInpDto 根据客户名称、客户编号获取客户信息
     * @return
     */

    @ApiOperation(
            value = "客户信息",
            response = BaseResponse.class)
    @Override
    public BaseResponse<Map<String, Object>> getCreditCustomerInfo(@RequestBody CreditCustomerInfoInpDto
                                                                           creditCustomerInfoInpDto
    ) {
        info("http    post  Request  dto   is :{}", JSONObject.toJSONString(creditCustomerInfoInpDto));
        BaseResponse baseResponse = new BaseResponse();
        String chkMsg = checkPostParams(creditCustomerInfoInpDto);
        info("http    post  Request  checkDto  is :{}", chkMsg);
        //校验必输选项
        if (StringUtils.isNotBlank(chkMsg)) {
            baseResponse.setFail();
            return baseResponse;
        }
        Boolean manMade = thirdPartyProperties.getManMade();
        info("------------------------------获取客户信息------------------------");
        info("thirdparty  config  manMade is :  {}", manMade);
        info("thirdparty  config   creditCustomerInfoInpDto is :  {}", creditCustomerInfoInpDto
                .toString());
        if (manMade && creditCustomerInfoInpDto.getFlag()) {
            return getThisCreditCustomerInfoDB();
        }
        //公共报文流水号
        String seqNo = commonSeqNoFeign.buildSerialNum("scf_10045", "");
        // String seqNo = "1000";
        info("Get  buildSerialNum  seqNo   is = {}", seqNo);
        super.convertBaseDto(creditCustomerInfoInpDto, seqNo);
        JSONObject jsonObject = httpClientPost(creditCustomerInfoInpDto);

        /**
         * 交易失败
         */
        if (jsonObject == null) {
            baseResponse.setFail();
            return baseResponse;
        }
        String respCode = (String) jsonObject.get("respCode");
        if (!ThirdPartyStatusEnum.T_PARTY_SUCCESS.getCode().equals(respCode)) {
            String respMsg = (String) jsonObject.get("respInfo");
            baseResponse.setFail();
            if (StringUtils.isNotBlank(respMsg)) {
                baseResponse.setRespInfo(respMsg);
            }
            return baseResponse;
        }
        CreditCustomerOutInfoDto creditCustomerOutInfoDto = JSON.toJavaObject(jsonObject,
                CreditCustomerOutInfoDto.class);
        castDataDictionary(creditCustomerOutInfoDto);
        baseResponse.setSuccess(creditCustomerOutInfoDto);
        info("BIZ   getCreditCustomerInfo :{}", JSONObject.toJSONString(baseResponse));
        return baseResponse;

    }


    /**
     * 数据字典转换
     *
     * @param creditCustomerOutInfoDto
     */
    public void castDataDictionary(CreditCustomerOutInfoDto creditCustomerOutInfoDto) {
        //币种
        String ccy = creditCustomerOutInfoDto.getCcy();
        if (StringUtils.isNotEmpty(ccy)) {
            String castCct = ccyCast(ccy);
            creditCustomerOutInfoDto.setCcy(castCct);
        }

        //企业证件类型
        String entpCrdtTp = creditCustomerOutInfoDto.getEntpCrdtTp();
        if (StringUtils.isNotEmpty(entpCrdtTp)) {
            String companyCardType = companyCardType(entpCrdtTp);
            creditCustomerOutInfoDto.setEntpCrdtTp(companyCardType);
        }

        //高管证件类型
        List<CreditCustomerExeOfficerOutDto> creditExeOfficer = creditCustomerOutInfoDto
                .getCreditCustomerExeOfficerOutDtos();

        if (!CollectionUtils.isEmpty(creditExeOfficer)) {
            creditExeOfficer.forEach(c -> {
                String crdtTp = c.getCrdtTp();
                c.setCrdtTp(idCardType(crdtTp));
            });
        }
    }

    /**
     * 币种
     *
     * @param ccy
     * @return
     */
    public String ccyCast(String ccy) {
        switch (ccy) {
            case "036":
                return "0";
            case "124":
                return "1";
            case "156":
                return "2";
            case "344":
                return "3";
            case "392":
                return "4";
            case "410":
                return "5";
            case "446":
                return "6";
            case "458":
                return "7";
            case "702":
                return "8";
            case "810":
                return "9";
            case "826":
                return "10";
            case "840":
                return "11";
            case "901":
                return "12";
            case "978":
                return "13";
            default:
                break;
        }
        return "";
    }

    /**
     * 企业证件类型
     *
     * @param cardType
     * @return
     */
    public String companyCardType(String cardType) {
        switch (cardType) {
            case "01":
                return "1";
            case "02":
                return "2";
            case "03":
                return "3";
            case "04":
                return "4";
            case "05":
                return "5";
            case "06":
                return "6";
            case "07":
                return "7";
            case "08":
                return "8";
            case "09":
                return "9";
            case "10":
                return "10";
            case "11":
                return "11";
            case "12":
                return "12";
            case "13":
                return "13";
            case "14":
                return "14";
            default:
                break;
        }
        return "";

    }

    /**
     * 证件类型
     *
     * @param idType
     * @return
     */
    public String idCardType(String idType) {
        switch (idType) {
            case "1":
                return "0";
            case "9":
                return "0";
            case "7":
                return "1";
            case "8":
                return "1";
            case "3":
                return "2";
            case "2":
                return "3";
            case "4":
                return "3";
            case "5":
                return "3";
            case "6":
                return "3";
            case "10":
                return "3";
            case "11":
                return "3";
            case "12":
                return "3";
            case "13":
                return "3";
            case "14":
                return "3";
            case "17":
                return "3";
            default:
                break;
        }
        return "";
    }


    /**
     * 客户信息挡板
     *
     * @return
     */
    public BaseResponse<Map<String, Object>> getThisCreditCustomerInfoDB(
    ) {
        info("挡板ManMade--------------------------获取客户信息------------------------");
        info("ManMade-----------start--------getThisCreditCustomerInfoDB--------------");
        BaseResponse baseResponse = new BaseResponse();
        CreditCustomerOutInfoDto creditCustomerOutInfoDto = new CreditCustomerOutInfoDto();
        creditCustomerOutInfoDto.setCrcstId("10000006511472");
        creditCustomerOutInfoDto.setCstNm("石家庄天缘乳业有限公司");
        creditCustomerOutInfoDto.setCstEngNm("SHIJIAZHUABNG-BEST");
        creditCustomerOutInfoDto.setEntpCrdtTp("1");
        creditCustomerOutInfoDto.setEntpCrdtNo("130185000001448");
        creditCustomerOutInfoDto.setOrcd("74849163-9");
        creditCustomerOutInfoDto.setTel("0310-99990367");
        creditCustomerOutInfoDto.setEmailAdr("050200");
        creditCustomerOutInfoDto.setCoWebst("");
        creditCustomerOutInfoDto.setFax("");
        creditCustomerOutInfoDto.setCtcpsn("张三");
        creditCustomerOutInfoDto.setCtcPsnMblPhNo("18888881111");
        creditCustomerOutInfoDto.setCenterSignCd("1301140000278194");
        creditCustomerOutInfoDto.setRtgRgs("17");
        creditCustomerOutInfoDto.setEntpSz("4");
        creditCustomerOutInfoDto.setEntpFdTm("");
        creditCustomerOutInfoDto.setCcy("156");
        creditCustomerOutInfoDto.setRgstCptlamt("20000000.00");
        creditCustomerOutInfoDto.setRgstAdr("石家庄市五七路");

        //客户经理
        CreditCustomerManagerOutDto creditCustomerManagerOutDto00 = new CreditCustomerManagerOutDto();
        creditCustomerManagerOutDto00.setCstMgr("20110817950");
        creditCustomerManagerOutDto00.setMgtTp("2");
        creditCustomerManagerOutDto00.setBlngInst("13000332");

        CreditCustomerManagerOutDto creditCustomerManagerOutDto01 = new CreditCustomerManagerOutDto();
        creditCustomerManagerOutDto01.setCstMgr("20121028480");
        creditCustomerManagerOutDto01.setMgtTp("1");
        creditCustomerManagerOutDto01.setBlngInst("13000332");

        CreditCustomerManagerOutDto creditCustomerManagerOutDto02 = new CreditCustomerManagerOutDto();
        creditCustomerManagerOutDto02.setCstMgr("20110817952");
        creditCustomerManagerOutDto02.setMgtTp("2");
        creditCustomerManagerOutDto02.setBlngInst("13000332");

        //高管
        CreditCustomerExeOfficerOutDto creditCustomerExeOfficerOutDto = new CreditCustomerExeOfficerOutDto();
        creditCustomerExeOfficerOutDto.setExecutiveNm("李思思");
        creditCustomerExeOfficerOutDto.setPosition("1");
        creditCustomerExeOfficerOutDto.setCrdtTp("1");
        creditCustomerExeOfficerOutDto.setCrdtNo("130185198111264012");
        creditCustomerExeOfficerOutDto.setGnd("2");
        creditCustomerExeOfficerOutDto.setBrthDt("2019-10-11");
        creditCustomerExeOfficerOutDto.setEddgr("2");
        creditCustomerExeOfficerOutDto.setRelldyCreryrLmt("2");
        creditCustomerExeOfficerOutDto.setCtcTel("19912341234");
        creditCustomerExeOfficerOutDto.setFixTel("010-111111");

        //股东
        CreditCustomerShareholderOutDto creditCustomerShareholderOutDto = new CreditCustomerShareholderOutDto();
        creditCustomerShareholderOutDto.setShrhNm("刘勇");
        creditCustomerShareholderOutDto.setShrhTp("6");
        creditCustomerShareholderOutDto.setCrdtTp("1");
        creditCustomerShareholderOutDto.setCrdtNo("130105195706011254");
        creditCustomerShareholderOutDto.setIvsAmt("1300000.00");
        creditCustomerShareholderOutDto.setIvsCcy("156");
        creditCustomerShareholderOutDto.setFnddMod("04");
        creditCustomerShareholderOutDto.setWthrVld("");
        creditCustomerShareholderOutDto.setHoldshrSttn("0.434400");

        List<CreditCustomerManagerOutDto> creditCustomerManagerOutDtos = Arrays.asList(creditCustomerManagerOutDto00,
                creditCustomerManagerOutDto01, creditCustomerManagerOutDto02);
        List<CreditCustomerExeOfficerOutDto> creditCustomerExeOfficerOutDtos = Arrays.asList
                (creditCustomerExeOfficerOutDto);
        List<CreditCustomerShareholderOutDto> creditCustomerShareholderOutDtos = Arrays.asList
                (creditCustomerShareholderOutDto);

        creditCustomerOutInfoDto.setCreditCustomerShareholderOutDtos(creditCustomerShareholderOutDtos);
        creditCustomerOutInfoDto.setCreditCustomerExeOfficerOutDtos(creditCustomerExeOfficerOutDtos);
        creditCustomerOutInfoDto.setCreditCustomerManagerOutDtos(creditCustomerManagerOutDtos);

//        Map<String, Object> stringObjectMap = null;
//        try {
//            stringObjectMap = beanToMap(creditCustomerOutInfoDto, true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        baseResponse.setSuccess(creditCustomerOutInfoDto);
        info("ManMade   return   BaseResponse  :{}", JSON.toJSONString(baseResponse));
        info("ManMade-----------end-----getThisCreditCustomerInfoDB--------------------");
        return baseResponse;
    }

    @Override
    public String httpPostUrl() {
        return customerURL;
    }
}
