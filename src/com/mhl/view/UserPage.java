/***
 * 人事管理列表界面
 */
package com.mhl.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.mhl.model.*;

public class UserPage extends JPanel{
	
	JPanel p1,p2,p3,p4,p5;
	JLabel p1_label1,p3_label;
	JTextField p1_jtf1;
	JButton p1_bt1,p4_bt1,p4_bt2,p4_bt3,p4_bt4;
	JTable jt;
	JScrollPane jsp;
	UserModel um;
	
	public UserPage()
	{
		//处理顶部p1
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_label1 = new JLabel("请输入关键字查询:");
		p1_jtf1 = new JTextField(30);
		p1_bt1 = new JButton("查询");
		p1.add(p1_label1);
		p1.add(p1_jtf1);
		p1.add(p1_bt1);
		
		//处理底部p3,p4,p5
		p5=new JPanel(new BorderLayout());
		p3=new JPanel(new FlowLayout());
		p4=new JPanel(new FlowLayout());
		
		p3_label = new JLabel("共有xx行数据");
		p3.add(p3_label);
		
		p4_bt1 = new JButton("添加");
		p4_bt2 = new JButton("修改");
		p4_bt3 = new JButton("删除");
		p4_bt4 = new JButton("查看详情");
		p4.add(p4_bt4);
		p4.add(p4_bt1);
		p4.add(p4_bt2);
		p4.add(p4_bt3);
		
		p5.add(p3,"West");
		p5.add(p4,"East");
		
		//处理p2
		p2 = new JPanel();
		um=new UserModel();
		String[] params2 = {"1"};
		um.queryuser("select * from user where 1=?", params2);
		jt = new JTable(um);
		jsp = new JScrollPane(jt);
		p2.add(jsp);
		
		this.setLayout(new BorderLayout());
		this.add(p1,"North");
		this.add(p5, "South");
		this.add(p2, "Center");
		this.setVisible(true);
		//this.setBackground(Color.RED);
	}

}
