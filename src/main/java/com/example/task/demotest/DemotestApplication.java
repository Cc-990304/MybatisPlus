package com.example.task.demotest;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication(scanBasePackages = {"com.example.task.demotest", "com.controller", "com.service", "com.mapper", "com.domain"})
@MapperScan("com.mapper")
public class DemotestApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemotestApplication.class);

    public static void main(String[] args) {
        // 正确获取应用上下文
        ConfigurableApplicationContext context = SpringApplication.run(DemotestApplication.class, args);

        // 从上下文中获取环境配置
        ConfigurableEnvironment env = context.getEnvironment();

        // 记录数据源信息
        logger.info("Datasource URL: {}", env.getProperty("spring.datasource.url"));
        logger.info("Datasource Username: {}", env.getProperty("spring.datasource.username"));
        logger.info("Datasource Password: {}", env.getProperty("spring.datasource.password"));
    }
}