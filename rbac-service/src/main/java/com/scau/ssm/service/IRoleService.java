package com.scau.ssm.service;

import com.scau.ssm.domain.Permission;
import com.scau.ssm.domain.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface IRoleService {
    public List<Role> findAll() throws  Exception;

    public void add(Role role) throws  Exception;

    public Role findById(String id) throws  Exception;

    public List<Permission> findOtherPermissions(String id) throws  Exception;

    public void addPermissionToRole(String roleId, String[] permissionIds) throws  Exception;
}
