package com.scau.ssm.controller;

import com.scau.ssm.domain.SysLog;
import com.scau.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();

        List<SysLog> sysLogs = sysLogService.findAll();

        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }

}
