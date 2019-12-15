package com.mycode.jiaoxuepingjia.xspj.service;

import com.mycode.jiaoxuepingjia.xspj.domain.Target;
import com.mycode.jiaoxuepingjia.xspj.domain.Template;
import com.mycode.jiaoxuepingjia.xspj.domain.Course;
import com.mycode.jiaoxuepingjia.xspj.domain.XspjSet;

import java.util.List;
import java.util.Map;

/**
 * @auther kexiangwei
 * @date 2019/10/8
 */
public interface XspjService {

    Map<String, Object> getXspjSetPage(XspjSet xspjSet);

    Map<String, Object> getXspjTemplatePage(Template template);

    List<Template> getXspjTemplateList();
    
    Map<String, Object> getXspjTargetPage(Target target);
    
    List<Target> getXspjTargetList();

    Map<String, Object> getXspjCoursePage(Course course);

    Map<String, Object> getXspjTemplateMap();

	boolean saveOrUpdateSet(XspjSet xspjSet);

	boolean deleteSet(String code);

	boolean saveOrUpdateTemplate(Template template);

	boolean deleteTemplate(String code);

	boolean saveOrUpdateTarget(Target target);

	boolean deleteTarget(String code);

	XspjSet getXspjSet(String code);

	Target getXspjTarget(String code);

	Template getXspjTemplate(String code);

	Map<String, Object> getCoursePage(Course course);
}
