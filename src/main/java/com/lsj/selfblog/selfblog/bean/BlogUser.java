package com.lsj.selfblog.selfblog.bean;

import java.util.List;

import com.lsj.selfblog.selfblog.bean.role.BlogRole;

public class BlogUser {
    private int userId;
    private String username;
    private String password;
    private List<BlogRole> roles;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BlogRole> getRoles() {
        return roles;
    }

    public void setRoles(List<BlogRole> roles) {
        this.roles = roles;
    }
}
