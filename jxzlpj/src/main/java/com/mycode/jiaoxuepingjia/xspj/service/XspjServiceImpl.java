package com.mycode.jiaoxuepingjia.xspj.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mycode.jiaoxuepingjia.xspj.domain.Target;
import com.mycode.jiaoxuepingjia.xspj.domain.Template;
import com.mycode.jiaoxuepingjia.xspj.domain.Course;
import com.mycode.jiaoxuepingjia.xspj.domain.XspjSet;
import com.mycode.jiaoxuepingjia.xspj.mapper.XspjMapper;
import com.mycode.util.CodeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @auther kexiangwei
 * @date 2019/10/8
 */
@Service
public class XspjServiceImpl implements XspjService {

    @Autowired
    private XspjMapper xspjMapper;

    @Override
    public Map<String, Object> getXspjSetPage(XspjSet xspjSet) {
        Map<String, Object> resultMap = new HashMap<>();
        Page<Object> pageInfo = PageHelper.startPage(xspjSet.getPageIndex(), xspjSet.getPageSize());
        List<XspjSet> pageList = xspjMapper.getXspjSetPage(xspjSet);
        resultMap.put("totalNum",pageInfo.getTotal());
        resultMap.put("pageList", pageList);
        return resultMap;
    }

    @Override
    public Map<String, Object> getXspjTemplatePage(Template template) {
        Map<String, Object> resultMap = new HashMap<>();
        Page<Object> pageInfo = PageHelper.startPage(template.getPageIndex(), template.getPageSize());
        List<Template> pageList = xspjMapper.getXspjTemplatePage();
        resultMap.put("totalNum",pageInfo.getTotal());
        resultMap.put("pageList", pageList);
        return resultMap;
    }

    @Override
	public List<Template> getXspjTemplateList() {
        return xspjMapper.getXspjTemplateList();
	}

	@Override
	public Map<String, Object> getXspjTargetPage(Target target) {
        Map<String, Object> resultMap = new HashMap<>();
        Page<Object> pageInfo = PageHelper.startPage(target.getPageIndex(), target.getPageSize());
        List<Target> pageList = xspjMapper.getXspjTargetPage();
        resultMap.put("totalNum",pageInfo.getTotal());
        resultMap.put("pageList", pageList);
        return resultMap;
	}

	@Override
    public List<Target> getXspjTargetList() {
        return xspjMapper.getXspjTargetList();
    }

    @Override
    public Map<String, Object> getXspjCoursePage(Course course) {
        Map<String, Object> resultMap = new HashMap<>();
        Page<Object> pageInfo = PageHelper.startPage(course.getPageIndex(), course.getPageSize());
        List<Course> pageList = xspjMapper.getXspjCoursePage(course);
        resultMap.put("totalNum",pageInfo.getTotal());
        resultMap.put("pageList", pageList);
        return resultMap;
    }

    @Override
    public Map<String, Object> getXspjTemplateMap() {
        Map<String, Object> resultMap = new HashMap<>();
        List<Target> targets = xspjMapper.getXspjTargetListByTemplateCode();
        List<Target> teacherTargets = targets.stream().filter(t -> t.getType().equals("teacher")).collect(Collectors.toList());
        List<Target> myselfTargets = targets.stream().filter(t -> t.getType().equals("myself")).collect(Collectors.toList());
        resultMap.put("teacherTargets",teacherTargets);
        resultMap.put("myselfTargets",myselfTargets);
        return resultMap;
    }

	@Override
	public boolean saveOrUpdateSet(XspjSet xspjSet) {
		if(!StringUtils.isEmpty(xspjSet.getCode())){
	        return xspjMapper.updateSet(xspjSet);
		}
		xspjSet.setCode(CodeUtil.randomChar(16,true));
        return xspjMapper.insertSet(xspjSet);
	}

	@Override
	public boolean deleteSet(String code) {
        return xspjMapper.deleteSet(code);
	}
	@Override
	public boolean saveOrUpdateTemplate(Template template) {
		if(!StringUtils.isEmpty(template.getCode())){
	        return xspjMapper.updateTemplate(template);
		}
		template.setCode(CodeUtil.randomChar(16,true));
        return xspjMapper.insertTemplate(template);
	}

	@Override
	public boolean deleteTemplate(String code) {
        return xspjMapper.deleteTemplate(code);
	}
	@Override
	public boolean saveOrUpdateTarget(Target target) {
		if(!StringUtils.isEmpty(target.getCode())){
	        return xspjMapper.updateTarget(target);
		}
		target.setCode(CodeUtil.randomChar(16,true));
        return xspjMapper.insertTarget(target);
	}

	@Override
	public boolean deleteTarget(String code) {
        return xspjMapper.deleteTarget(code);
	}

	@Override
	public XspjSet getXspjSet(String code) {
		return xspjMapper.getXspjSet(code);
	}

	@Override
	public Target getXspjTarget(String code) {
		return xspjMapper.getXspjTarget(code);
	}

	@Override
	public Template getXspjTemplate(String code) {
		return xspjMapper.getXspjTemplate(code);
	}

	@Override
	public Map<String, Object> getCoursePage(Course course) {
        Map<String, Object> resultMap = new HashMap<>();
        Page<Object> pageInfo = PageHelper.startPage(course.getPageIndex(), course.getPageSize());
        List<Course> pageList = xspjMapper.getCoursePage(course);
        resultMap.put("totalNum",pageInfo.getTotal());
        resultMap.put("pageList", pageList);
        return resultMap;
	}
	
}
