package com.example.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@Builder
@JsonSerialize
@AllArgsConstructor
public class ComputerMonitor implements Serializable {

    @Id
    private String id;

    private String name;
    private String manufacturer;
}
