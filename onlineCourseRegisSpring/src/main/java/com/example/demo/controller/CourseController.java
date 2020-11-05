package com.example.demo.controller;


import com.example.demo.constant.GlobalConstant;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping(value = "/courses")
    public BaseResponse getCourses(){
        List<Course> course= courseService.getCourses();
        return new BaseResponse(GlobalConstant.success, course, GlobalConstant.Message.success_message);
    }

    @PostMapping(value = "/course")
    public BaseResponse createCourse(@RequestBody Course course){
        try {
            course = courseService.addCourse(course);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, course, GlobalConstant.Message.success_message);

    }
}
