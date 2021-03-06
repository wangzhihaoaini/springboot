package com.wangzhihao.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EnableScheduling  //开启基于注解的定时任务
@EnableCaching  //开启基于注解的缓存
@EnableRabbit  //开启基于注解的RabbitMQ
@SpringBootApplication
@EnableSwagger2
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}