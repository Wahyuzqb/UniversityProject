package com.pojo;

import java.sql.Timestamp;

public class Transfers {
    private Timestamp datetime;
    private String myid;
    private String otherid;
    private String tr_money;

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getMyid() {
        return myid;
    }

    public void setMyid(String myid) {
        this.myid = myid;
    }

    public String getOtherid() {
        return otherid;
    }

    public void setOtherid(String otherid) {
        this.otherid = otherid;
    }

    public String getTr_money() {
        return tr_money;
    }

    public void setTr_money(String tr_money) {
        this.tr_money = tr_money;
    }

    @Override
    public String toString() {
        return "Transfers{" +
                "datetime=" + datetime +
                ", myid='" + myid + '\'' +
                ", otherid='" + otherid + '\'' +
                ", tr_money='" + tr_money + '\'' +
                '}';
    }

    public Transfers(Timestamp datetime, String myid, String otherid, String tr_money) {
        this.datetime = datetime;
        this.myid = myid;
        this.otherid = otherid;
        this.tr_money = tr_money;
    }

    public Transfers() {
    }
}
