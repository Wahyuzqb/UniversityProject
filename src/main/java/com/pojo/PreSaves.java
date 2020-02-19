package com.pojo;

import java.sql.Timestamp;

public class PreSaves {
    private Integer id;
    private String id_account;
    private Integer tr_money;
    private String deposit_type;
    private Timestamp save_time;
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PreSaves() {
    }

    public PreSaves(Integer id, String id_account, Integer tr_money, String deposit_type, Timestamp save_time, String location) {
        this.id = id;
        this.id_account = id_account;
        this.tr_money = tr_money;
        this.deposit_type = deposit_type;
        this.save_time = save_time;
        this.location = location;
    }

    @Override
    public String toString() {
        return "PreSaves{" +
                "id=" + id +
                ", id_account='" + id_account + '\'' +
                ", tr_money=" + tr_money +
                ", deposit_type='" + deposit_type + '\'' +
                ", save_time=" + save_time +
                ", location='" + location + '\'' +
                '}';
    }

    public String getId_account() {
        return id_account;
    }

    public void setId_account(String id_account) {
        this.id_account = id_account;
    }

    public Integer getTr_money() {
        return tr_money;
    }

    public void setTr_money(Integer tr_money) {
        this.tr_money = tr_money;
    }

    public String getDeposit_type() {
        return deposit_type;
    }

    public void setDeposit_type(String deposit_type) {
        this.deposit_type = deposit_type;
    }

    public Timestamp getSave_time() {
        return save_time;
    }

    public void setSave_time(Timestamp save_time) {
        this.save_time = save_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
