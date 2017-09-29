//package com.mi.config.database;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * 多数据源切换
// * @author yesh
// *         (M.M)!
// *         Created by 2017/6/16.
// */
//public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {
//
//    private final int dataSourceNumber;
//
//    private AtomicInteger count = new AtomicInteger(0);
//
//    public MyAbstractRoutingDataSource(int dataSourceNumber) {
//        this.dataSourceNumber = dataSourceNumber;
//    }
//
//    @Override
//    protected Object determineCurrentLookupKey() {
//        String typeKey = DataSourceContextHolder.getJdbcType();
//        //配置MyBatis后
//        //determineTargetDataSource中默认跑了determineCurrentLookupKey方法
//        //若为空设置为主库（写）
//        if (typeKey == null){
//            return DataSourceType.write.getType();
//        }
//        else if (typeKey.equals(DataSourceType.write.getType())){
//            return DataSourceType.write.getType();
//        }
//
//        // 不为则为分库（读） 简单负载均衡
//        int number = count.getAndAdd(1);
//        int lookupKey = number % dataSourceNumber;
//        return new Integer(lookupKey);
//    }
//}
