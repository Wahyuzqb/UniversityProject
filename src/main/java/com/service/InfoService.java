package com.service;

import com.dao.InfoDao;
import com.pojo.Transfers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {
    @Autowired
    public InfoDao infoDao;

    public void modifyTele(String id_account, String telephone) {
        try {
            infoDao.modifyTele(id_account, telephone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Transfers> queryAll(String id_account) {
        return infoDao.queryAll(id_account);
    }
}
