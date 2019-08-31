package com.licf.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 配置TaskScheduler线程池
 * 原因：spring默认会创建一个单线程池。这样对于我们的多任务调度可能会是致命的。
 *      当多个任务并发（或需要在同一时间）执行时，任务调度器就会出现时间漂移，任务执行时间将不确定。
 * Todo ：可以考虑建立一个任务表到mysql 每个ScheduleController只负责insert任务到表，定时五分钟扫描此表，开启任务，可记录开始时间，结束时间，状态等
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    /**
     * 新增一个配置类，实现SchedulingConfigurer接口。重写configureTasks方法，通过taskRegistrar设置自定义线程池。
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(20);
    }
}
