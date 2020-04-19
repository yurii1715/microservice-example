package com.example.controller;

import com.example.feign.EurekaFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @Autowired
    private EurekaFeignClient eurekaFeignClient;

    @GetMapping("/eureka")
    public String getString() {
        return eurekaFeignClient.getLastStarts();
    }
}
