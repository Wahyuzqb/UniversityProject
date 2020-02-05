package com.pojo;

import java.sql.Date;

public class Personal_cards {
    //卡号
    private String id_account;
    //卡内余额
    private int card_balance;
    //开户时间
    private Date open_time;

    public String getId_account() {
        return id_account;
    }

    public void setId_account(String id_account) {
        this.id_account = id_account;
    }

    public int getCard_balance() {
        return card_balance;
    }

    public void setCard_balance(int card_balance) {
        this.card_balance = card_balance;
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
                ", card_balance（卡内余额）=" + card_balance +
                ", open_time（开户时间）=" + open_time +
                ", close_time（销户时间）=" + close_time +
                '}';
    }

    public Personal_cards() {
    }
}
