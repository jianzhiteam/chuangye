package com.mycode.jiaoxuepingjia.xspj.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther kexiangwei
 * @date 2019/10/8
 */

@Getter
@Setter
public class Template {

    //分页参数
    @JsonIgnore
    private Integer pageIndex=1
            ,pageSize=10;

    private String code,name
            ,content
            ,type;
    private Integer score,idx;
}
