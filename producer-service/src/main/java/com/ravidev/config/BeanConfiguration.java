package com.ravidev.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    /**
     * DirectExchange bean creation
     * @return object of DirectExchange
     */
    @Bean
    DirectExchange directExchange(){
        return ExchangeBuilder
                .directExchange("direct-exchange")
                .build();
    }

    /**
     * Topic exchange bean creation
     * @return object of TopicExchange
     */
    @Bean
    TopicExchange topicExchange(){
        return ExchangeBuilder
                .topicExchange("topic-exchange")
                .build();
    }

    /**
     * Fanout exchange bean creation
     * @return object of TopicExchange
     */
    @Bean
    FanoutExchange fanoutExchange(){
        return ExchangeBuilder
                .fanoutExchange("fanout-exchange")
                .build();
    }

    /**
     * Headers exchange bean creation
     * @return object of TopicExchange
     */
    @Bean
    HeadersExchange headerExchange(){
        return ExchangeBuilder
                .headersExchange("header-exchange")
                .build();
    }

    @Bean(name = "queue1")
    Queue queue1() {
        return QueueBuilder.durable("q1").build();
    }

    @Bean(name = "queue2")
    Queue queue2() {
        return QueueBuilder.durable("q2").build();
    }

    @Bean(name = "queue3")
    Queue queue3() {
        return QueueBuilder.durable("q3").build();
    }

    @Bean(name = "queue4")
    Queue queue4() {
        return QueueBuilder.durable("q4").build();
    }

    @Bean(name = "queue5")
    Queue queue5() {
        return QueueBuilder.durable("q5").build();
    }

    /**
     * Binding queue1 with direct exchange
     * @param queue1 name of the queue
     * @param directExchange exchange to bind
     * @return binding object
     */
    @Bean
    Binding bindDirectExchange(@Qualifier(value = "queue1") Queue queue1, DirectExchange directExchange){
        return BindingBuilder.bind(queue1)
                .to(directExchange)
                .with("q1.key");
    }

    @Bean
    Binding bindTopicExchange1(@Qualifier(value = "queue2") Queue queue2, TopicExchange topicExchange){
        return BindingBuilder.bind(queue2)
                .to(topicExchange)
                .with("q1.key");
    }

    @Bean
    Binding bindTopicExchange2(@Qualifier(value = "queue3") Queue queue3, TopicExchange topicExchange){
        return BindingBuilder.bind(queue3)
                .to(topicExchange)
                .with("q1.#");
    }

    @Bean
    Binding bindFanoutExchange(@Qualifier(value = "queue3") Queue queue3, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue3)
                .to(fanoutExchange);
    }
    @Bean
    Binding bindFanoutExchange2(@Qualifier(value = "queue4") Queue queue4, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue4)
                .to(fanoutExchange);
    }

    @Bean
    Binding bindHeadersExchange(@Qualifier(value = "queue5") Queue queue5, HeadersExchange headersExchange){
        return BindingBuilder.bind(queue5)
                .to(headersExchange)
                .where("q5.key")
                .matches("value");
    }
}
