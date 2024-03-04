package com.study.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller명 StudentController
 *
 * 메소드명: getStudentInfo()
 * 요청메소드: Get
 * 요청  URL: /student
 * 요청 Params: name, age, phone, address
 * 응답데이터: JSON(name, age, phone, address)
 */

@RestController
public class StudyRestController {

    @GetMapping("/hello/test")
    public String hello(String name, String age) {

        System.out.println(name);
        System.out.println(age);

        return  "Hello";

    }

}
