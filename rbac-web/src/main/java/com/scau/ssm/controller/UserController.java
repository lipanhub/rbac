package com.scau.ssm.controller;


import com.scau.ssm.domain.Role;
import com.scau.ssm.domain.UserInfo;
import com.scau.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList =  userService.findAll();

        mv.addObject("userList",userInfoList);
        mv.setViewName("user-list");

        return mv;
    }

    @RequestMapping("/add.do")
    public String add(UserInfo userInfo) throws Exception {
        userService.add(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id) throws Exception {
        ModelAndView mv = new ModelAndView();

        UserInfo userInfo =  userService.findById(id);

        mv.addObject("user",userInfo);
        mv.setViewName("user-show");

        return mv;
    }


    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String id) throws Exception {
        ModelAndView mv = new ModelAndView();

        UserInfo userInfo =  userService.findById(id);
        List<Role> roleList = userService.findOtherRoles(id);

        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);

        mv.setViewName("user-role-add");

        return mv;
    }


    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId,@RequestParam(name = "ids")String[] roleIds) throws Exception {
        ModelAndView mv = new ModelAndView();
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

}
