package com.pojo;

import java.sql.Date;

public class Personal_cards {
    //卡号
    private int id_account;
    //卡内余额
    private int car_balance;
    //开户时间
    private Date open_time;

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public int getCar_balance() {
        return car_balance;
    }

    public void setCar_balance(int car_balance) {
        this.car_balance = car_balance;
    }

    public Date getOpen_time() {
        return open_time;
    }

    public void setOpen_time(Date open_time) {
        this.open_time = open_time;
    }

    public Date getClose_time() {
        return close_time;
    }

    public void setClose_time(Date close_time) {
        this.close_time = close_time;
    }

    //销户时间
    private Date close_time;

    @Override
    public String toString() {
        return "Personal_cards{" +
                "id_account（卡号）=" + id_account +
                ", car_balance（卡内余额）=" + car_balance +
                ", open_time（开户时间）=" + open_time +
                ", close_time（销户时间）=" + close_time +
                '}';
    }
}
