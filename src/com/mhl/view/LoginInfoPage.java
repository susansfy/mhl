/***
 * 登录信息管理界面
 * 这个界面是查看员工登录系统的最新信息
 * 待处理
 */
package com.mhl.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginInfoPage extends JFrame implements ActionListener{
	
	 JPanel topjp,centerjp,westjp,eastjp,downjp;
	 JLabel topjl,downjl;
	 JTextField topjtf;
	 JButton searchbtn,refreshbtn;
	 JTable jt;
	 JScrollPane jsp;
	 int sum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginInfoPage();
	}
	
	public LoginInfoPage()
	{
		//处理顶部的查询
		topjl = new JLabel("请输入员工号查询：");
		topjtf = new JTextField(10);
		searchbtn = new JButton("查询");
		topjp = new JPanel();
		topjp.add(topjl);
		topjp.add(topjtf);
		topjp.add(searchbtn);
		
		//处理底部
		westjp = new JPanel();
		
		downjl = new JLabel("当前共有"+sum+"条记录");
		
		
		this.setLayout(new BorderLayout());
		this.add(topjp,"North");
		this.setSize(400,400);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
