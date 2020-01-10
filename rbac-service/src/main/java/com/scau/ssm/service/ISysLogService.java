package com.scau.ssm.service;

import com.scau.ssm.domain.SysLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ISysLogService {

    public void save(SysLog sysLog) throws Exception;

    public List<SysLog> findAll() throws Exception;
}
