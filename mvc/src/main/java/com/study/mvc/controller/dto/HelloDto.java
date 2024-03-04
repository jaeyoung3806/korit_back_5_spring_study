package com.study.mvc.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class HelloDto {
    private String name;
    private int age;
}
