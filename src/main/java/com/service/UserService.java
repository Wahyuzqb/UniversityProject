package com.service;

import com.dao.UserDao;
import com.pojo.Transfers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public String userBalance(String id_account) {
        String msg = null;
        /*按理说做到这一步数据库中有数据输出，之前的逻辑已经否定了没有数据的情况存在*/
        if ((msg = userDao.userBalance(id_account)) != null) {
            return userDao.userBalance(id_account).toString();
        } else
            return null;
        /*如果没有数据可能和浏览器session缓存有关*/
    }

    public int changeUserInfo(String id_account, String account_password) {
        try {
            userDao.changeUserInfo(id_account, account_password);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public boolean checkOldPWD(String id_account, String oldpwd) {

        /*旧密码同数据库中一致，可以修改*/
        if (userDao.checkOldPWD(id_account, oldpwd) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void changePWD(String id_account, String newpwd) {
        userDao.changePWD(id_account, newpwd);
    }

    public boolean transfer(Transfers trans) {
        /*先检查账户余额*/
        String balance = userDao.checkBalance(trans.getMyid());
        if (Integer.valueOf(balance) > Integer.valueOf(trans.getTr_money())) {
            /*判断有无此账号,再判断是否销户*/
            if (userDao.checkOtherid(trans.getOtherid()) != null) {
                userDao.addTransMemory(trans);
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("账户余额不足！");
            return false;
        }
    }

    public void addMoney(String myid, String otherid, String tr_money) {
        userDao.addMoney(otherid, tr_money);
        userDao.loseMoney(myid, tr_money);
    }

    public String queryTelephone(String id_account) {
        return userDao.queryTelephone(id_account);
    }

    public String queryTelBalance(String telephone) {
        return userDao.queryTelBalance(telephone).toString();
    }

    public Integer telIn(String id_account, String telephone, Integer telephone_in) {
        try {
            if (userDao.queryBalanceByTel(telephone) < telephone_in)
                return 2;
            else {
                userDao.loseMoney(id_account, telephone_in.toString());
                /*先减少金额，再充值*/
                userDao.telIn(telephone, telephone_in);
            }
        } catch (Exception e) {
            return 3;
        }
        return 1;
    }

    public void addTelMemory(Transfers trans) {
        userDao.addTransMemory(trans);
    }

    public String query4Water(String id_account) {
        return userDao.query4Water(id_account);
    }

    public String queryWaterBalance(String account2water) {
        return userDao.queryWaterBalance(account2water).toString();
    }

    public Integer waterIn(String id_account, String telephone, Integer water_in) {
        try {
            if (userDao.queryBalanceByTel(telephone) < water_in)
                return 2;
            else {
                userDao.loseMoney(id_account, water_in.toString());
                /*先减少金额，再充值*/
                userDao.waterIn(telephone, water_in);
            }
        } catch (Exception e) {
            return 3;
        }
        return 1;
    }

    public void addWaterMemory(Transfers trans) {
        userDao.addTransMemory(trans);
    }

    public void addPreSave(String id_account, Integer tr_money, String deposit_type, String date, String location) {
        userDao.addPreSave(id_account,tr_money,deposit_type,date,location);
    }

    public void changePreSaveAuth(String id_account) {
        String account =userDao.queryAccountById(id_account);
        userDao.changePreSaveAuth(account);
    }
}
