package com.jingdianjichi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description 刷题微服务启动类
 *
 * @date 2024/3/28 16:44
 * @author 坤
 */

@SpringBootApplication
@MapperScan("com.jingdianjichi.**.mapper")
@ComponentScan("com.jingdianjichi")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }
}
