package com.example.repository;

import com.example.entity.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends CrudRepository<Example, String> { }
