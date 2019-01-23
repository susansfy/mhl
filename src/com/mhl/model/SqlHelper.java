/***
 * 对数据库操作的类
 * 对数据库的操作，就是crud
 * 调用存储过程
 */
package com.mhl.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
	
	PreparedStatement ps=null;
	Connection ct = null;
	ResultSet rs=null;
	
	String driver = "com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/myrestaurant?characterEncoding=UTF-8";
	String user="root";
	String passwd="123456";
	
	//构造函数，初始化ct
	public SqlHelper()
	{
		
		try {
			//1、加载驱动
			Class.forName(driver);
			ct=DriverManager.getConnection(url,user, passwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public boolean updateSQL(String sql,String[] params) {
		boolean b=true;
			
		try {
			
			ps=ct.prepareStatement(sql);
			for(int i=0;i<params.length;i++)
			{
				ps.setString(i+1, params[i]);
			}
			if(ps.executeUpdate()!=1)
			{
				b=false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			b=false;
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		return b;
	}
	
	public ResultSet querySQL(String sql,String[] params)
	{
		
		try {
			
			ps=ct.prepareStatement(sql);
			for(int i=0;i<params.length;i++)
			{
				ps.setString(i+1, params[i]);
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close()
	{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
			// TODO: handle exception
		}
	}

}
