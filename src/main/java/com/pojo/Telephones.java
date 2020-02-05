package com.pojo;

public class Telephones {
    private String id_account;
    private String telephone;

    public String getId_account() {
        return id_account;
    }

    public void setId_account(String id_account) {
        this.id_account = id_account;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Telephones{" +
                "id_account(银行卡号)='" + id_account + '\'' +
                ", telephone（预留手机号码）='" + telephone + '\'' +
                '}';
    }
}
