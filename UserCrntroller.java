package com.briup.apps.app01.web.controller;


import com.briup.apps.app01.bean.User;
import com.briup.apps.app01.service.IUserService;
import com.briup.apps.app01.utils.Message;
import com.briup.apps.app01.utils.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCrntroller {

    @Resource
    private IUserService userService;

    @GetMapping("findAllWithTeacher")
    public Message findAllWithTeacher(){
        String type ="教师";
       List<User>list=userService.findByType(type);
        return MessageUtil.success(list);
    }
    @GetMapping("findAllWithStudent")
    public Message findAllWithStudent(){
        String type ="学生";
        List<User>list=userService.findByType(type);
        return MessageUtil.success(list);
    }
    @GetMapping("findById")
    public Message findById(long id) {
        User user = userService.findById(id);
        return MessageUtil.success(user);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User user){
        userService.saveOrUpdate(user);
        return MessageUtil.success("操作成功");
    }
    @GetMapping("delete")
    public Message delete(long id) {
        userService.deleteByPrimaryKey(id);
        return MessageUtil.success("操作成功");
    }

}
