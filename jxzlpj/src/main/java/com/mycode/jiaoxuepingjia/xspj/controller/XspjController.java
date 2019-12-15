package com.mycode.jiaoxuepingjia.xspj.controller;

import com.mycode.jiaoxuepingjia.xspj.domain.Target;
import com.mycode.jiaoxuepingjia.xspj.domain.Template;
import com.mycode.jiaoxuepingjia.xspj.domain.Course;
import com.mycode.jiaoxuepingjia.xspj.domain.XspjSet;
import com.mycode.jiaoxuepingjia.xspj.service.XspjService;
import com.mycode.system.menu.domain.Menu;
import com.mycode.system.role.domain.Role;
import com.mycode.util.JsonResult;

import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 学生评教
 * @auther kexiangwei
 * @date 2019/10/8
 */
@CrossOrigin
@Controller
public class XspjController {

    @Autowired
    private XspjService xspjService;

    @ResponseBody
    @RequestMapping("/getXspjSetPage.do")
    public JsonResult<Object> getXspjSetPage(XspjSet xspjSet){
        Map<String, Object> resultMap = xspjService.getXspjSetPage(xspjSet);
        return JsonResult.success(resultMap);
    }

    @ResponseBody
    @RequestMapping("/getXspjSet.do")
    public JsonResult<Object> getXspjSet(@RequestParam("code") String code){
    	XspjSet xspjSet = xspjService.getXspjSet(code);
        return JsonResult.success(xspjSet);
    }

    @ResponseBody
    @RequestMapping("/saveOrUpdateSet.do")
    public JsonResult<Object> saveOrUpdateSet(XspjSet xspjSet){
        boolean bool = xspjService.saveOrUpdateSet(xspjSet);
        if(!bool){
            return JsonResult.error();
        }
        return JsonResult.success();
    }
    @ResponseBody
    @RequestMapping("/deleteSet.do")
    public JsonResult<Object> deleteSet(@RequestParam("code") String code){
        //执行删除
        boolean bool = xspjService.deleteSet(code);
        if(!bool){
            return JsonResult.error("删除失败");
        }
        return JsonResult.success("删除成功");
    }
    @ResponseBody
    @RequestMapping("/getXspjTemplatePage.do")
    public JsonResult<Object> getXspjTemplatePage(Template template){
        Map<String, Object> resultMap = xspjService.getXspjTemplatePage(template);
        return JsonResult.success(resultMap);
    }
    
    @ResponseBody
    @RequestMapping("/getXspjTemplateList.do")
    public JsonResult<Object> getXspjTemplateList(){
        List<Template> templates = xspjService.getXspjTemplateList();
        return JsonResult.success(templates);
    }

    @ResponseBody
    @RequestMapping("/getXspjTemplate.do")
    public JsonResult<Object> getXspjTemplate(@RequestParam("code") String code){
    	Template template = xspjService.getXspjTemplate(code);
        return JsonResult.success(template);
    }

    @ResponseBody
    @RequestMapping("/saveOrUpdateTemplate.do")
    public JsonResult<Object> saveOrUpdateTemplate(Template template){
        boolean bool = xspjService.saveOrUpdateTemplate(template);
        if(!bool){
            return JsonResult.error();
        }
        return JsonResult.success();
    }
    @ResponseBody
    @RequestMapping("/deleteTemplate.do")
    public JsonResult<Object> deleteTemplate(@RequestParam("code") String code){
        //执行删除
        boolean bool = xspjService.deleteTemplate(code);
        if(!bool){
            return JsonResult.error("删除失败");
        }
        return JsonResult.success("删除成功");
    }
    @ResponseBody
    @RequestMapping("/getXspjTargetPage.do")
    public JsonResult<Object> getXspjTargetPage(Target target){
    	Map<String, Object> resultMap = xspjService.getXspjTargetPage(target);
        return JsonResult.success(resultMap);
    }

    @ResponseBody
    @RequestMapping("/getXspjTargetList.do")
    public JsonResult<Object> getXspjTargetList(){
        List<Target> targets = xspjService.getXspjTargetList();
        return JsonResult.success(targets);
    }

    @ResponseBody
    @RequestMapping("/getXspjTarget.do")
    public JsonResult<Object> getXspjTarget(@RequestParam("code") String code){
    	Target target = xspjService.getXspjTarget(code);
        return JsonResult.success(target);
    }

    @ResponseBody
    @RequestMapping("/saveOrUpdateTarget.do")
    public JsonResult<Object> saveOrUpdateTarget(Target target){
        boolean bool = xspjService.saveOrUpdateTarget(target);
        if(!bool){
            return JsonResult.error();
        }
        return JsonResult.success();
    }
    @ResponseBody
    @RequestMapping("/deleteTarget.do")
    public JsonResult<Object> deleteTarget(@RequestParam("code") String code){
        //执行删除
        boolean bool = xspjService.deleteTarget(code);
        if(!bool){
            return JsonResult.error("删除失败");
        }
        return JsonResult.success("删除成功");
    }
    @ResponseBody
    @RequestMapping("/getXspjCoursePage.do")
    public JsonResult<Object> getXspjCoursePage(Course course){
        Map<String, Object> resultMap = xspjService.getXspjCoursePage(course);
        return JsonResult.success(resultMap);
    }

    @ResponseBody
    @RequestMapping("/getXspjTemplateMap.do")
    public JsonResult<Object> getXspjTemplateMap(){
        Map<String, Object> resultMap = xspjService.getXspjTemplateMap();
        return JsonResult.success(resultMap);
    }
    @ResponseBody
    @RequestMapping("/getCoursePage.do")
    public JsonResult<Object> getCoursePage(Course course){
        Map<String, Object> resultMap = xspjService.getCoursePage(course);
        return JsonResult.success(resultMap);
    }
}
