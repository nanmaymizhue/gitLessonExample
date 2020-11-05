package com.example.demo.controller;

import com.example.demo.constant.GlobalConstant;
import com.example.demo.entity.Student;
import com.example.demo.pojo.StudentPojo;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.*;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    public BaseResponse getStudent(){
       List<Student> student= studentService.getStudent();
       return new BaseResponse(GlobalConstant.success, student, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/student/{id}")
    public BaseResponse getById(@PathVariable Long id){
        Student student = studentService.findById(id);
        return new BaseResponse(GlobalConstant.success, student, GlobalConstant.Message.success_message);
    }

    @PostMapping(value = "/student")
    public BaseResponse createStudent(@RequestBody Student student){
        try {
           student = studentService.addStudent(student);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, student, GlobalConstant.Message.success_message);

    }

    @DeleteMapping(value="/student/{id}")
    public BaseResponse deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }

    @PutMapping (value = "/student")
    public BaseResponse updateStudent(@RequestBody StudentPojo studentPojo) {

        System.out.println(studentPojo.getName());
        System.out.println(studentPojo.getEmail());

        Student student = studentService.findById(studentPojo.getId());
        System.out.println("This is student id" + student);
        if(student==null) {
            return null;
        }
        student.setName(studentPojo.getName());
        student.setEmail(studentPojo.getEmail());
        student.setPhone(studentPojo.getPhone());
        student.setBirthDate(studentPojo.getBirthDate());
        student.setAddress(studentPojo.getAddress());
        Student students = studentService.save(student);

        return new BaseResponse(GlobalConstant.success, students,GlobalConstant.Message.success_message);

    }
}
