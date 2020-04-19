package com.example.repository;

import com.example.entity.ComputerMonitor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComputerMonitorRepository extends MongoRepository<ComputerMonitor, String> { }
