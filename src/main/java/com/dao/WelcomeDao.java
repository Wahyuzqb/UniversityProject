package com.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;

@Repository
public interface WelcomeDao {
    String checkUser(String id_account);

    String checkUserPassword(@Param("id_account") String id_account, @Param("account_password") String account_password);

    void saveUser(@Param("account") String account, @Param("id_account") String id_account, @Param("account_password") String account_password, @Param("active_time") Timestamp active_time);

    String checkUserTele(@Param("id_account") String id_account, @Param("telephone") String telephone);

    String checkBelongs(String id_account);

    String login(@Param("account") String account, @Param("account_password") String account_password);

    String checkUserAccountByTele(String telephone);

    int checkAuth(String id_account);

    void saveInAuth(String account);
}
