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
		//java.sql.ResultSetMetaData rsmt;
		
		public void queryuser(String sql,String[] params)
		{
			
			columnNames=new Vector<String>();
			//设置列名
			columnNames.add("账号");
			columnNames.add("名称");
			columnNames.add("职位");
			columnNames.add("性别");
			
			rowdata=new Vector();
			
			SqlHelper ss=new SqlHelper();
			ResultSet rs=ss.querySQL(sql,params);
			try {
				//rsmt = rs.getMetaData();
				//这里可以根据搜索的结果显示列数
//				for(int i=0;i<rsmt.getColumnCount();i++)
//				{
//					columnNames.add(rsmt.getColumnName(i+1));
//				}
				while(rs.next())
				{
					Vector hang = new Vector();
//					for(int j=0;j<rsmt.getColumnCount();j++)
//					{
//						hang.add(rs.getString(j+1));
//					}
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getString(3));
					hang.add(rs.getString(4));
					rowdata.add(hang);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
