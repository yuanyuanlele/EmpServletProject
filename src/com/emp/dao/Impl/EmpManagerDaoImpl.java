package com.emp.dao.Impl;

import com.emp.dao.EmpManagerDao;
import com.emp.enity.EmpManager;
import com.emp.utils.Dbutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpManagerDaoImpl implements EmpManagerDao {
    QueryRunner queryRunner=new QueryRunner();
    @Override
    public int insert(EmpManager empManager) {
        return 0;
    }

    @Override
    public int delete(EmpManager empManager) {
        return 0;
    }

    @Override
    public int update(EmpManager empManager) {
        return 0;
    }

    @Override
    public EmpManager select(String username) {
        EmpManager empManager=null;
        try {
            empManager=queryRunner.query(Dbutils.getconnection(),"select *from empmanager where username=?;",new BeanHandler<EmpManager>(EmpManager.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empManager;
    }

    @Override
    public List<EmpManager> selectall() {
        return null;
    }
}
