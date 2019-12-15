package com.mycode.jiaoxuepingjia.xspj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mycode.jiaoxuepingjia.xspj.domain.Course;
import com.mycode.jiaoxuepingjia.xspj.domain.EvaluationAssessor;

@Mapper
public interface EvaluationAssessorMapper {

	List<EvaluationAssessor> getPage(EvaluationAssessor evaluationAssessor);

	boolean insert(EvaluationAssessor evaluationAssessor);

	@Delete("delete from BASE_EVALUATION_ASSESSOR where code = #{code}")
	boolean delete(@Param("code") String code);

	boolean update(EvaluationAssessor evaluationAssessor);

	@Select("select * from BASE_EVALUATION_ASSESSOR where code = #{code}")
	EvaluationAssessor get(@Param("code") String code);

	@Select("select * from BASE_EVALUATION_ASSESSOR where STUDENT_CODE = #{studentCode} and COURSE_CODE = #{courseCode} and ALLOCATION_CODE = #{allocationCode}")
	EvaluationAssessor getEvaluationAssessor(@Param("studentCode") String studentCode,
			@Param("courseCode") String courseCode, @Param("allocationCode") String allocationCode);

	@Select("SELECT c.*,ea.ALLOCATION_CODE from BASE_EVALUATION_ASSESSOR ea LEFT JOIN DATA_COURSE c on c.CODE = ea.COURSE_CODE where ea.STUDENT_CODE = #{studentCode}")
	List<Course> getCoursePage(@Param("studentCode") String studentCode);

	@Insert("insert into DATA_STUDENT_COURSE (STUDENT_CODE,COURSE_CODE) values (#{studentCode},#{courseCode})")
	EvaluationAssessor insertStudentCourse(@Param("studentCode") String studentCode,
			@Param("courseCode") String courseCode);
}
