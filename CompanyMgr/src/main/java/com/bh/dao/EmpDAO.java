package com.bh.dao;

import com.bh.db.DBManager;
import com.bh.mapper.EmpMapper;
import com.bh.mapper.IMapper;
import com.bh.vo.Emp;

import java.util.List;

public class EmpDAO {
    //emp删除
    public int delete (int empno) throws Exception {
        String sql = " delete from emp where empno=? ";
        Object[] params = {empno};
        DBManager db = new DBManager();
        return db.executeUpdate(sql, params);
    }

    //插入保存
    public int save (Emp d) throws Exception {
        String sql = " insert into emp (empno,ename,sal) values (?,?,?) ";
        Object[] params = {d.getEmpno(),
                d.getEname(),
                d.getSal()};
        DBManager db = new DBManager();
        return db.executeUpdate(sql, params);
    }
    //更新
    public int merge (Emp d) throws Exception {

        String sql = " update emp set ename=?,sal=? where empno=? ";
        Object[] params = {d.getEname(), d.getSal(), d.getEmpno()};
        DBManager db = new DBManager();
        return db.executeUpdate(sql, params);
    }

    //select all
    public List<Emp> findAll () throws Exception {
        String sql = " select * from emp ";
        IMapper mapper = new EmpMapper();
        DBManager db = new DBManager();
        Object[] params = null;
        return db.executeQueryObject(sql, params, mapper);
    }

    //findById
    public Emp findById (int empno) throws Exception {
        String sql = " select * from emp where empno=? ";
        IMapper mapper = new EmpMapper();
        Object[] params = {empno};
        DBManager db = new DBManager();
        List<Emp> list = db.executeQueryObject(sql, params, mapper);
        Emp d = list.get(0);
        return d;
    }

}
