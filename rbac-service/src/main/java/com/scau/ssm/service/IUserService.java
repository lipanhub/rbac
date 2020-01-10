package com.scau.ssm.service;

import com.scau.ssm.domain.Role;
import com.scau.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserInfo> findAll() throws Exception;

    public void add(UserInfo userInfo)  throws Exception;

    public UserInfo findById(String id)throws Exception;

    public List<Role> findOtherRoles(String id) throws Exception;

    public void addRoleToUser(String userId, String[] roleIds)throws Exception;
}
