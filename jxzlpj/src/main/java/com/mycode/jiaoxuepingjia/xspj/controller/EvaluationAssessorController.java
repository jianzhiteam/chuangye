package com.mycode.jiaoxuepingjia.xspj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mycode.jiaoxuepingjia.xspj.domain.EvaluationAssessor;
import com.mycode.jiaoxuepingjia.xspj.service.EvaluationAssessorService;
import com.mycode.util.CodeUtil;
import com.mycode.util.JsonResult;

/**
 * 评估人设置
 */
@CrossOrigin
@Controller
@RequestMapping("/evaluation/evaluationAssessor")
public class EvaluationAssessorController {

	@Autowired
	private EvaluationAssessorService evaluationAssessorService;

	@ResponseBody
	@RequestMapping("/getPage.do")
	public JsonResult<Object> getPage(EvaluationAssessor evaluationAssessor) {
		Map<String, Object> resultMap = evaluationAssessorService.getPage(evaluationAssessor);
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

	@ResponseBody
	@RequestMapping("/importData.do")
	public JsonResult<Object> importData(@RequestParam MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		// 判断文件是否为空
		if (file == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取文件名
		String name = file.getOriginalFilename();

		// 判断文件大小、即名称
		long size = file.getSize();
		if (name == null || ("").equals(name) && size == 0)
			return null;

		try {
			Workbook workbook = null;
			if (file.getOriginalFilename().endsWith("xls")) {
				System.out.println("这是2003版本");
				workbook = new HSSFWorkbook(file.getInputStream());
			} else if (file.getOriginalFilename().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(file.getInputStream());
				System.out.println("这是2007版本");
			}
			// 获取第一个张表
			Sheet sheet = workbook.getSheetAt(0);
			List<EvaluationAssessor> assessors = new ArrayList<>();
			EvaluationAssessor assessor = null;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i); // 获取行
				assessor = new EvaluationAssessor();
				assessor.setCode(CodeUtil.randomChar(16, true));
				assessor.setStudentCode(row.getCell(0).toString());
				assessor.setStudentName(row.getCell(1).toString());
				assessor.setCourseCode(row.getCell(2).toString());
				assessor.setCourseName(row.getCell(3).toString());
				assessor.setAllocationCode(row.getCell(4).toString());
				assessor.setAllocationName(row.getCell(5).toString());
				assessors.add(assessor);
			}
			evaluationAssessorService.importData(assessors);
		} catch (IOException e) {
			e.printStackTrace();
			return JsonResult.error("导入失败");
		}
		return JsonResult.success("导入成功");
	}
}
