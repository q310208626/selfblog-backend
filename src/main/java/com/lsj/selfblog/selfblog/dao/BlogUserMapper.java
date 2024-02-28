package com.lsj.selfblog.selfblog.dao;

import com.lsj.selfblog.selfblog.bean.BlogUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogUserMapper {

    void addBlogUser(String username,String password);

    BlogUser queryBlogUserByName(String username);

    BlogUser queryBlogUserById(int userId);
}
