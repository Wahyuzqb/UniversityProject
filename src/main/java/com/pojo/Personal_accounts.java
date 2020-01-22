package com.pojo;

import java.sql.Date;

public class Personal_accounts {
    //    账户名称
    private String account;
    //    卡号
    private String id_account;
    //    卡密码
    private String account_password;
    //    激活时间
    private Date active_time;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getId_account() {
        return id_account;
    }

    public void setId_account(String id_account) {
        this.id_account = id_account;
    }

    public String getAccount_password() {
        return account_password;
    }

    public void setAccount_password(String account_password) {
        this.account_password = account_password;
    }

    public Date getActive_time() {
        return active_time;
    }

    public void setActive_time(Date active_time) {
        this.active_time = active_time;
    }

    @Override
    public String toString() {
        return "Personal_accounts{" +
                "account（账户名称）='" + account + '\'' +
                ", id_account（卡号）=" + id_account +
                ", account_password（账户密码）='" + account_password + '\'' +
                ", active_time（激活时间）=" + active_time +
                '}';
    }
}
