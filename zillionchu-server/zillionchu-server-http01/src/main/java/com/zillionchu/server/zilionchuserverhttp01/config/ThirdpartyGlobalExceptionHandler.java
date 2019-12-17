package com.zillionchu.server.zilionchuserverhttp01.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @类名称 GlobalExceptionHandler
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/16 17:01
 * @版本 1.00
 */
@ControllerAdvice
public class ThirdpartyGlobalExceptionHandler{


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY,reason = "服务器内部错误")
    public String exceptionHandler(Exception e) {

        return "系统错误"+e.getMessage();
    }



}
