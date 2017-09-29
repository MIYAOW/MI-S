package com.mi.config.database;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据源配置
 * @author yesh
 *         (M.M)!
 *         Created by 2017/6/16.
 */
@Slf4j
@Configuration
@Component
@PropertySource(value = "classpath:application.properties")
public class DataBaseConfiguration {

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    /**
     * 主库配置（负责写）
     * @return
     */
    @Bean(name="masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource writeDataSource() {
        log.info("-------------------- Master DataSource init ---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
//    /**
//     * 从库配置（负责读）
//     * @return
//     */
//    @Bean(name = "slaveDataSourceOne")
//    @ConfigurationProperties(prefix = "spring.slave")
//    public DataSource readDataSourceOne(){
//        log.info("-------------------- Slave DataSource One init ---------------------");
//        return DataSourceBuilder.create().type(dataSourceType).build();
//    }

//    @Bean(name = "slaveDataSourceTwo")
//    @ConfigurationProperties(prefix = "spring.slave1",locations = "classpath:application.properties")
//    public DataSource readDataSourceTwo() {
//        log.info("-------------------- Slave DataSource Two init ---------------------");
//        return DataSourceBuilder.create().type(dataSourceType).build();
//    }

//    @Bean("readDataSources")
//    public List<DataSource> readDataSources(){
//        List<DataSource> dataSources=new ArrayList<>();
//        dataSources.add(readDataSourceOne());
////        dataSources.add(readDataSourceTwo());
//        return dataSources;
//    }
}
