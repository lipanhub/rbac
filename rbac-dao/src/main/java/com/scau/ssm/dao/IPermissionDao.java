package com.scau.ssm.dao;

import com.scau.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId} )")
    public List<Permission> findPermissionByRoleId(String roleId);


    @Select("select * from permission")
    public List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    public void add(Permission permission) throws Exception;
}
