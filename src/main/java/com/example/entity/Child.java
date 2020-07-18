package com.example.entity;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public class Child implements Parent {

  @Override
  @Transactional
  public List<Integer> getValues() {
    return null;
  }
}
