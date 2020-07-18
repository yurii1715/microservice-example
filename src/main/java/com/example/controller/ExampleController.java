package com.example.controller;

import com.example.entity.Example;
import com.example.repository.ExampleRepository;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

  @Autowired
  private ExampleRepository repository;

  @GetMapping
  public Iterable<Example> getAll() {
    return repository.findAll();
  }

  @PostMapping
  public Iterable<Example> createTestData() {
    return repository.saveAll(Stream.of("name1", "name2", "name3", "name4")
        .map(Example::new)
        .collect(Collectors.toList()));
  }
}
