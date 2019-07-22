package com.briup.apps.app01.web.controller;


import com.briup.apps.app01.bean.Course;
import com.briup.apps.app01.bean.extend.CourseExtend;
import com.briup.apps.app01.service.ICourseService;
import com.briup.apps.app01.utils.Message;
import com.briup.apps.app01.utils.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 课程控制器类
* */

@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private ICourseService courseService;

    @GetMapping("findAllWithTeacher")
    public Message findAllWithTeacher(){
        List<CourseExtend> list = courseService.findAllWithTeacher();
        return MessageUtil.success(list);
    }

    @GetMapping("findAll")
    public Message findAll(){
        List<Course> list = courseService.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        Course course = courseService.findById(id);
        return MessageUtil.success(course);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Course course){
        courseService.saveOrUpdate(course);
        return MessageUtil.success("操作成功");
    }
    @GetMapping("delete")
    public Message delete(long id) {
        courseService.deleteByPrimaryKey(id);
        return MessageUtil.success("操作成功");
    }
//    批量删除
    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody long[] ids){
    courseService.batchDelete(ids);
    return MessageUtil.success("删除成功！");
}
    @GetMapping("selectAll")
    public Message selectAll()
    {
        List<CourseExtend> selectAll = courseService.selectAll();
        return MessageUtil.success(selectAll);
    }
}
