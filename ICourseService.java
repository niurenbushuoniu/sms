package com.briup.apps.app01.service;

import com.briup.apps.app01.bean.Course;

import com.briup.apps.app01.bean.extend.CourseExtend;


import java.util.List;


public interface ICourseService {
    /*
    * 查询所有信息及老师
    * */
    List <CourseExtend> findAllWithTeacher();
    /*
    *
    * 查询所有
    * */
    List <Course> findAll();
    /*
     *
     * 通过id查询
     * */
    Course findById(long id);
    /*
     *
     * 保存更新
     * */
    void saveOrUpdate(Course course);
    /**
     * 删除
    *
    * */
    void deleteByPrimaryKey(long id);
    /**
     * 批量删除
     * */
    void batchDelete(long[] ids);
    /**
     * 查询所有
     * */
    List<CourseExtend> selectAll();
}
