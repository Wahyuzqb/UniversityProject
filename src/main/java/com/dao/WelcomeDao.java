package com.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface WelcomeDao {
    String checkUser(String id_account);

    String checkUserPassword(@Param("id_account") String id_account, @Param("account_password") String account_password);

    void saveUser(@Param("account") String account, @Param("id_account") String id_account, @Param("account_password") String account_password, @Param("active_time") Date active_time);

    String checkUserTele(@Param("id_account") String id_account, @Param("telephone") String telephone);

    String checkBelongs(String id_account);

    String login(@Param("telephone") String telephone, @Param("account_password") String account_password);
}
