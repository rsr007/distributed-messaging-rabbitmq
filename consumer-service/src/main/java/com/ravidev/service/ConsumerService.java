package com.ravidev.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @RabbitListener(queues = "q1")
    public void receiveData(String msg) {
        System.out.println("Getting data from direct-exchange from q1");
        System.out.println(msg);
    }
}
