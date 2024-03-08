package com.study.mvc.controller;


import com.study.mvc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @GetMapping("/ex/students")
    public ResponseEntity<?> students() {
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @GetMapping("/ex/student/{index}")
    public ResponseEntity<?> student(@PathVariable int index) {
        return ResponseEntity.ok(studentService.getStudent(index));
    }

//    @Autowired
//    private StudentService studentService;
//
//    @GetMapping("/ex/students")
//    public List<String> studentListAll () {
//        System.out.println(studentService.getStudentList());
//        return studentService.getStudentList();
//
//    }



}

