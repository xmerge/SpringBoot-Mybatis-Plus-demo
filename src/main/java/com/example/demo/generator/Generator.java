package com.example.demo.generator;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xmerge
 */
public class Generator {
    public static void main(String[] args) {
        //数据库连接
        String url = "jdbc:mysql://localhost:3306/springboot_demo";//数据库url
        String username = "root";//账号
        String password = "123456";//密码
        String module = "";//项目模块名，如果是有父项目的话，需要配置。
        //全局配置参数
        String author = "Xmerge";//作者
        String outputDir = System.getProperty("user.dir") + "/" + module + "/src/main/java";//指定输出目录
        //包配置参数
        String parent = "com.example";//父包名
        String moduleName = "demo";//父包模块名
        String entity = "entity.DO";//Entity 实体类包名
        String mapper = "mapper";//Mapper 包名
        String mapperXml = "mapper";//Mapper XML 包名
        String service = "service";//Service 包名
        String serviceImpl = "service.impl";//Service Impl 包名
        String controller = "controller";//Controller 包名*/
        //要生成的数据库表
        List<String> tables = new ArrayList<>();
        tables.add("tb_hospital");
        tables.add("tb_users");
        //开始生成
        FastAutoGenerator.create(url, username, password)
                //全局配置
                .globalConfig(builder -> {
                    builder.author(author)
                            .outputDir(outputDir)
                            .disableOpenDir() //生成之后不打开目录
                            /*.enableSwagger()//开启swagger*/
                            .dateType(DateType.ONLY_DATE) //定义生成的实体类中日期类型 DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                            .commentDate("yyyy-MM-dd");//注释日期
                })
                //包配置
                .packageConfig(builder -> builder.parent(parent)
                        .moduleName(moduleName)
                        .entity(entity)
                        .mapper(mapper)
                        .xml(mapperXml)
                        .service(service)
                        .serviceImpl(serviceImpl)
                        .controller(controller))
                //策略配置
                .strategyConfig(builder ->
                        builder.addTablePrefix("tb_") // 过滤表前缀
                                .addInclude(tables)
                                //开启生成实体类
                                .entityBuilder()
                                .formatFileName("%sDO")//格式化文件名称
                                .enableLombok()//开启 lombok 模型
                                .enableTableFieldAnnotation()//开启生成实体时生成字段注解
                                //开启生成mapper
                                .mapperBuilder()
                                //.enableBaseResultMap()//启用 BaseResultMap 生成
                                .superClass(BaseMapper.class)//设置父类
                                //.enableMapperAnnotation()//开启 @Mapper 注解
                                .formatMapperFileName("%sMapper")//格式化 mapper 文件名称
                                .formatXmlFileName("%sMapper")//格式化 xml 实现类文件名称
                                //开启生成service及impl
                                .serviceBuilder()
                                .formatServiceFileName("%sService")//格式化 service 接口文件名称
                                .formatServiceImplFileName("%sServiceImpl")//格式化 service 实现类文件名称
                                //开启生成controller
                                .controllerBuilder()
                                // 映射路径使用连字符格式，而不是驼峰
                                //.enableHyphenStyle()
                                .formatFileName("%sController")//格式化文件名称
                                .enableRestStyle())
                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                //.templateConfig(builder -> builder.controller(""))//关闭生成controller
                .execute();
    }

}