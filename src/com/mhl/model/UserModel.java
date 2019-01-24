/***
 * 人事管理的数据表操作
 */
package com.mhl.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class UserModel extends AbstractTableModel{
	//rowdata用来存放行数据；
		//columnnames存放列名；
		Vector rowdata,columnNames;
		
		public void queryuser(String sql,String[] params)
		{
			
			columnNames=new Vector();
			//设置列名
			columnNames.add("id");
			columnNames.add("name");
			
			rowdata=new Vector();
			
			SqlHelper ss=new SqlHelper();
			ResultSet rs=ss.querySQL(sql,params);
				
			try {
				while(rs.next())
				{
					Vector hang = new Vector();
					
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					rowdata.add(hang);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ss.close();
			
		}
		
		public boolean updateuser(String sql,String[] params)
		{
			
			SqlHelper ss=new SqlHelper();
			return ss.updateSQL(sql, params);
			
		}
		
		
		
		//得到共有多少列
		public int getRowCount() {
			// TODO Auto-generated method stub
			return this.rowdata.size();
		}

		//得到共有多少行
		public int getColumnCount() {
			// TODO Auto-generated method stub
			
			return this.columnNames.size();
		}

		//得到某行某列的数据
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			//System.out.println(rowIndex+"="+columnIndex);
			return ((Vector)this.rowdata.get(rowIndex)).get(columnIndex);
			//return null;
		}
		
		public String getColumnName(int column)
		{
			return this.columnNames.get(column).toString();
		}
		
		

}
