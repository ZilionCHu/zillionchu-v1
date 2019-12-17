package com.github.zillionchu.zillionchucompanycore.thirdparty.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @类名称 RequestHandler
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/20 10:49
 * @版本 1.00
 */
public class RequestHandler extends HandlerInterceptorAdapter implements LoggerBase {


    @Autowired
    private RequestDtoHandler requestDtoHandler;

    private final static ThreadLocal<Map<String,Object>> localMap = new ThreadLocal();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        String remoteHost = request.getRemoteHost();
        String remoteAddr = request.getRemoteAddr();
        int remotePort = request.getRemotePort();

        Map<String,Object> hashMap = new HashMap<String,Object>();
        //获取当前时间纳秒为单位
        hashMap.put("beginTime",System.nanoTime());
        localMap.set(hashMap);
        info("************************************************** Into method beginTime:"+ LocalDateTime.now());
        info("**************************************************  Into    preHandle remoteAddr={} ,remoteHost={} ," +
                        "remotePort=" +
                        "{}", remoteAddr,
                remoteHost, remotePort);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
        info("**************************************************  Into    postHandle");
        super.postHandle(request, response, handler, modelAndView);
        Map<String, Object> stringObjectMap = localMap.get();
        String strbeginTime = stringObjectMap.get("beginTime").toString();
        //开始时间
        long beginTime = Long.parseLong(strbeginTime);
        long endTime = System.nanoTime();
        long  intervalTime= TimeUnit.NANOSECONDS.toSeconds(endTime - beginTime);
        info("************************************************** quit method excuteTime:"+ LocalDateTime.now());
        info("************************************************** intervalTime:"+ intervalTime+"/s");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
        info("**************************************************  Into  afterCompletion");
       // info("************************************************** CompletionSync method excuteTime:"+ LocalDateTime.now());
        requestDtoHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
