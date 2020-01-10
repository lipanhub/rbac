package com.scau.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.scau.ssm.domain.Orders;

import com.scau.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @ResponseBody
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize,@RequestParam(name = "page",required = true,defaultValue = "1")Integer page) throws Exception {

        ModelAndView mv = new ModelAndView();

        List<Orders> ordersList = ordersService.findAll(page,pageSize);

        PageInfo pageInfo = new PageInfo(ordersList);

        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();

        Orders orders = ordersService.findById(id);

        mv.addObject("orders",orders);
        mv.setViewName("orders-show");

        return mv;
    }

}
