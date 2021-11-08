package com.bh.dao;


import com.bh.db.DBManager;
import com.bh.mapper.DeptMapper;
import com.bh.mapper.IMapper;
import com.bh.vo.Dept;

import java.util.List;

public class DeptDAO {

    public int delete (int deptno) throws Exception {
        String sql = " delete from dept where deptno=? ";
        Object[] params = {deptno};
        DBManager db = new DBManager();
        return db.executeUpdate(sql, params);
    }

    //���� insert
    public int save (Dept d) throws Exception {
        String sql = " insert into dept values (?,?,?) ";
        Object[] params = {d.getDeptno(), d.getDname(), d.getLoc()};
        DBManager db = new DBManager();
        return db.executeUpdate(sql, params);
    }

    //�޸�
    public int merge (Dept d) throws Exception {

        String sql = " update dept set dname=?,loc=? where deptno=? ";
        Object[] params = {d.getDname(), d.getLoc(), d.getDeptno()};
        DBManager db = new DBManager();
        return db.executeUpdate(sql, params);

    }

    public List<Dept> findAll () throws Exception {
        String sql = " select *from dept ";
        IMapper mapper = new DeptMapper();
        DBManager db = new DBManager();
        Object[] params = null;
        return db.executeQueryObject(sql, params, mapper);
    }

    //findById
    //ͨ��������Ų�ѯΨһ��һ������
    public Dept findById (int deptno) throws Exception {
        String sql = " select *from dept where deptno=? ";
        IMapper mapper = new DeptMapper();
        Object[] params = {deptno};
        DBManager db = new DBManager();
        List<Dept> list = db.executeQueryObject(sql, params, mapper);
        Dept d = list.get(0);
        return d;
    }
}
