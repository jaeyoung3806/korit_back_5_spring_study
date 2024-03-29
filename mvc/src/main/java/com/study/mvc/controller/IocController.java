package com.study.mvc.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.mvc.diAndIoc.IocService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class IocController {

    private final IocService iocService;

    @GetMapping("/ioc")
    public ResponseEntity<?> iocTest() throws JsonProcessingException {
        String json = iocService.getJson(); //

        return ResponseEntity.ok(json);
    }
}
