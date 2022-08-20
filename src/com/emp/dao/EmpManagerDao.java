package com.emp.dao;

import com.emp.enity.EmpManager;

import java.util.List;

public interface EmpManagerDao {
    public int insert(EmpManager empManager);
    public int delete(EmpManager empManager);
    public int update(EmpManager empManager);
    public EmpManager select(String username);
    public List<EmpManager> selectall();
}
