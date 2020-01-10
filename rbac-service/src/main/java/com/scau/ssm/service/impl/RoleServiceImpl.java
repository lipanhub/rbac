package com.scau.ssm.service.impl;

import com.scau.ssm.dao.IRoleDao;
import com.scau.ssm.domain.Permission;
import com.scau.ssm.domain.Role;
import com.scau.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void add(Role role) throws Exception {
        roleDao.add(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public List<Permission> findOtherPermissions(String id) throws Exception {
        return roleDao.findOtherPermissions(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
