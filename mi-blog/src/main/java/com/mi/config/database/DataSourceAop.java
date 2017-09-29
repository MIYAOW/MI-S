//package com.mi.config.database;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
///**
// * 数据源切换AOP
// * @author yesh
// *         (M.M)!
// *         Created by 2017/6/16.
// */
//@Slf4j
//@Aspect
//@Component
//public class DataSourceAop {
//
//    @Before("execution(* com.mi.module.*.mapper..*.load*(..)) || execution(* com.mi.module.*.mapper..*.select*(..)) || execution(* com.mi.module.*.mapper..*.find*(..)) || execution(* com.mi.module.*.mapper..*.get*(..))")
//    public void setReadDataSourceType() {
//        DataSourceContextHolder.read();
//        log.info("dataSource切换到：Read");
//    }
//
//    @Before("execution(* com.mi.module.*.mapper..*.insert*(..)) || execution(* com.mi.module.*.mapper..*.update*(..)) || execution(* com.mi.module.*.mapper..*.save*(..)) ")
//    public void setWriteDataSourceType() {
//        DataSourceContextHolder.write();
//        log.info("dataSource切换到：write");
//    }
//}
