package com.ravidev.controller;

import com.ravidev.Model.Student;
import com.ravidev.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    ProduceService produceService;

    @PostMapping(value="/produce/")
    public ResponseEntity<String> sendData(@RequestBody Student student){
        String msg = "Info for user: " + student.getName();
        produceService.sendData(msg);
        return ResponseEntity.ok(msg);
    }
}
