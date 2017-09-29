//package com.mi.config.aspect;
//
//import com.alibaba.fastjson.JSON;
//import com.mi.module.blog.entity.Log;
//import com.mi.module.blog.mapper.LogMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
// * 统一AOP日志输出
// *
// * @author yesh
// *         (M.M)!
// *         Created by 2017/6/14.
// */
//@Aspect
//@Component
//@Slf4j
//public class WebRequestLogAspect {
//
//    @Autowired
//    private LogMapper logMapper;
//
//    private ThreadLocal<Long> startTime = new ThreadLocal<>();
//    private ThreadLocal<Log> logLocal = new ThreadLocal<>();
//
//    Log blog;
//
//    @Pointcut("execution(public * com.mi.module.*.controller..*.*(..))")
//    public void webLog() {
//    }
//
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        startTime.set(System.currentTimeMillis());
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        // 记录下请求内容（先用字符串定义变量）需简洁可直接用对象
//        String URL = request.getRequestURL().toString();
//        String HTTP_METHOD = request.getMethod();
//        String IP = (request.getRemoteAddr().equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : request.getRemoteAddr());
//        String CLASS_METHOD = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
//        String ARGS = Arrays.toString(joinPoint.getArgs());
//        //利用session记录用户 以及用户信息
//        blog = new Log();
//        blog.setUrl(URL);
//        blog.setHttpMethod(HTTP_METHOD);
//        blog.setIp(IP);
//        blog.setClassMethod(CLASS_METHOD);
//        blog.setArgs(ARGS);
//
//        log.info("URL : " + URL);
//        log.info("HTTP_METHOD : " + HTTP_METHOD);
//        log.info("IP : " + IP);
//        log.info("CLASS_METHOD : " + CLASS_METHOD);
//        log.info("ARGS : " + ARGS);
//        logLocal.set(blog);
//
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        long spendTime = (System.currentTimeMillis() - startTime.get());
//        // 处理完请求，返回内容
//        log.info("RESPONSE : " + ret);
//        log.info("SPEND_TIME : " + spendTime);
//        blog = logLocal.get();
//        blog.setSpendTime((int) spendTime);
//        blog.setResult(ret == null ? "" : JSON.toJSONString(ret));
//
//        logMapper.insert(blog);
//    }
//}