package com.wangzhihao.springboot.system.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName User
 * @Description TODO
 * @Author wangzhihao
 * @Date 19/11/18 22:08
 * @Version 1.0
 **/
public class User implements Serializable{
    private static final long serialVersionUID = -8495229851368805188L;
    private Integer id;
    private String username;
    private String password;
    private String nickName;
    /*是否开启 1是 0否*/
    private Integer status;
    private Set<User_Role> roles;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<User_Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<User_Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", status=" + status +
                ", roles=" + roles +
                '}';
    }
}
