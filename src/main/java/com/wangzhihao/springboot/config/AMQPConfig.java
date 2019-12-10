package com.wangzhihao.springboot.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AMQPConfig
 * @Description TODO
 * @Author wangzhihao
 * @Date 19/12/10 22:26
 * @Version 1.0
 **/
@Configuration
public class AMQPConfig{
    /**
    *@Author wangzhihao
    *@Description 替换掉AMQP默认的序列化方式
    *@Date 22:29 19/12/10
    *@Param []
    *@return org.springframework.amqp.support.converter.MessageConverter
    **/
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
