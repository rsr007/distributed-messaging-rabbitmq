package com.ravidev.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduceService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendData(String data) {
        rabbitTemplate.convertAndSend("direct-exchange", "q1.key", data);
    }
}
