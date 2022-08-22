package com.emp.dao.Impl;

import com.emp.dao.EmpDao;
import com.emp.dao.EmpManagerDao;
import com.emp.enity.Emp;
import com.emp.utils.Dbutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    QueryRunner queryRunner=new QueryRunner();
    @Override
    public List<Emp> selectall() {
        try {
            List<Emp> emps=queryRunner.query(Dbutils.getconnection(),"select * from emp;",new BeanListHandler<Emp>(Emp.class));
            return emps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
