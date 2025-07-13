package com.ravidev.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    DirectExchange directExchange(){
        return ExchangeBuilder
                .directExchange("direct-exchange")
                .build();
    }
    @Bean
    Queue queue1(){
        return QueueBuilder.durable("q1").build();
    }
    @Bean
    Queue queue2(){
        return QueueBuilder.durable("q2").build();
    }
    @Bean
    Binding bindQueue(@Qualifier("queue1")Queue queue1, DirectExchange directExchange){
        return BindingBuilder.bind(queue1)
                .to(directExchange)
                .with("q1.key");
    }
}
