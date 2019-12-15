package com.mycode.jiaoxuepingjia.xspj.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycode.jiaoxuepingjia.xspj.domain.Course;
import com.mycode.jiaoxuepingjia.xspj.domain.EvaluationAssessor;
import com.mycode.jiaoxuepingjia.xspj.service.EvaluationAssessorService;
import com.mycode.util.JsonResult;

/**
 * 学生评教
 */
@CrossOrigin
@Controller
@RequestMapping("/evaluation/studentEvaluation")
public class StudentEvaluationController {

	@Autowired
	private EvaluationAssessorService evaluationAssessorService;

	@ResponseBody
	@RequestMapping("/getPage.do")
	public JsonResult<Object> getPage(Course course) {
		Map<String, Object> resultMap = evaluationAssessorService.getCoursePage(course);
		return JsonResult.success(resultMap);
	}

	@ResponseBody
	@RequestMapping("/getDetail.do")
	public JsonResult<Object> get(@RequestParam("code") String code) {
		EvaluationAssessor evaluationAssessor = evaluationAssessorService.get(code);
		return JsonResult.success(evaluationAssessor);
	}

	@ResponseBody
	@RequestMapping("/saveOrUpdate.do")
	public JsonResult<Object> saveOrUpdate(EvaluationAssessor evaluationAssessor) {
		boolean bool = evaluationAssessorService.saveOrUpdate(evaluationAssessor);
		if (!bool) {
			return JsonResult.error();
		}
		return JsonResult.success();
	}

	@ResponseBody
	@RequestMapping("/delete.do")
	public JsonResult<Object> delete(@RequestParam("codes") String codes) {
		try {
			evaluationAssessorService.delete(codes);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error("删除失败");
		}
		return JsonResult.success("删除成功");
	}

}
