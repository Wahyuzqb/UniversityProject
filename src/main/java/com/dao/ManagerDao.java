package com.dao;

import com.pojo.PreSaves;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ManagerDao {
    String login(@Param("manager_no") String manager_no, @Param("manager_password") String manager_password);

    ArrayList queryAll();

    void changeAuthToOne(String account);

    Integer checkAuthorized(String account);

    Integer checkHasError(String account);

    Integer checkPreSave(String account);

    ArrayList queryPreSaves(String id_account);

    void agreeToPreSave(Integer id);

    void disagreeToPreSave(Integer id);

    void sendMessage(@Param("account")String account,@Param("leaves") String leaves);

    String check4otherAsk(String id_account);

    void setPreSaveTo1(String account);

    String queryIdByAccount(String account);
}
