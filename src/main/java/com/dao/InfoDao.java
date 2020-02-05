package com.dao;

import com.pojo.Transfers;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoDao {
    void modifyTele(@Param("id_account") String id_account, @Param("telephone") String telephone);

    List<Transfers> queryAll(String id_account);
}
