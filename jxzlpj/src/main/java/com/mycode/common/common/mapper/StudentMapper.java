package com.mycode.common.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mycode.common.common.domain.Student;

@Mapper
public interface StudentMapper {

	List<Student> getPage(Student student);

	@Select("select * from DATA_STUDENT where code = #{code}")
	Student get(String code);
}
