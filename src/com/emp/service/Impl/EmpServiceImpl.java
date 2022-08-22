package com.emp.service.Impl;

import com.emp.dao.EmpDao;
import com.emp.dao.Impl.EmpDaoImpl;
import com.emp.enity.Emp;
import com.emp.service.EmpService;
import com.emp.utils.Dbutils;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    @Override
    public List<Emp> showallEmp() {
        EmpDao empDao=new EmpDaoImpl();
        List<Emp> emps=null;
        try {
            Dbutils.begin();
            List<Emp> temps=emps=empDao.selectall();
            if (temps!=null){
                emps=temps;
            }
            Dbutils.commit();
        } catch (Exception e) {
            Dbutils.rollback();
            e.printStackTrace();
        }
        return emps;
    }
}
