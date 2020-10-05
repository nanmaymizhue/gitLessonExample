package com.intern.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.test.entity.Teacher;
import com.intern.test.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	
	TeacherRepository teacherRepository;
	
	public List<Teacher> getTeacher() {
		return teacherRepository.findAll();
	}

	public Teacher addTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public Teacher findById(Long id) {
		return teacherRepository.findById(id).orElse(null);		
	}

	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
		
	}
	
	public List<Teacher> teacherSearch(String name,String department,String address,String phone){
		return teacherRepository.searchTeacher(name,department,address,phone);
		
	}

	public Teacher save(Teacher teacher) {
		return teacherRepository.save(teacher);
	}


}
