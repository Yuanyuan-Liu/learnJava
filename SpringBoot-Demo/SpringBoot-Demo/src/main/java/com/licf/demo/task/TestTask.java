package com.licf.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {
    //@Scheduled(cron = "0/10 * * * * *")
    public void work() {
        // task execution logic
        System.out.println("task开始了，当前时间戳：" + System.currentTimeMillis());
    }
}
