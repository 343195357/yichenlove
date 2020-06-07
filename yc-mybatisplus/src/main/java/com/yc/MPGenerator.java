package com.yc;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.yc.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HHT
 * @version 1.0
 * @date 2020年6月6日19:08:55
 */
public class MPGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/yichenlove?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC&rewriteBatchedStatements=true");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        // dsc.setDriverName("com.mysql.jdbc.Driver"); //mysql5.6以下的驱动
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        final String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/yc-mybatisplus/src/main/java");
        gc.setAuthor("yiChenLove");//作者名称
        gc.setOpen(false);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

         gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("yiChenLove");// 作者

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.yc");
        //TODO:  自定义大模块名，表示放到哪个模块下的目录中，比如项目分模块 order/member
//        pc.setModuleName("user");
        //TODO:自定义小模块包名，比如放在controller下分小模块user/role等
        String modelName = "user";
        pc.setMapper("dao."+modelName);//dao
        pc.setService("service."+modelName);//servcie
        pc.setServiceImpl("service."+modelName+".impl"); //serviceImpl
        pc.setController("controller."+modelName);//controller
        pc.setEntity("entity."+modelName);



        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 模板引擎是 freemarker
        // 自定义controller的代码模板
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
       String templatePath = "/templates/mapper.xml.ftl";

        // 自定义配置会被优先输出,配置mapper.xml
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                //根据自己的位置修改
                return projectPath + "/yc-mybatisplus/src/main/resources/mappers/"+modelName+"/" +tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        /*
        //控制层
        templatePath = "/templates/controller.java.ftl";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/yc-mybatisplus/src/main/java/com/yc/" + "controller";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getControllerName());
                return entityFile;
            }
        });

        //业务层
        templatePath = "/templates/service.java.ftl";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/yc-mybatisplus/src/main/java/com/yc/" + "service";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getServiceName());
                return entityFile;
            }
        });
        templatePath = "/templates/serviceImpl.java.ftl";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/yc-mybatisplus/src/main/java/com/yc/" + "service/impl";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getServiceImplName());
                return entityFile;
            }
        });

        //数据层
        templatePath = "/templates/mapper.java.ftl";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/yc-mybatisplus/src/main/java/com/yc/"+"dao";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getMapperName());
                return entityFile;
            }
        });

        //数据层
        templatePath = "/templates/entity.java.ftl";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/yc-mybatisplus/src/main/java/com/yc/"+"entity";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getEntityName());
                return entityFile;
            }
        });

        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });*/
        mpg.setPackageInfo(pc);
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        templateConfig.setEntity("templates/1.java");
        // templateConfig.setService();
//        templateConfig.setController(null);
        //此处设置为null，就不会再java下创建xml的文件夹了
//        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setSuperEntityClass(BaseEntity.class);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        //表名
        strategy.setInclude("t_user");
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //根据你的表名来建对应的类名，如果你的表名没有什么下划线，比如test，那么你就可以取消这一步
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
