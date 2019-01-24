/***
 * 这是用户表数据模型
 * 用它完成对用户的各种操作
 * 这里主要编写项目需要的业务操作
 */
package com.mhl.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mhl.model.*;
public class LoginModel {
	
	
	/***
	 * 
	 * @param userid  用户id
	 * @param p   用户密码
	 * @return  该用户的职位，如果该用户不存在则返回""
	 */
	public String checkUser(String userid,String p)
	{
		String position="";
		SqlHelper sh=null;
		try {
			String sql = "select b.position from login a,user b where a.id=b.id and a.id=? and a.password=?";
			String[] params= {userid,p};
			sh=new SqlHelper();
			ResultSet rs = sh.querySQL(sql, params);
		
			if(rs.next())
			{
				//则取出职位
				position=rs.getString(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sh.close();
		}
		
		return position;
	}

}
