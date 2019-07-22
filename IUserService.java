package com.briup.apps.app01.service;

import com.briup.apps.app01.bean.User;

import java.util.List;

public interface IUserService {
    List <User> findAll();
    /*
     *
     * 通过id查询
     * */
    User findById(long id);
    /*
     *
     * 保存更新
     * */
    void saveOrUpdate(User course);
    /**
     * 删除
     *
     * */
    void deleteByPrimaryKey(long id);

    List<User> findByType(String type);

    /**
     * 批量删除
     * */
    void batchDelete(long[] ids);
}
