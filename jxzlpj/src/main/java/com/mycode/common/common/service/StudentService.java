package com.mycode.common.common.service;

import java.util.List;
import java.util.Map;

import com.mycode.common.common.domain.Student;

public interface StudentService {

	Map<String, Object> getPage(Student student);

	Student get(String code);

	List<Student> getList(Student student);

}
