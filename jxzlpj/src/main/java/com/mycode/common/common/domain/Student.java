package com.mycode.common.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

	// 分页参数
	@JsonIgnore
	private Integer pageIndex = 1, pageSize = 10;

	// 业务字段
	private String code, name, sex, cardType, cardNum, entranceDate, classCode, className, majorName, collegeName;

}
