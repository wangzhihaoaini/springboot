package com.wangzhihao.springboot.entity;

/**
 * @ClassName Role_Permission
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/11 16:36
 * @Version 1.0
 **/
public class Role_Permission{
    private Integer id;
    private String rolename;
    private String permissionName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "Role_Permission{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }
}
