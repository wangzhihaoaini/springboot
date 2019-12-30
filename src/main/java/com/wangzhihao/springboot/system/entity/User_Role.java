package com.wangzhihao.springboot.system.entity;

/**
 * @ClassName User_Role
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/11 16:34
 * @Version 1.0
 **/
public class User_Role{
    private Integer id;
    private String username;
    private String rolename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
