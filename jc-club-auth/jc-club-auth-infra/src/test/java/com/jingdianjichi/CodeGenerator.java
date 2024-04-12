package com.jingdianjichi;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url ="jdbc:mysql://47.122.45.3:3306/jc-club?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String username = "root";
        String password = "137080";
        String moduleName = "auth";
        //jc-club\jc-club\jc-club-subject\jc-club-subject-infra\src\test\java\org\spoto
        String mapperLocation = "D:\\DevelopFiles\\jc-club\\jc-club\\jc-club-auth\\jc-club-auth-infra\\src\\main\\resources\\mapper\\"
                + moduleName;
        String tables = "auth_permission,auth_role,auth_role_permission,auth_user,auth_user_role";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("luochen") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                           // .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\DevelopFiles\\jc-club\\jc-club\\jc-club-auth\\jc-club-auth-infra\\src\\main\\java"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.jingdianjichi") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("auth"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
