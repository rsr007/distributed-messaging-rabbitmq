package com.ravidev.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @RabbitListener(queues = "q1")
    public void receiveDataOnQueue1(String msg) {
        System.out.println(String.format("Getting data on q1: %s",msg));
    }

    @RabbitListener(queues = "q2")
    public void receiveDataOnQueue2(String msg) {
        System.out.println(String.format("Getting data on q2: %s",msg));
    }

    @RabbitListener(queues = "q3")
    public void receiveDataOnQueue3(String msg) {
        System.out.println(String.format("Getting data on q3: %s",msg));
    }

    @RabbitListener(queues = "q4")
    public void receiveDataOnQueue4(String msg) {
        System.out.println(String.format("Getting data on q4: %s",msg));
    }

    @RabbitListener(queues = "q5")
    public void receiveDataOnQueue5(String msg) {
        System.out.println(String.format("Getting data on q5: %s",msg));
    }
}
