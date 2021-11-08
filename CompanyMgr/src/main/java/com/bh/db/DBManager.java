package com.bh.db;


import com.bh.mapper.IMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
	
	
	private Connection getConn() throws Exception{
		
		//Class.forName(DBHelper.DRIVER);
		//return DriverManager.getConnection(DBHelper.URL,DBHelper.USERNAME,DBHelper.USERPASS);
		Connection conn=DBHelper.ds.getConnection();
		return conn;
	}
	public int executeUpdate(String sql,Object []params)
		throws Exception{
		Connection conn=null;
		PreparedStatement stm=null;
		try {
			conn=this.getConn();
			stm=conn.prepareStatement(sql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					stm.setObject(i+1, params[i]);
				}
			}
			if (params!=null) {
				for(int i=0;i<params.length;i++){
					stm.setObject(i+1, params[i]);
				}
			}
			int iden=stm.executeUpdate();
			return iden;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			stm.close();
			conn.close();
		}
	}
	
	//��ѯ���� Object[]
	public List<Object[]> executeQuery(String sql,Object []params)
		throws Exception{
		Connection conn=null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		try {
			conn=this.getConn();
			stm=conn.prepareStatement(sql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					stm.setObject(i+1, params[i]);
				}
			}
			rs=stm.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int count=rsmd.getColumnCount();
			List<Object[]> list=new ArrayList<Object[]>();
			while (rs.next()) {
				
				Object []arr=new Object[count];
				for (int i = 0; i < count; i++) {
					arr[i]=rs.getObject(i+1);
				}
				list.add(arr);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			rs.close();
			stm.close();
			conn.close();
		}
	}
	
	public List executeQueryObject(String sql, Object []params, IMapper mapper)
		throws Exception{
		Connection conn=null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		try {
			conn=this.getConn();
			stm=conn.prepareStatement(sql);
			if (params!=null) {
				for (int i = 0; i < params.length; i++) {
					stm.setObject(i+1, params[i]);
				}
			}
			rs=stm.executeQuery();
			List list=mapper.map(rs);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			rs.close();
			stm.close();
			conn.close();
		}
	}
}
