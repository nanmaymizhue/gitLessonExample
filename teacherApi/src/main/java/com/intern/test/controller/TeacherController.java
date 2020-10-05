package com.intern.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.test.constant.GlobalConstant;
import com.intern.test.entity.Teacher;
import com.intern.test.pojo.TeacherPojo;
import com.intern.test.response.BaseResponse;
import com.intern.test.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	
	TeacherService teacherService;
	
	@GetMapping(value="/teacher")
	public  BaseResponse getTeacher() {
		List<Teacher> teachers = teacherService.getTeacher();
		return new BaseResponse(GlobalConstant.SUCCESS, teachers, GlobalConstant.Message.SUCCESS_MESSAGE);
	}
	
	@PostMapping(value="/teacher")
	public BaseResponse addTeacher(@RequestBody Teacher teacher) {
		try{
			teacher = teacherService.addTeacher(teacher);
		}catch(Exception e) {
			System.out.println("Error occur "+e.getMessage());
			return new BaseResponse(GlobalConstant.FAIL, null,GlobalConstant.Message.FAIL_MESSAGE);
			
		}
		return new BaseResponse(GlobalConstant.SUCCESS, teacher,GlobalConstant.Message.SUCCESS_MESSAGE);
	}
	
	@GetMapping(value="/teacher/{id}")
	public Teacher getById(@PathVariable Long id) {
		return teacherService.findById(id);
	}
	
	@DeleteMapping(value="/teacher/{id}")
	public void deleteById(@PathVariable Long id) {
		teacherService.deleteTeacher(id);
	}
	
	@GetMapping(value="/teacher/search")
	public List<Teacher> searchForTeacher(@RequestParam String name,String department,String address,String phone){
		return teacherService.teacherSearch(name,department,address,phone);
	}
	
	@PutMapping(value="/teacher")
	public Teacher updateTeacher(@RequestBody TeacherPojo teacherPojo) {
		Teacher teacher=teacherService.findById(teacherPojo.getId());
		if(teacher==null) {
			return null;
		}
		teacher.setName(teacherPojo.getName());
		teacher.setDepartment(teacherPojo.getDepartment());
		teacher.setAddress(teacherPojo.getAddress());
		teacher.setEmail(teacherPojo.getEmail());
		return teacherService.save(teacher);
	}
	
}
