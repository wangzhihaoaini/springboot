package com.wangzhihao.springboot.entity;

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
    private Set<User_Role> roles;

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
                '}';
    }
}
