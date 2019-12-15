package com.mycode.jiaoxuepingjia.xspj.service;

import java.util.List;
import java.util.Map;

import com.mycode.jiaoxuepingjia.xspj.domain.Course;
import com.mycode.jiaoxuepingjia.xspj.domain.EvaluationAssessor;

public interface EvaluationAssessorService {

	Map<String, Object> getPage(EvaluationAssessor evaluationAssessor);

	boolean saveOrUpdate(EvaluationAssessor evaluationAssessor);

	void delete(String code);

	EvaluationAssessor get(String code);

	void importData(List<EvaluationAssessor> assessors);

	Map<String, Object> getCoursePage(Course course);

}
