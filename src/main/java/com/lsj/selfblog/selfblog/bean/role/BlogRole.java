package com.lsj.selfblog.selfblog.bean.role;

public class BlogRole {
    private int roleId;
    private ROLE role;

    enum ROLE {
        ADMIN("AdminUser", "ADMIN"),
        NORMAL_USER("NormalUser", "NORMAL");

        private String name;
        private String value;

        ROLE(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        };


    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }
        
}
