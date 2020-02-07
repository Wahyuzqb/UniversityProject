package com.dao;

import com.pojo.Transfers;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    String userBalance(String id_account);

    void changeUserInfo(@Param("id_account") String id_account, @Param("account_password") String account_password);

    String checkOldPWD(@Param("id_account") String id_account, @Param("oldpwd") String oldpwd);

    void changePWD(@Param("id_account") String id_account, @Param("newpwd") String newpwd);

    String checkBalance(String myid);

    String checkOtherid(String otherid);

    void loseMoney(@Param("myid") String myid, @Param("tr_money") String tr_money);

    void addMoney(@Param("otherid") String otherid, @Param("tr_money") String tr_money);

    void addTransMemory(Transfers trans);

    String queryTelephone(String id_account);

    Integer queryTelBalance(String telephone);

    Integer queryBalanceByTel(String telephone);

    void telIn(@Param("telephone") String telephone, @Param("telephone_in") Integer telephone_in);
}
