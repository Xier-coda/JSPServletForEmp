package com.bh.mapper;

import com.bh.vo.Dept;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DeptMapper implements IMapper{
	
	@Override
	public List map(ResultSet rs) throws Exception {
		List<Dept> list=new ArrayList<Dept>();
		while (rs.next()) {
			Dept d=new Dept();
			d.setDeptno(rs.getInt("DEPTNO"));
			d.setDname(rs.getString("DNAME"));
			d.setLoc(rs.getString("LOC"));
			list.add(d);
		}
		return list;
	}
	
}
