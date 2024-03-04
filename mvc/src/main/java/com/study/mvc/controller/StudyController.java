package com.study.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class StudyController {

    //MVC
    @GetMapping("/hello")
    public ModelAndView helloPage() {
        Map<String, Object> model = new HashMap<>();
        model.put("name1", "김준일");
        model.put("name2", "김준이");
        model.put("name3", "김준삼");
        return new ModelAndView("hello", model);
    }

    //REST
    @GetMapping("/test")
    @ResponseBody
    public Map<String, Object> testPage() {

        Map<String, Object> testObj = new HashMap<>();
        testObj.put("age", 32);
        return testObj;
    }

}
