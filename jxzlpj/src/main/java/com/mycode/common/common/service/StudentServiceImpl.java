package com.mycode.common.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mycode.common.common.domain.Student;
import com.mycode.common.common.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public Map<String, Object> getPage(Student student) {
		Map<String, Object> resultMap = new HashMap<>();
		Page<Object> pageInfo = PageHelper.startPage(student.getPageIndex(), student.getPageSize());
		List<Student> pageList = studentMapper.getPage(student);
		resultMap.put("totalNum", pageInfo.getTotal());
		resultMap.put("pageList", pageList);
		return resultMap;
	}

	@Override
	public Student get(String code) {
		return studentMapper.get(code);
	}

	@Override
	public List<Student> getList(Student student) {
		return studentMapper.getPage(student);
	}

}
