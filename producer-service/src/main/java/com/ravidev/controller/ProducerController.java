package com.ravidev.controller;

import com.ravidev.Model.Student;
import com.ravidev.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class ProducerController {

    @Autowired
    ProduceService produceService;

    @PostMapping(value="/direct")
    public ResponseEntity<String> sendDataViaDirectExchange(@RequestBody Student student){
        String msg = String.format("you are using direct-exchange, %s", student.getName());
        produceService.sendDirectExchangeData(msg);
        return ResponseEntity.ok("Message sent using direct exchange");
    }

    @PostMapping(value="/topic")
    public ResponseEntity<String> sendDataViaTopicExchange(@RequestBody Student student){
        String msg = String.format("you are using topic-exchange, %s", student.getName());
        produceService.sendTopicExchangeData(msg);
        return ResponseEntity.ok("Message sent using topic exchange");
    }

    @PostMapping(value="/fanout")
    public ResponseEntity<String> sendDataViaFanoutExchange(@RequestBody Student student){
        String msg = String.format("you are using fanout-exchange, %s", student.getName());
        produceService.sendFanoutExchangeData(msg);
        return ResponseEntity.ok("Message sent using fanout exchange");
    }

    @PostMapping(value="/header")
    public ResponseEntity<String> sendDataViaHeaderExchange(@RequestBody Student student){
        String msg = String.format("you are using header-exchange, %s", student.getName());
        produceService.sendHeadersExchangeData(msg);
        return ResponseEntity.ok("Message sent using header exchange");
    }
}
