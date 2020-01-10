package com.scau.ssm.service;

import com.scau.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll() throws Exception;

    public void add(Permission permission)throws Exception;
}
