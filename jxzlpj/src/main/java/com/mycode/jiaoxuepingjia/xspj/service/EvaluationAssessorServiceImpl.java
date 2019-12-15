package com.mycode.jiaoxuepingjia.xspj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mycode.jiaoxuepingjia.xspj.domain.Course;
import com.mycode.jiaoxuepingjia.xspj.domain.EvaluationAssessor;
import com.mycode.jiaoxuepingjia.xspj.mapper.EvaluationAssessorMapper;
import com.mycode.util.CodeUtil;

@Service
public class EvaluationAssessorServiceImpl implements EvaluationAssessorService {

	@Autowired
	private EvaluationAssessorMapper evaluationAssessorMapper;

	@Override
	public Map<String, Object> getPage(EvaluationAssessor evaluationAssessor) {
		Map<String, Object> resultMap = new HashMap<>();
		Page<Object> pageInfo = PageHelper.startPage(evaluationAssessor.getPageIndex(),
				evaluationAssessor.getPageSize());
		List<EvaluationAssessor> pageList = evaluationAssessorMapper.getPage(evaluationAssessor);
		resultMap.put("totalNum", pageInfo.getTotal());
		resultMap.put("pageList", pageList);
		return resultMap;
	}

	@Override
	public Map<String, Object> getCoursePage(Course course) {
		Map<String, Object> resultMap = new HashMap<>();
		Page<Object> pageInfo = PageHelper.startPage(course.getPageIndex(), course.getPageSize());
		List<Course> pageList = evaluationAssessorMapper.getCoursePage(course.getUserId());
		resultMap.put("totalNum", pageInfo.getTotal());
		resultMap.put("pageList", pageList);
		return resultMap;
	}

	@Override
	public boolean saveOrUpdate(EvaluationAssessor evaluationAssessor) {
		EvaluationAssessor oldEvaluationAssessor = evaluationAssessorMapper.getEvaluationAssessor(
				evaluationAssessor.getStudentCode(), evaluationAssessor.getCourseCode(),
				evaluationAssessor.getAllocationCode());
		if (null != oldEvaluationAssessor) {
			return false;
		}
		evaluationAssessor.setCode(CodeUtil.randomChar(16, true));
		return evaluationAssessorMapper.insert(evaluationAssessor);
	}

	@Override
	public void delete(String codes) {
		for (String code : codes.split(",")) {
			evaluationAssessorMapper.delete(code);
		}
	}

	@Override
	public EvaluationAssessor get(String code) {
		return evaluationAssessorMapper.get(code);
	}

	@Override
	public void importData(List<EvaluationAssessor> assessors) {
		List<EvaluationAssessor> oldAssessors = evaluationAssessorMapper.getPage(null);
		Map<String, String> oldAssessorMap = new HashMap<>();
		for (EvaluationAssessor evaluationAssessor : oldAssessors) {
			oldAssessorMap.put(evaluationAssessor.getStudentCode() + "." + evaluationAssessor.getCourseCode() + "."
					+ evaluationAssessor.getAllocationCode(), evaluationAssessor.getCode());
		}
		for (EvaluationAssessor assessor : assessors) {
			String key = assessor.getStudentCode() + "." + assessor.getCourseCode() + "."
					+ assessor.getAllocationCode();
			if (StringUtils.isEmpty(oldAssessorMap.get(key))) {
				evaluationAssessorMapper.insert(assessor);
				continue;
			}
			assessor.setCode(oldAssessorMap.get(key));
			evaluationAssessorMapper.update(assessor);
		}
	}

}
