package com.github.zillionchu.zillionchucompanycore.thirdparty.common;//package com.tansun.thirdparty.common;
//
//import com.jeedev.msdp.standard.exception.BizException;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
///**
// * @类名称 GlobalArgsHandler
// * @类描述
// * @作者 chuyuefeng@tansun.cn
// * @创建时间 2019/10/16 20:24
// * @版本 1.00
// */
//@Aspect
//@Component
//public class GlobalArgsHandler implements LoggerBase {
//
//    @Pointcut("execution(public * com.tansun.thirdparty..*.*(..))")
//    public void argsCut() {
//    }
//
//    @Around("argsCut()")
//    public Object argsCutHandler(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        try {
//            String className = joinPoint.getSignature().getDeclaringTypeName();
//            String methedName = joinPoint.getSignature().getName();
//            info("Args===thirdPatry   cut   args");
//            info("Args===thirdPatry   class  is  = {} , method is = {} ", className, methedName);
//            if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
//                Arrays.asList(joinPoint.getArgs()).forEach((final Object param) -> info("Args==={}", param));
//            }
//
//            return joinPoint.proceed();
//        } catch (BizException e) {
//            throw new Exception(e);
////        } catch (Throwable throwable) {
////            // throwable.printStackTrace();
////            info("Args===targsCutHandler throwable is  ={}", throwable);
////            throw new Exception(throwable);
//        }
//
//        //return null;
//    }
//
//
//}
