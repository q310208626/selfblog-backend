package com.lsj.selfblog.selfblog.dao.role;

import org.apache.ibatis.annotations.Mapper;

import com.lsj.selfblog.selfblog.bean.role.BlogRole;

@Mapper
public interface BlogRoleMapper {
    BlogRole queryRoleById(int roleId);   
}
