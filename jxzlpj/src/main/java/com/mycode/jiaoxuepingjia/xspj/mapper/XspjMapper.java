package com.mycode.jiaoxuepingjia.xspj.mapper;

import com.mycode.jiaoxuepingjia.xspj.domain.Target;
import com.mycode.jiaoxuepingjia.xspj.domain.Template;
import com.mycode.jiaoxuepingjia.xspj.domain.Course;
import com.mycode.jiaoxuepingjia.xspj.domain.XspjSet;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @auther kexiangwei
 * @date 2019/10/8
 */
@Mapper
public interface XspjMapper {

    List<XspjSet> getXspjSetPage(XspjSet xspjSet);

    List<Template> getXspjTemplatePage();

    List<Template> getXspjTemplateList();
    
    List<Target> getXspjTargetPage();
    
    List<Target> getXspjTargetList();

    List<Target> getXspjTargetListByTemplateCode();

    List<Course> getXspjCoursePage(Course course);

	boolean insertSet(XspjSet xspjSet);
	
    @Delete("delete from JXPJ_PJSET where code = #{code}")
    boolean deleteSet(@Param("code") String code);

	boolean updateSet(XspjSet xspjSet);

	boolean insertTemplate(Template template);
	
    @Delete("delete from JXPJ_PJSET_TEMPLATE where code = #{code}")
    boolean deleteTemplate(@Param("code") String code);

	boolean updateTemplate(Template template);

	boolean insertTarget(Target target);
	
    @Delete("delete from JXPJ_PJSET_TARGET where code = #{code}")
    boolean deleteTarget(@Param("code") String code);

	boolean updateTarget(Target target);

    @Select("select * from JXPJ_PJSET where code = #{code}")
	XspjSet getXspjSet(String code);

    @Select("select * from JXPJ_PJSET_TARGET where code = #{code}")
	Target getXspjTarget(String code);

    @Select("select * from JXPJ_PJSET_TEMPLATE where code = #{code}")
	Template getXspjTemplate(String code);

	List<Course> getCoursePage(Course course);
}
