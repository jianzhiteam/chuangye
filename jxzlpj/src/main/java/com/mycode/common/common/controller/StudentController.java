package com.mycode.common.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycode.common.common.domain.Student;
import com.mycode.common.common.service.StudentService;
import com.mycode.util.JsonResult;

/**
 * 学生
 */
@CrossOrigin
@Controller
@RequestMapping("/common/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@ResponseBody
	@RequestMapping("/getPage.do")
	public JsonResult<Object> getPage(Student student) {
		Map<String, Object> resultMap = studentService.getPage(student);
		return JsonResult.success(resultMap);
	}

	@ResponseBody
	@RequestMapping("/getList.do")
	public JsonResult<Object> getList(Student student) {
		return JsonResult.success(studentService.getList(student));
	}

	@ResponseBody
	@RequestMapping("/getDetail.do")
	public JsonResult<Object> get(@RequestParam("code") String code) {
		Student student = studentService.get(code);
		return JsonResult.success(student);
	}

}
