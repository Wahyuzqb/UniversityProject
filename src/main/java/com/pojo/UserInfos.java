package com.pojo;

import java.sql.Date;

public class UserInfos {
    private String id_account;
    private String account_password;
    private int card_balance;
    private Date active_time;

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

    public int getCard_balance() {
        return card_balance;
    }

    public void setCard_balance(int card_balance) {
        this.card_balance = card_balance;
    }

    public Date getActive_time() {
        return active_time;
    }

    public void setActive_time(Date active_time) {
        this.active_time = active_time;
    }

    @Override
    public String toString() {
        return "UserInfos{" +
                "id_account='" + id_account + '\'' +
                ", account_password='" + account_password + '\'' +
                ", card_balance=" + card_balance +
                ", active_time=" + active_time +
                '}';
    }

    public UserInfos(String id_account, String account_password, int card_balance, Date active_time) {
        this.id_account = id_account;
        this.account_password = account_password;
        this.card_balance = card_balance;
        this.active_time = active_time;
    }

    public UserInfos() {
    }
}
