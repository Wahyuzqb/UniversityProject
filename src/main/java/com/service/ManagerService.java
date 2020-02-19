package com.service;

import com.dao.ManagerDao;
import com.pojo.PreSaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<PreSaves> queryPreSaves(String id_account) {
        return managerDao.queryPreSaves(id_account);
    }

    public void agreeToPreSave(Integer id) {
        managerDao.agreeToPreSave(id);
    }

    public void disagreeToPreSave(Integer id) {
        managerDao.disagreeToPreSave(id);
    }

    public void sendDisagree(String account, String leaves) {
        managerDao.sendMessage(account,leaves);
    }

    public String check4otherAsk(String id_account) {
        return managerDao.check4otherAsk(id_account);
    }

    public void setPreSaveTo1(String account) {
        managerDao.setPreSaveTo1(account);
    }

    public void sendAgree(String account, String newLeaves) {
        managerDao.sendMessage(account,newLeaves);
    }

    public String queryIdByAccount(String account) {
        return managerDao.queryIdByAccount(account);
    }
}
