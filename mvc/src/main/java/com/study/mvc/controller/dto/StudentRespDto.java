package com.study.mvc.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class StudentRespDto {
    private  String name;
    private  int age;
    private  String phone;
    private  String address;
}
