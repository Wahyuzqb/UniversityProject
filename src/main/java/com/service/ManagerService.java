package com.service;

import com.dao.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ManagerService {
    @Autowired
    private ManagerDao managerDao;

    public boolean login(String manager_no, String manager_password) {
        if (managerDao.login(manager_no, manager_password) != null)
            return true;
        else
            return false;
    }

    public ArrayList queryAll() {
        return managerDao.queryAll();
    }

    public void changeAuthToOne(String account) {
        managerDao.changeAuthToOne(account);
    }

    public int isAuthorized(String account) {
        if (managerDao.checkAuthorized(account) == 0)
            return 0;
        else
            return 1;
    }

    public int hasError(String account) {
        if (managerDao.checkHasError(account) == 0)
            return 0;
        else
            return 1;
    }

    public int preSave(String account) {
        if (managerDao.checkPreSave(account) == 0)
            return 0;
        else
            return 1;
    }
}
