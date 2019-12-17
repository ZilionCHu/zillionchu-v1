package com.github.zillionchu.zillionchucompanycore.thirdparty.util;


import com.github.zillionchu.zillionchucompanycore.thirdparty.common.BaseResponse;
import com.github.zillionchu.zillionchucompanycore.thirdparty.enums.ThirdPartyStatusEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @类名称 ValidationUtil
 * @类描述 接口参数校验
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/9/16 11:53
 * @版本 1.00
 */
public class ValidationUtil {

    public static void validateDto(BaseResponse response, BindingResult bindingResult) {
        String errMsg = bindingResult.getAllErrors().stream()
                .map(e -> (FieldError) e)
                .map(FieldError::getDefaultMessage)
                .reduce((a, b) -> String.join(";", a, b))
                .orElse(StringUtils.EMPTY);

        if ((StringUtils.isNotEmpty(errMsg))) {
            response.setRespCode(ThirdPartyStatusEnum.T_PARTY_PG_FAIL.getCode());
            response.setRespInfo(errMsg);
        }
    }
}
