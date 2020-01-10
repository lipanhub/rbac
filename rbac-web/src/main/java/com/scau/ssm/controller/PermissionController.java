package com.scau.ssm.controller;

import com.scau.ssm.domain.Permission;
import com.scau.ssm.service.IPermissionService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Permission> permissionList =  permissionService.findAll();

        mv.addObject("permissionList",permissionList);

        mv.setViewName("permission-list");

        return mv;
    }

    @RequestMapping("/add.do")
    public String add(Permission permission) throws Exception {

        permissionService.add(permission);

        return "redirect:findAll.do";
    }

}
