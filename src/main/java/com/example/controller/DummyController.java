package com.example.controller;

import com.example.feign.EurekaFeignClient;
import com.example.repository.ComputerMonitorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    private EurekaFeignClient eurekaFeignClient;

    @GetMapping("/eureka")
    public String getString() {
        return eurekaFeignClient.getHomePage();
    }
}
