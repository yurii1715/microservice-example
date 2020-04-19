package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka")
public interface EurekaFeignClient {

  @GetMapping("/")
  public String getHomePage();
}
