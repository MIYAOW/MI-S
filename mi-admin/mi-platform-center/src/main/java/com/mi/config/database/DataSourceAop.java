package com.mi.config.aspect.database;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 数据源切换AOP
 * @author yesh
 *         (M.M)!
 *         Created by 2017/6/16.
 */
@Slf4j
@Aspect
@Component
public class DataSourceAop {

    @Before("execution(* com.mi.module.*.controller..*.select*(..)) || execution(* com.mi.module.*.controller..*.find*(..)) || execution(* com.mi.module.*.controller..*.get*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        log.info("dataSource切换到：Read");
    }

    @Before("execution(* com.mi.module.*.controller..*.insert*(..)) || execution(* com.mi.module.*.controller..*.update*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        log.info("dataSource切换到：write");
    }
}
