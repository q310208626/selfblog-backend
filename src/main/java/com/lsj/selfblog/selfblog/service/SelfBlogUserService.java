package com.lsj.selfblog.selfblog.service;


public interface SelfBlogUserService {
    boolean authenBlogUser(String username,String password);

    String createUserToken(String username);
}
