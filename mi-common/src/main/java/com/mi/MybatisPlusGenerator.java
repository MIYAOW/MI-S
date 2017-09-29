package com.mi;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.mi.common.util.StaticContantUtil;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.mi.common.util.FileUtil.getOpPath;

/**
 * MybatisPlus代码生成器
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017/6/22.
 */
public class MybatisPlusGenerator {
    /** 长变参数 **/
    private String[] tables;
    private String moduleDir;
    private final String packageParentName;
    private final String moduleName;

    {
        tables = new String[]{"blog_user"};//生成表名
        moduleDir = getOpPath("mi-admin","mi-platform-center"); //所用模块路径
        packageParentName = "com.mi.module";
        moduleName = "test1"; //模块包名
    }

    /**
     * 项目参数 配置
     **/
    private final String userDir = System.getProperty("user.dir");
    private final String proDir = userDir.substring(0, userDir.indexOf(getOpPath("mi-common"))); //EX: D:\MI\ 项目所在路径
    private final String outputDir = proDir + moduleDir + getOpPath("src", "main", "java");
    /**
     * MYSQL 配置
     **/
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String username = "root";
    private final String password = "root";
    private final String url = "jdbc:mysql://127.0.0.1:3306/mi?characterEncoding=utf8&useSSL=true";

    /**
     * 全局配置
     **/
    private GlobalConfig setGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor(StaticContantUtil.AUTHOR);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        return gc;
    }

    /**
     * 数据源配置
     **/
    private DataSourceConfig setDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setUrl(url);
        return dsc;
    }

    /**
     * 生成策略配置
     **/
    private StrategyConfig setStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(new String[]{""});// 此处可以修改为您的表前缀
        strategy.setInclude(tables); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        // 字段名生成策略
        // strategy.setFieldNaming(NamingStrategy.underline_to_camel);
        // 自定义实体父类
        //  strategy.setSuperEntityClass("com.mi.common.model.BaseModel");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        strategy.setCapitalMode(true);
        return strategy;
    }

    /**
     * 生成包配置
     **/
    private PackageConfig setPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageParentName);
        pc.setModuleName(moduleName);
        pc.setController("controller");
        pc.setXml("mapper.impl");
        return pc;
    }

    /**
     * 自定义模板配置
     **/
    private TemplateConfig setTemplateConfig() {
        TemplateConfig tc = new TemplateConfig();
        return tc;
    }

    @Test
    public void generator() {
        AutoGenerator mpg = new AutoGenerator();

        /** 全局配置 **/
        mpg.setGlobalConfig(setGlobalConfig());
        /**  数据源配置 **/
        mpg.setDataSource(setDataSourceConfig());
        /** 生成策略配置 **/
        mpg.setStrategy(setStrategyConfig());
        /** 生成包配置 **/
        mpg.setPackageInfo(setPackageConfig());
        /** 自定义模板配置 **/
        mpg.setTemplate(setTemplateConfig());


        /** 注入自定义配置，可以在 VM 中使用 MAP集合 设置的值 **/
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("Name", this.getConfig().getGlobalConfig().getAuthor() + "-MP");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);

        /** 执行生成 **/
        mpg.execute();

        /** 打印注入设置 **/
        System.err.println(mpg.getCfg().getMap().get("Name"));
    }


}
