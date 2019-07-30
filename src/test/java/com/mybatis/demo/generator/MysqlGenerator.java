package com.mybatis.demo.generator;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *code is far away from bug with the animal protecting
 *  ┏┓　　　┏┓
 *┏┛┻━━━┛┻┓
 *┃　　　　　　　┃ 　
 *┃　　　━　　　┃
 *┃　┳┛　┗┳　┃
 *┃　　　　　　　┃
 *┃　　　┻　　　┃
 *┃　　　　　　　┃
 *┗━┓　　　┏━┛
 *　　┃　　　┃神兽保佑
 *　　┃　　　┃代码无BUG！
 *　　┃　　　┗━━━┓
 *　　┃　　　　　　　┣┓
 *　　┃　　　　　　　┏┛
 *　　┗┓┓┏━┳┓┏┛
 *　　　┃┫┫　┃┫┫
 *　　　┗┻┛　┗┻┛
 *
 *   @Description : MybatisPlus代码生成器
 *   ---------------------------------
 *   @Author : Liang.Guangqing
 *   @Date : Create in 2017/9/19 14:48　
 */
public class MysqlGenerator {

    private static String packageName="basic";    //文件路径
    private static String authorName="daihanguang";     //作者
    //需要生成的表名
    private static String[] tables = {"sys_menufavorites"};                  //table名字

    private static String prefix="";                     //table前缀
    //获取web根路径
    private static String path = new File("lims-basic").getAbsolutePath();
    //获取web根路径
    private static String web_path = path + "/lims-basic-web";
    //获取service根路径
    private static String service_path = path + "/lims-basic-service";
    //获取mapper根路径
    private static String mapper_path = path + "/lims-basic-mapper";
    //获取pojo根路径
    private static String pojo_path = path + "/lims-basic-pojo";
    //数据库启动名称
    private static String driveClass = "com.mysql.jdbc.Driver";
    //数据库连接
    private static String sqlurl = "jdbc:mysql://localhost:3306/syn_master?characterEncoding=utf8";
    //数据库用户
    private static String username = "root";
    //数据库用户密码
    private static String password = "root";
    /**
     * 0只生成javabean,
     * 1代表生成javabean和mapper.xml,
     * 2代表生成javabean和mapper.xml,mapper.java
     * 3代表生成javabean和mapper.xml,mapper.java,Service
     * 4代表生成所有
     */
    private static int createFileType = 1;

    /**
     * 获取全局变量的配置
     * @return
     */
    private static GlobalConfig getGlobalConfig(){
        // 全局配置
        return new GlobalConfig()
                .setOutputDir(path+"/src/main/java")//输出目录
                .setFileOverride(true)// 是否覆盖文件
                .setActiveRecord(false)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setOpen(false)//生成后打开文件夹
                .setAuthor(authorName)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("I%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController");
    }

    /**
     * 获取数据源配置
     * @return
     */
    private static DataSourceConfig getDataSourceConfig(){
        // 数据源配置
        return new DataSourceConfig()
                .setDbType(DbType.MYSQL)// 数据库类型
                .setTypeConvert(new MySqlTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public DbColumnType processTypeConvert(String fieldType) {
                        System.out.println("转换类型：" + fieldType);
                        // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                        //    return DbColumnType.BOOLEAN;
                        // }
                        return super.processTypeConvert(fieldType);
                    }
                })
                .setDriverName(driveClass)
                .setUsername(username)
                .setPassword(password)
                .setUrl(sqlurl);
    }

    /**
     * 获取全局配置
     * @return
     */
    private static StrategyConfig getStrateConfig(List<TableFill> tableFillList){
        return new StrategyConfig()
                // .setCapitalMode(true)// 全局大写命名
                //.setDbColumnUnderline(true)//全局下划线命名
                .setTablePrefix(new String[]{prefix})// 此处可以修改为您的表前缀
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                .setInclude(tables) // 需要生成的表
                .setRestControllerStyle(true)
                .setSuperControllerClass("com.lims."+packageName+".controller.BaseController")
                .setSuperEntityClass("com.lims.common.bean.BasePojo")
                .setSuperEntityColumns("ID","AddWho","AddTime","EditWho","EditTime","Version")
                //.setExclude(new String[]{"test"}) // 排除生成的表
                // 自定义实体父类
                // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                // 自定义实体，公共字段
//                        .setSuperEntityColumns(new String[]{"AddWho","AddTime","EditWho","EditTime","Version"})
                .setTableFillList(tableFillList);
        // 自定义 mapper 父类
        // .setSuperMapperClass("com.baomidou.demo.TestMapper")
        // 自定义 service 父类
        // .setSuperServiceClass("com.baomidou.demo.TestService")
        // 自定义 service 实现类父类
//                .setSuperServiceImplClass("com.ynzbqb."+packageName+".service.BasePojo")
        // 自定义 controller 父类
//                        .setSuperControllerClass("com.lims."+packageName+".controller.AbstractController")
//                .setSuperEntityClass("com.ynzbqb."+packageName+".pojo.BasePojo");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // .setEntityColumnConstant(true)
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // .setEntityBuilderModel(true)
        // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
        // .setEntityLombokModel(true)
        // Boolean类型字段是否移除is前缀处理
        // .setEntityBooleanColumnRemoveIsPrefix(true)
        // .setRestControllerStyle(true)
        // .setControllerMappingHyphenStyle(true)
    }

    /**
     * 获取包配置
     * @return
     */
    private static  PackageConfig getPkgConf(){
        // 包配置
        return new PackageConfig()
                //.setModuleName("User")
                .setParent("com.lims."+packageName)// 自定义包路径
                .setController("controller")// 这里是控制器包名，默认 web
                .setEntity("pojo")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setXml("mapper");
    }

    /**
     * 自定义配置，可以在 VM 中使用 cfg.abc 设置的值
     * @return
     */
    private static InjectionConfig getInjectionConfig(){
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        List<FileOutConfig> fileOutConfigs = addEntityFileOutConfig(null);
        if(createFileType>0){
            fileOutConfigs = addMapperXmlFileOutConfig(fileOutConfigs);
        }
        if(createFileType>1){
            fileOutConfigs = addMapperFileOutConfig(fileOutConfigs);
        }
        if(createFileType>2){
            fileOutConfigs = addServiceFileOutConfig(fileOutConfigs);
        }
        if(createFileType>3){
            fileOutConfigs = addControllerFileOutConfig(fileOutConfigs);
        }
        injectionConfig.setFileOutConfigList(fileOutConfigs);
        return injectionConfig ;
    }

    /**
     * 添加实体对象自定义输出
     * @return
     */
    private static List<FileOutConfig> addEntityFileOutConfig(List<FileOutConfig> fileOutConfigs){
        fileOutConfigs = fileOutConfigs == null ? new ArrayList<>():fileOutConfigs;
        fileOutConfigs.add(new FileOutConfig("/templates/entity.java.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return pojo_path+"/src/main/java/com/lims/"+packageName+"/pojo/"+tableInfo.getEntityName()+".java";
            }
        });
        return  fileOutConfigs;
    }

    /**
     * 添加Mapper配置文件自定义输出
     */
    private static List<FileOutConfig> addMapperXmlFileOutConfig(List<FileOutConfig> fileOutConfigs){
        fileOutConfigs = fileOutConfigs == null ? new ArrayList<>():fileOutConfigs;
        fileOutConfigs.add(new FileOutConfig("/templates/mapper.xml.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return web_path+"/src/main/resources/mybatis/mappers/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        return  fileOutConfigs;
    }

    /**
     * 添加Mapper自定义输出
     */
    private static List<FileOutConfig> addMapperFileOutConfig(List<FileOutConfig> fileOutConfigs){
        fileOutConfigs = fileOutConfigs == null ? new ArrayList<>():fileOutConfigs;
        fileOutConfigs.add(new FileOutConfig("/templates/mapper.java.vm"){
            @Override
            public String outputFile(TableInfo tableInfo) {
                // TODO Auto-generated method stub
                return mapper_path+"/src/main/java/com/lims/"+packageName+"/mapper/"+tableInfo.getMapperName()+".java";
            }
        });
        return  fileOutConfigs;
    }

    /**
     * 添加Service自定义输出
     */
    private static List<FileOutConfig> addServiceFileOutConfig(List<FileOutConfig> fileOutConfigs){
        fileOutConfigs = fileOutConfigs == null ? new ArrayList<>():fileOutConfigs;
        fileOutConfigs.add(new FileOutConfig("/templates/service.java.vm"){

            @Override
            public String outputFile(TableInfo tableInfo) {
                // TODO Auto-generated method stub
                return service_path+"/src/main/java/com/lims/"+packageName+"/service/"+tableInfo.getServiceName()+".java";
            }

        });
        fileOutConfigs.add(new FileOutConfig("/templates/serviceImpl.java.vm"){

            @Override
            public String outputFile(TableInfo tableInfo) {
                // TODO Auto-generated method stub
                return service_path+"/src/main/java/com/lims/"+packageName+"/service/impl/"+tableInfo.getServiceImplName()+".java";
            }

        });
        return  fileOutConfigs;
    }

    /**
     * 添加Controller自定义输出
     */
    private static List<FileOutConfig> addControllerFileOutConfig(List<FileOutConfig> fileOutConfigs){
        fileOutConfigs = fileOutConfigs == null ? new ArrayList<>():fileOutConfigs;
        fileOutConfigs.add(new FileOutConfig("/templates/controller.java.vm"){
            @Override
            public String outputFile(TableInfo tableInfo) {
                // TODO Auto-generated method stub
                return web_path+"/src/main/java/com/lims/"+packageName+"/controller/"+tableInfo.getControllerName()+".java";
            }

        });
        return  fileOutConfigs;
    }


    /**
     * 获取模板的配置
     *
     * @return
     */
    private static TemplateConfig getTemplateConfig(){
        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null);
//        templateConfig.setController(null);
//        templateConfig.setService(null);
//        templateConfig.setServiceImpl(null);
//        templateConfig.setMapper(null);
//        templateConfig.setEntity(null);
        /**
         * 0只生成javabean,
         * 1代表生成javabean和mapper.xml,
         * 2代表生成javabean和mapper.xml,mapper.java
         * 3代表生成javabean和mapper.xml,mapper.java,Service
         * 4代表生成所有
         */
//        if(createFileType < 2  ){
//            templateConfig.setController(null);
//            templateConfig.setService(null);
//            templateConfig.setServiceImpl(null);
//            templateConfig.setMapper(null);
//        }else if(createFileType < 3){
//            templateConfig.setController(null);
//            templateConfig.setService(null);
//            templateConfig.setServiceImpl(null);
//        }else if(createFileType < 4){
//            templateConfig.setController(null);
//        }
        return templateConfig;
        // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
        // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
        // .setController("...");
        // .setEntity("...");
        // .setMapper("...");
        // .setXml("...");
        // .setService("...");
        // .setServiceImpl("...");
    }

    public static void main(String[] args) {
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(getGlobalConfig()
        ).setDataSource(getDataSourceConfig()
        ).setStrategy(getStrateConfig(tableFillList)
        ).setPackageInfo(getPkgConf()
        ).setCfg(getInjectionConfig()
        ).setTemplate(getTemplateConfig()
        );
        // 执行生成
        mpg.execute();

        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}