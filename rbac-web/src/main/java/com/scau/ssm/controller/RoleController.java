package com.scau.ssm.controller;

import com.scau.ssm.domain.Permission;
import com.scau.ssm.domain.Role;
import com.scau.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Role> roleList =  roleService.findAll();

        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");

        return mv;
    }

    @RequestMapping("/add.do")
    public String add(Role role) throws Exception {

        roleService.add(role);

        return "redirect:findAll.do";
    }


    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true)String id) throws Exception {

        ModelAndView mv = new ModelAndView();

        Role role = roleService.findById(id);

        List<Permission> permissionList = roleService.findOtherPermissions(id);

        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);

        mv.setViewName("role-permission-add");

        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,@RequestParam(name = "ids")String[] permissionIds) throws Exception {
        ModelAndView mv = new ModelAndView();
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }

}
