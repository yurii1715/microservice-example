package com.example.controller;

import com.example.entity.ComputerMonitor;
import com.example.repository.ComputerMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/monitor")
public class ComputerMonitorController {

    @Autowired
    private ComputerMonitorRepository repository;

    @GetMapping("/")
    public List<ComputerMonitor> getAll() {
        return repository.findAll();
    }

    @PostMapping("/test")
    public ResponseEntity<List<ComputerMonitor>> createTestData() {
        return ResponseEntity.ok(repository.saveAll(
                Arrays.asList(
                    ComputerMonitor.builder()
                        .name("SV1")
                        .manufacturer("Samsung")
                        .build(),
                    ComputerMonitor.builder()
                        .name("SV2")
                        .manufacturer("Samsung")
                        .build(),
                    ComputerMonitor.builder()
                        .name("LGV1")
                        .manufacturer("LG")
                        .build()
                )
        ));
    }
}
