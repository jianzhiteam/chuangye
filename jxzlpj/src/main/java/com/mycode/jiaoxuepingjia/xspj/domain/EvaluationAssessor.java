package com.mycode.jiaoxuepingjia.xspj.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvaluationAssessor {

	// 分页参数
	@JsonIgnore
	private Integer pageIndex = 1, pageSize = 10;
	// 查询字段
	private String userId;

	// 业务字段
	private String code, studentCode, studentName, courseCode, courseName, allocationCode, allocationName;
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate, lastModifyDate;

}
