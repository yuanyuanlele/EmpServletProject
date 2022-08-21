package com.emp.service.Impl;

import com.emp.dao.EmpManagerDao;
import com.emp.dao.Impl.EmpManagerDaoImpl;
import com.emp.enity.EmpManager;
import com.emp.service.EmpManagerService;
import com.emp.utils.Dbutils;

public class EmpManagerServiceImpl implements EmpManagerService {
    @Override
    public EmpManager login(String username, String password) {
        EmpManagerDao empManagerDao=new EmpManagerDaoImpl();
        EmpManager empManager=null;
        try {
            Dbutils.begin();
            EmpManager temp=empManagerDao.select(username);
            if (temp.getPassword().equals(password)){
                empManager=temp;
            }
            Dbutils.commit();
        } catch (Exception e) {
            Dbutils.rollback();
            e.printStackTrace();
        }
        return empManager;
    }
}
