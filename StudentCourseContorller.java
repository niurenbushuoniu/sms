package com.briup.apps.app01.web.controller;


import com.briup.apps.app01.bean.StudentCourse;
import com.briup.apps.app01.bean.extend.SCExtend;
import com.briup.apps.app01.service.IStudentCourse;
import com.briup.apps.app01.utils.Message;
import com.briup.apps.app01.utils.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sc")
public class StudentCourseContorller {
    @Resource
    private IStudentCourse studentCourse;

    @GetMapping("findAll")
    public Message findAll(){
        List<StudentCourse> list = studentCourse.findAll();
        return MessageUtil.success(list);
}

    @GetMapping("findById")
    public Message findById(long id) {
        StudentCourse sc = studentCourse.findById(id);
        return MessageUtil.success(sc);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(StudentCourse sc){
        studentCourse.saveOrUpdate(sc);
        return MessageUtil.success("操作成功");
    }
    @GetMapping("delete")
    public Message delete(long id) {
        studentCourse.deleteByPrimaryKey(id);
        return MessageUtil.success("操作成功");
    }
    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody long[] ids){
        studentCourse.batchDelete(ids);
        return MessageUtil.success("删除成功！");
    }
    @GetMapping("selectAll")
    public Message selectAll()
    {
        List<SCExtend> selectAll = studentCourse.selectAll();
        return MessageUtil.success(selectAll);
    }
}
