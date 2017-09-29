package com.mi.config.aspect.database;

import lombok.extern.slf4j.Slf4j;

/**
 * 本地线程全局变量(控制读写分离)
 * @author yesh
 *         (M.M)!
 *         Created by 2017/6/16.
 */
@Slf4j
public class DataSourceContextHolder {

    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * Read Maybe More Database
     */
    public static void read() {
        local.set(DataSourceType.read.getType());
    }

    /**
     * Write Only One DataBase
     */
    public static void write() {
        local.set(DataSourceType.write.getType());
    }

    public static String getJdbcType() {
        return local.get();
    }
}
