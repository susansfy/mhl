/***
 * 人事管理列表界面
 */
package com.mhl.view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import com.mhl.model.*;



public class UserPage extends JPanel implements ActionListener{
	
	JPanel p1,p2,p3,p4,p5;
	JLabel p1_label1,p3_label;
	JTextField p1_jtf1;
	JButton p1_bt1,p4_bt1,p4_bt2,p4_bt3,p4_bt4;
	JTable jt;
	JScrollPane jsp;
	UserModel um;
	int row_num;
	
	public UserPage()
	{
		//处理顶部p1
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_label1 = new JLabel("请输入关键字查询:");
		p1_jtf1 = new JTextField(30);
		p1_bt1 = new JButton("查询");
		p1_bt1.addActionListener(this);
		p1.add(p1_label1);
		p1.add(p1_jtf1);
		p1.add(p1_bt1);
		
		//处理底部p3,p4,p5
		p5=new JPanel(new BorderLayout());
		p3=new JPanel(new FlowLayout());
		p4=new JPanel(new FlowLayout());
		
		
		
		p4_bt1 = new JButton("添加");
		p4_bt1.addActionListener(this);
		p4_bt2 = new JButton("修改");
		p4_bt2.addActionListener(this);
		p4_bt3 = new JButton("删除");
		p4_bt3.addActionListener(this);
		p4_bt4 = new JButton("查看详情");
		p4_bt4.addActionListener(this);
		p4.add(p4_bt4);
		p4.add(p4_bt1);
		p4.add(p4_bt2);
		p4.add(p4_bt3);
		
		p5.add(p3,"West");
		p5.add(p4,"East");
		
		//处理p2
		p2 = new JPanel();
		p2.setBorder(BorderFactory.createTitledBorder("人事管理"));
		p2.setLayout(new BorderLayout());
		
		um=new UserModel();
		String[] params2 = {"1"};
		um.queryuser("select * from user where 1=?", params2);		
		jt = new JTable(um);
		//设置jtable的行高
		jt.setRowHeight(30);
		//设置jtable自适应列宽
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		//jt.setShowGrid(false);
		//创建一个不占空间的边框来填满，使滚动条边框不出来
		Border js = BorderFactory.createEmptyBorder();
		jsp = new JScrollPane(jt);
		jsp.setBorder(js);
		p2.add(jsp,"Center");
		
		row_num = um.getRowCount();
		p3_label = new JLabel("共有"+row_num+"行数据");
		p3.add(p3_label);
		
		this.setLayout(new BorderLayout());
		this.add(p1,"North");
		this.add(p5, "South");
		this.add(p2, "Center");
		this.setVisible(true);
		//this.setBackground(Color.RED);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//查询按钮
		if(e.getSource()==p1_bt1)
		{
			//因为吧对表的数据封装到model中，可以比较简单完成查询
			String name=this.p1_jtf1.getText().trim();
			String sql;
			String[] params;
			if(name.equals(""))
			{
				sql= "select * from user where 1=?";
				params =new  String[] {"1"};
				
			}else {
				//实现模糊查询
				sql= "select * from user where name like ?";
				
				name = "%"+name+"%";
				params =new String[]{name};
				
			}
			//构造新的数据模型类，并更新
			um=new UserModel();
			um.queryuser(sql,params);
			//更新JTable
			jt.setModel(um);
			//根据查询的结果，变更左下角的行数
			row_num = um.getRowCount();
			this.p3_label.setText("共有"+row_num+"行数据");
				
		}
		//添加按钮
		if(e.getSource()==p4_bt1)
		{
			
			AddUserDialog sad=new AddUserDialog(null,"添加人事信息",true);
			//关闭Dialog后才执行下面的语句
			//构造新的数据模型类，并更新
			um=new UserModel();
			String[] params2 = {"1"};
			um.queryuser("select * from user where 1=?", params2);
			
			//System.out.println("这里没有执行？");
			//更新JTable
			jt.setModel(um);
			//根据查询的结果，变更左下角的行数
			row_num = um.getRowCount();
			this.p3_label.setText("共有"+row_num+"行数据");
		}
		
		//删除按钮
		if(e.getSource()==p4_bt3)
		{
			int selectedrow=this.jt.getSelectedRow();
			
			if(selectedrow==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择一行数据");
				return;
			}else
			{	
				//删除弹窗处理
				int confirmdialog = JOptionPane.showConfirmDialog(null, "是否确认删除该条记录？","",JOptionPane.YES_NO_OPTION);
				if(confirmdialog==0)
				{
					String id=um.getValueAt(selectedrow, 0).toString();
					//System.out.println(id);	
					UserModel temp = new UserModel();
					String sql = "delete from user where id=?";
					String[] params={id};
					temp.updateuser(sql, params);
					
					um=new UserModel();
					String[] params2 = {"1"};
					um.queryuser("select * from user where 1=?", params2);
					//更新JTable
					jt.setModel(um);
					//根据查询的结果，变更左下角的行数
					row_num = um.getRowCount();
					this.p3_label.setText("共有"+row_num+"行数据");
				}
				
			}
				
		}
		
		//修改按钮
		if(e.getSource()==p4_bt2)
		{
			int selectedrow=this.jt.getSelectedRow();
			
			if(selectedrow==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择一行数据");
				return;
			}else{
			
			UpdateUserDialog sud = new UpdateUserDialog(null,"修改人事信息",true,um,selectedrow);
			System.out.println("hello");
			um=new UserModel();
			String[] params2 = {"1"};
			um.queryuser("select * from user where 1=?", params2);
			//更新JTable
			jt.setModel(um);
			}
		}
		
		//查询详情
		if(e.getSource()==p4_bt4)
		{
			int selectedrow=this.jt.getSelectedRow();
			
			if(selectedrow==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择一行数据");
				return;
			}else{
				ViewUserDialog vud=new ViewUserDialog(um,selectedrow);
			
			}
		}
	}

}
