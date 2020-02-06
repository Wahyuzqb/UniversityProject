package com.dao;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ManagerDao {
    String login(@Param("manager_no") String manager_no, @Param("manager_password") String manager_password);

    ArrayList queryAll();

    void changeAuthToOne(String account);

    Integer checkAuthorized(String account);

    Integer checkHasError(String account);

    Integer checkPreSave(String account);
}
