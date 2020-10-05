package com.intern.test.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intern.test.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	
	//List<Teacher> findByNameOrDepartmentOrAddressOrPhone(String name,String department,String address,String phone);
	
	@Query (value = "Select t from Teacher t where t.name like concat('%',concat(?1,'%'))"
			+ "and t.department like concat('%',concat(?2,'%'))"
			+ "and t.address like concat('%',concat(?3,'%'))"
			+ "and t.phone like concat('%',concat(?4,'%'))")
	List<Teacher> searchTeacher(String name,String department,String address,String phone);
		
}
