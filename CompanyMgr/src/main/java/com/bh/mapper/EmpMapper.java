package com.bh.mapper;

import com.bh.vo.Emp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Supreme
 */
public class EmpMapper implements IMapper {
    @Override
    public List map (ResultSet rs) throws Exception {
        List<Emp> list = new ArrayList<Emp>();
        while (rs.next()) {
            Emp d = new Emp();
            d.setEmpno(rs.getInt("EMPNO"));
            d.setEname(rs.getString("ENAME"));
            d.setJob(rs.getString("JOB"));
            d.setMgr(rs.getInt("MGR"));
            d.setHiredate(rs.getDate("HIREDATE"));
            d.setSal(rs.getInt("SAL"));
            d.setComm(rs.getInt("COMM"));
            d.setDeptno(rs.getInt("DEPTNO"));
            d.setQwerdf(rs.getString("QWERDF"));
            list.add(d);
        }
        return list;
    }

}
