package com.pojo;

public class Managers {
    //    管理员编号
    private int manager_no;
    //    管理员姓名
    private String manager_name;
    //    管理员密码
    private String manager_password;
    //    管理员权限
    private int authority;

    public int getManager_no() {
        return manager_no;
    }

    public void setManager_no(int manager_no) {
        this.manager_no = manager_no;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_password() {
        return manager_password;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Managers{" +
                "manager_no(管理员编号)=" + manager_no +
                ", manager_name（管理员姓名）='" + manager_name + '\'' +
                ", manager_password（管理员密码）='" + manager_password + '\'' +
                ", authority（管理员权限）=" + authority +
                '}';
    }
}
