package com.ravidev.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduceService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendDirectExchangeData(String data) {
        rabbitTemplate.convertAndSend("direct-exchange", "q1.key", data);
    }

    public void sendTopicExchangeData(String data) {
        rabbitTemplate.convertAndSend("topic-exchange", "q1.#", data);
    }

    public void sendFanoutExchangeData(String data) {
        rabbitTemplate.convertAndSend("fanout-exchange", "q1.*", data);
    }
    public void sendHeadersExchangeData(String data) {
        MessageProperties messageProperties = new MessageProperties();
        //key value here must match the one used in config to bind
        messageProperties.setHeader("q5.key","value");
        Message message = new Message(data.getBytes(),messageProperties);
        rabbitTemplate.send("header-exchange", "", message);
    }
}
