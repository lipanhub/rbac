package com.scau.ssm.service.impl;

import com.scau.ssm.dao.IPermissionDao;
import com.scau.ssm.domain.Permission;
import com.scau.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void add(Permission permission) throws Exception {
        permissionDao.add(permission);
    }
}
