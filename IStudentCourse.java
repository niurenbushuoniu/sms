package com.briup.apps.app01.service;

import com.briup.apps.app01.bean.StudentCourse;
import com.briup.apps.app01.bean.extend.SCExtend;

import java.util.List;

public interface IStudentCourse {
    List<StudentCourse> findAll();
    /*
     *
     * 通过id查询
     * */
    StudentCourse findById(long id);
    /*
     *
     * 保存更新
     * */
    void saveOrUpdate(StudentCourse course);
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
    List<SCExtend> selectAll();
}
