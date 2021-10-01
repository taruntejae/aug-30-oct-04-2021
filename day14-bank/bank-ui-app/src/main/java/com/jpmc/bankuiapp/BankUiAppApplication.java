package com.jpmc.bankuiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
@Configuration
public class BankUiAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankUiAppApplication.class, args);
    }

    @Bean(name = "threadPoolExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int numberOfThreads = Runtime.getRuntime().availableProcessors() - 1; //If the task is CPU intensive
        //If it's IO intensive, the number of threads can be easily increased based on the formula of blockingfactor
        executor.setCorePoolSize(numberOfThreads);
        executor.setMaxPoolSize(numberOfThreads);
        executor.setThreadNamePrefix("jmpc-");
        return executor;
    }
}
