package com.service;

import com.dao.WelcomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service("welcomeService")
public class WelcomeService {
    @Autowired
    private WelcomeDao welcomeDao;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");


    //检查有无注册过账号
    public int checkUser(String id_account) {
        if (welcomeDao.checkBelongs(id_account) == null) {
            /*0代表不属于该行*/
            return 0;
        }
        if (null == welcomeDao.checkUser(id_account)) {
            /* "1" 代表该卡号未被注册过，可以注册*/
            return 1;
        } else {
            /* "0" 代表已经被注册过，不能重复注册*/
            return 0;
        }
    }

    public int checkUserPassword(String id_account, String account_password) {
        /*不为空说明密码正确,返回1*/
        if (null != welcomeDao.checkUserPassword(id_account, account_password)) {
            return 1;
        } else {
            /*为空说明密码错误，返回0*/
            return 0;
        }
    }

    public void saveUser(String id_account, String account_password) {
        /*使用UUID生成随机账户*/
        String account =
                UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String time = dateFormat.format(System.currentTimeMillis());
        /*确定开户时间*/
        java.sql.Date active_time = java.sql.Date.valueOf(time);
        welcomeDao.saveUser(account, id_account, account_password, active_time);
    }

    public int checkUserTele(String id_account, String telephone) {
        if (welcomeDao.checkUserTele(id_account, telephone) == null) {
            /*0表示数据库中手机号与账号不匹配，无法继续操作*/
            return 0;
        } else {
            /*1表示手机号正确，可以注册新账户*/
            return 1;
        }
    }

    public String login(String telephone, String account_password) {
        String id_account = null;
        if ((id_account = welcomeDao.login(telephone, account_password)) != null) {
            /*1代表登录成功*/
            return id_account;
        } else {
            /*0代表失败*/
            return null;
        }
    }
}
