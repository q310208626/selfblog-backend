package com.lsj.selfblog.selfblog.service.impl;

import com.lsj.selfblog.selfblog.bean.BlogUser;
import com.lsj.selfblog.selfblog.bean.role.BlogRole;
import com.lsj.selfblog.selfblog.dao.BlogUserMapper;
import com.lsj.selfblog.selfblog.dao.role.BlogRoleMapper;
import com.lsj.selfblog.selfblog.service.SelfBlogUserService;
import com.lsj.selfblog.selfblog.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfBlogUserServiceImpl implements SelfBlogUserService{
    @Autowired
    private BlogUserMapper blogUserMapper;

    @Autowired
    private BlogRoleMapper blogRoleMapper;

    public boolean authenBlogUser(String username, String password) {
        BlogUser blogUser = blogUserMapper.queryBlogUserByName(username);
        if(blogUser == null) {
            return false;
        }

        if(blogUser.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public String createUserToken(String username) {
        String userToken = null;
        BlogUser blogUser = blogUserMapper.queryBlogUserByName(username);
        if(blogUser == null) {
            return userToken;
        }
        userToken = JwtUtils.createToken(blogUser);
        return userToken;
    }
}
