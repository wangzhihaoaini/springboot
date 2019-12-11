package com.wangzhihao.springboot.entity;

import java.util.Set;

/**
 * @ClassName Role
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/11 16:28
 * @Version 1.0
 **/
public class Role{
    private Integer id;
    private String username;
    /**
     * 角色对应权限
     */
    private Set<Role_Permission> permissions;

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

    public Set<Role_Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Role_Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
