package com.jingdianjichi.auth.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的config管理
 *
 * @author 坤
 * @return null
 * @date 2024/5/10 14:35
 */
@Configuration
public class ThreadPoolConfig {
    @Bean(name = "labelThreadPool")
    public ThreadPoolExecutor getLabelThreadPool() {
        return new ThreadPoolExecutor(20, 100, 5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(40), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
