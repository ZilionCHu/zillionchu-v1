package com.github.zillionchu.zillionchucompanycore.thirdparty.common;

import com.alibaba.fastjson.JSONObject;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankRequestBaseDto;
import com.github.zillionchu.zillionchucompanyapidto.thirdparty.base.CyBankResponseBaseDto;
import com.github.zillionchu.zillionchucompanycore.thirdparty.enums.ThirdPartyStatusEnum;
import com.github.zillionchu.zillionchucompanycore.thirdparty.exception.ThirdPartyCreditException;
import com.github.zillionchu.zillionchucompanycore.thirdparty.exception.ThirdPartyException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @类名称 GlobalExceptionHandler
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/16 17:01
 * @版本 1.00
 */
@ControllerAdvice
public class ThirdpartyGlobalExceptionHandler implements LoggerBase {

    @Autowired
    private RequestDtoHandler requestDtoHandler;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CyBankResponseBaseDto exceptionHandler(Exception e) {
        info("exceptionHandler is = {}", e);
        info("exceptionHandler  class is = {}", e.getClass().getName());
        CyBankResponseBaseDto cyBankResponseBaseDto = new CyBankResponseBaseDto();
        CyBankRequestBaseDto thredLocalDto = getRequestBaseDto();
        info("GlobalExceptionHandler   is  ={}", JSONObject.toJSONString(thredLocalDto));
        if (thredLocalDto != null) {
            BeanUtils.copyProperties(thredLocalDto, cyBankResponseBaseDto);
        }
        cyBankResponseBaseDto.setRespCode(ThirdPartyStatusEnum.T_PARTY_SYS_ERROR.getCode());
        cyBankResponseBaseDto.setRespInfo(ThirdPartyStatusEnum.T_PARTY_SYS_ERROR.getName());
        info("exceptionHandler   resp  is  ={}", JSONObject.toJSONString(cyBankResponseBaseDto));
        return cyBankResponseBaseDto;
    }

    @ExceptionHandler(ThirdPartyException.class)
    @ResponseBody
    public CyBankResponseBaseDto thirdPartyExceptionHandler(ThirdPartyException e) {
        info("thirdPartyExceptionHandler is = {}", e);
        CyBankResponseBaseDto cyBankResponseBaseDto = new CyBankResponseBaseDto();
        CyBankRequestBaseDto thredLocalDto = getRequestBaseDto();
        if (thredLocalDto != null) {
            BeanUtils.copyProperties(thredLocalDto, cyBankResponseBaseDto);
        }
        cyBankResponseBaseDto.setRespCode(ThirdPartyStatusEnum.T_PARTY_SYS_ERROR.getCode());
        // cyBankResponseBaseDto.setRespInfo(ThirdPartyStatusEnum.T_PARTY_SYS_ERROR.getName() + "," + e.getMessage());
        cyBankResponseBaseDto.setRespInfo(e.getMessage());
        info("thirdPartyExceptionHandler   resp  is  ={}", JSONObject.toJSONString(cyBankResponseBaseDto));
        return cyBankResponseBaseDto;
    }


//    @ExceptionHandler(BizException.class)
//    @ResponseBody
//    public CyBankResponseBaseDto bizExceptionHandler(BizException e) {
//        info("bizExceptionHandler is = {}", e);
//        CyBankResponseBaseDto cyBankResponseBaseDto = new CyBankResponseBaseDto();
//        cyBankResponseBaseDto.setRespCode(ThirdPartyStatusEnum.T_PARTY_SYS_ERROR.getCode());
//        // cyBankResponseBaseDto.setRespInfo(ThirdPartyStatusEnum.T_PARTY_SYS_ERROR.getName() + "," + e.getMessage());
//        cyBankResponseBaseDto.setRespInfo(e.getMessage());
//        info("bizExceptionHandler   resp  is  ={}", JSONObject.toJSONString(cyBankResponseBaseDto));
//        return cyBankResponseBaseDto;
//    }

    @ExceptionHandler(ThirdPartyCreditException.class)
    @ResponseBody
    public BaseResponse thirdPartyCreditExceptionHandler(ThirdPartyCreditException e) {
        info("thirdPartyCreditExceptionHandler is = {}", e);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setFail();
        info("thirdPartyCreditExceptionHandler   resp  is  ={}", JSONObject.toJSONString(baseResponse));
        return baseResponse;

    }


    public CyBankRequestBaseDto getRequestBaseDto() {
        CyBankRequestBaseDto cyBankRequestBaseDto = requestDtoHandler.get();
        return cyBankRequestBaseDto;
    }

}
