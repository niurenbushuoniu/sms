package com.briup.apps.app01.service.impl;

import com.briup.apps.app01.bean.StudentCourse;
import com.briup.apps.app01.bean.StudentCourseExample;
import com.briup.apps.app01.bean.extend.SCExtend;
import com.briup.apps.app01.mapper.StudentCourseMapper;
import com.briup.apps.app01.mapper.extend.SCExtendMapper;
import com.briup.apps.app01.service.IStudentCourse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentCuorseImpl implements IStudentCourse {

    @Resource
    private StudentCourseMapper scMapper;
    @Resource
    private SCExtendMapper sc;
    @Override
    public List<StudentCourse> findAll() {
        StudentCourseExample example=new StudentCourseExample();
        return scMapper.selectByExample(example);
    }

    @Override
    public StudentCourse findById(long id) {
        return scMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(StudentCourse course) {
        if(course.getId()==null){
            //保存
            scMapper.insert(course);
        }else{
            //通过id来保存
            scMapper.updateByPrimaryKey(course);
        }
    }

    @Override
    public void deleteByPrimaryKey(long id) {
        scMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(long[] ids) {
        for(long id : ids){
            scMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<SCExtend> selectAll() {
        return sc.selectAll();
    }
}
