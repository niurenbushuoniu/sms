package com.briup.apps.app01.service.impl;

import com.briup.apps.app01.bean.User;
import com.briup.apps.app01.bean.UserExample;
import com.briup.apps.app01.mapper.UserMapper;
import com.briup.apps.app01.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        UserExample example=new UserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public User findById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(User course) {
        if(course.getId()==null){
            //保存
            userMapper.insert(course);
        }else{
            //通过id来保存
            userMapper.updateByPrimaryKey(course);
        }
    }

    @Override
    public void deleteByPrimaryKey(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> findByType(String type) {
        UserExample example = new UserExample();
        example.createCriteria().andTypeEqualTo(type);
        return userMapper.selectByExample(example);
    }
    @Override
    public void batchDelete(long[] ids) {
        for(long id : ids){
            userMapper.deleteByPrimaryKey(id);
        }
    }

}
