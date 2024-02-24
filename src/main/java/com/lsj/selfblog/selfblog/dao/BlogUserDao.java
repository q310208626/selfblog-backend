package com.lsj.selfblog.selfblog.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogUserDao {

    void addBlogUser(String username,String password);

    void queryBlogUser(String username);

    void queryBlogUser(int userId);
} 
