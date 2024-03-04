package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.controller.dto.StudentReqDto;
import com.study.mvc.controller.entity.Student;
import org.apache.tomcat.util.http.parser.Cookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@CookieValue String students, @RequestBody Student student) throws JsonProcessingException {
        List<Student> studentList = new ArrayList<>();
        int lastId = 0;

        if(students != null) {
            if(students.isBlank()) {
                ObjectMapper studentsCookie = new ObjectMapper();
                studentList = studentsCookie.readValue(students, List.class);
                lastId = studentList.get(studentList.size() -1).getStudentId();
            }
        }

        student.setStudentId(lastId + 1);
        studentList.add(student);

        ObjectMapper newStudentList = new ObjectMapper();
        String newStudent = newStudentList.writeValueAsString(studentList);
        ResponseCookie responseCookie = ResponseCookie
                .from("test", "test_data")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(60)
                .domain("localhost:8080")
                .build();

        // ("")문자 저장 x

        return ResponseEntity
                .created(null)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(student);
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudentInfo (StudentReqDto studentReqDto) {
        System.out.println(studentReqDto);

        return ResponseEntity.ok().body(studentReqDto.toRespDto());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable int studentId) {
        List<Student> studentList = List.of(
                new Student(1, "김준일"),
                new Student(2, "김준이"),
                new Student(3, "김준삼"),
                new Student(4, "김준사")
        );

        Student findStudent = null;
        for(Student student : studentList) {
            if(student.getStudentId() == studentId) {
                findStudent = student;
            }
        }
        Optional<Student> optionalStudent =
                studentList.stream().filter(student -> student.getStudentId() == studentId).findFirst();

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 ID입니다."));
        }
        findStudent = optionalStudent.get();
//--------------------------------------------------------------------------------------------------------------
        if (findStudent == null) {
            return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 ID입니다."));
        }
        return ResponseEntity.ok().body(findStudent);
    }
}
