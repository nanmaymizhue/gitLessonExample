package com.example.demo.controller;


import com.example.demo.constant.GlobalConstant;
import com.example.demo.entity.Course;
import com.example.demo.entity.Department;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.CourseService;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    CourseService courseService;

    @GetMapping(value = "/departments")
    public BaseResponse getDepartments() {
        List<Department> department = departmentService.getDepartments();
        return new BaseResponse(GlobalConstant.success, department, GlobalConstant.Message.success_message);
    }

    @PostMapping (value = "/department")
    public Department createEmployee(@RequestBody Department department){

        Collection<Course> courses= department.getCourses();
        if(courses !=null){
            courses = courseService.saveAll(courses);
        }

        for(Course course : courses){
            department.addCourse(course);
        }

        return departmentService.save(department);
    }


}
