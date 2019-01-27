/***
 * 主菜单界面
 */
package com.mhl.view;
import com.mhl.model.UserModel;
import com.mhl.tools.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;



public class Window1 extends JFrame implements ActionListener,MouseListener{
	
	Image titleIcon,timeim,p1_bg;
	
	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jmt1,jmt2,jmt3,jmt4,jmt5,jmt6,jmt7,jmt8,jmt9,jmt10;
	ImageIcon jm1_icon1,jm1_icon2,jm1_icon3,jm1_icon4,jm1_icon5;
	
	//工具栏
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	
	JPanel p1,p2,p3,p4,p5;
	JLabel p1_label1,p1_label2,p1_label3,p1_label4,p1_label5,p1_label6,p1_label7,p1_label8;
	CardLayout c1,c2;
	JLabel p2_label1,p2_label2;
	ImageIcon p3_image1,p3_image2,p3_image3,p3_image4,p3_image5,p3_image6,p3_image7;
	JLabel p3_label2,p3_label3,p3_label4,p3_label5,p3_label6,p3_label7,p3_label1;
	JPanel p3_jp1;
	JSplitPane jsp;
	JLabel timeNow;
	Cursor cs;
	javax.swing.Timer t;
	boolean p4_flag = false;
	Container c;
	
	String selecteditem;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window1 w = new Window1();
	}
	
	public void menu()
	{
		jmb = new JMenuBar();
		//系统管理菜单
		jm1 = new JMenu("系统管理");
		jm1.setFont(MyTools.f1);
		jm1_icon1 = new ImageIcon("image\\jm1_icon1.jpg");
		jmt1 = new JMenuItem("切换用户",jm1_icon1);
		jmt1.setFont(MyTools.f2);
		jmt1.addActionListener(this);
		jm1_icon2 = new ImageIcon("image\\jm1_icon2.jpg");
		jmt2 = new JMenuItem("切换到收款界面",jm1_icon2);
		jmt2.setFont(MyTools.f2);
		jmt2.addActionListener(this);
		jm1_icon3 = new ImageIcon("image\\jm1_icon3.jpg");
		jmt3 = new JMenuItem("登录管理",jm1_icon3);
		jmt3.setFont(MyTools.f2);
		jmt3.addActionListener(this);
		jm1_icon4 = new ImageIcon("image\\jm1_icon4.jpg");
		jmt4 = new JMenuItem("万年历",jm1_icon4);
		jmt4.setFont(MyTools.f2);
		jmt4.addActionListener(this);
		jm1_icon5 = new ImageIcon("image\\jm1_icon5.jpg");
		jmt5 = new JMenuItem("退出",jm1_icon5);
		jmt5.setFont(MyTools.f2);
		jmt5.addActionListener(this);
		
		//加入
		jm1.add(jmt1);
		jm1.add(jmt2);
		jm1.add(jmt3);
		jm1.add(jmt4);
		jm1.add(jmt5);
		
		
		
		jm2 = new JMenu("人事管理");
		jm2.setFont(MyTools.f1);
		jm3 = new JMenu("菜单服务");
		jm3.setFont(MyTools.f1);
		jm4 = new JMenu("报表统计");
		jm4.setFont(MyTools.f1);
		jm5 = new JMenu("成本及库房");
		jm5.setFont(MyTools.f1);
		jm6 = new JMenu("帮助");
		jm6.setFont(MyTools.f1);
		
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		
		//菜单直接加到JFrame中
		this.setJMenuBar(jmb);
	}
	
	public void tool_bar()
	{
		//工具栏
		jtb = new JToolBar();
		//设置工具栏不可移动
		jtb.setFloatable(false);
		
		jb1 = new JButton(new ImageIcon("image\\toolBar_image\\jb1.jpg"));
		jb1.addActionListener(this);
		jb2 = new JButton(new ImageIcon("image\\toolBar_image\\jb2.jpg"));
		jb3 = new JButton(new ImageIcon("image\\toolBar_image\\jb3.jpg"));
		jb4 = new JButton(new ImageIcon("image\\toolBar_image\\jb4.jpg"));
		jb5 = new JButton(new ImageIcon("image\\toolBar_image\\jb5.jpg"));
		jb6 = new JButton(new ImageIcon("image\\toolBar_image\\jb6.jpg"));
		jb7 = new JButton(new ImageIcon("image\\toolBar_image\\jb7.jpg"));
		jb8 = new JButton(new ImageIcon("image\\toolBar_image\\jb8.jpg"));
		jb9 = new JButton(new ImageIcon("image\\toolBar_image\\jb9.jpg"));
		jb10 = new JButton(new ImageIcon("image\\toolBar_image\\jb10.jpg"));
		jb10.addActionListener(this);
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
		jtb.add(jb8);
		jtb.add(jb9);
		jtb.add(jb10);
	}
	
	
	public void all_panel()
	{
		//设置光标样式
		cs = new Cursor(Cursor.HAND_CURSOR);

		//处理P1模块列界面
		p1=new JPanel(new BorderLayout());
		try {
			p1_bg=ImageIO.read(new File("image\\center_image\\jp1_bg.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImagePanel p1_ip1=new ImagePanel(p1_bg);
		p1.add(p1_ip1,BorderLayout.CENTER);
		
		//添加8个label
		p1_ip1.setLayout(new GridLayout(8,1));
		p1_label1 = new JLabel(new ImageIcon("image\\center_image\\label_1.gif"));
		p1_label2 = new JLabel("人事管理",new ImageIcon("image\\center_image\\label_2.jpg"),0);
		p1_label2.setEnabled(false);
		p1_label2.addMouseListener(this);
		p1_label2.setCursor(cs);
		p1_label3 = new JLabel("登录管理",new ImageIcon("image\\center_image\\label_3.jpg"),0);
		p1_label3.setEnabled(false);
		p1_label3.addMouseListener(this);
		p1_label3.setCursor(cs);
		p1_label4 = new JLabel("菜谱价格",new ImageIcon("image\\center_image\\label_4.jpg"),0);
		p1_label4.setEnabled(false);
		p1_label4.addMouseListener(this);
		p1_label4.setCursor(cs);
		p1_label5 = new JLabel("报表统计",new ImageIcon("image\\center_image\\label_5.jpg"),0);
		p1_label5.setEnabled(false);
		p1_label5.addMouseListener(this);
		p1_label5.setCursor(cs);
		p1_label6 = new JLabel("成本及库房",new ImageIcon("image\\center_image\\label_6.jpg"),0);
		p1_label6.setEnabled(false);
		p1_label6.addMouseListener(this);
		p1_label6.setCursor(cs);
		p1_label7 = new JLabel("系统设置",new ImageIcon("image\\center_image\\label_7.jpg"),0);
		p1_label7.setEnabled(false);
		p1_label7.addMouseListener(this);
		p1_label7.setCursor(cs);
		p1_label8 = new JLabel("动画帮助",new ImageIcon("image\\center_image\\label_8.jpg"),0);
		p1_label8.setEnabled(false);
		p1_label8.addMouseListener(this);
		p1_label8.setCursor(cs);
		p1_ip1.add(p1_label1);
		p1_ip1.add(p1_label2);
		p1_ip1.add(p1_label3);
		p1_ip1.add(p1_label4);
		p1_ip1.add(p1_label5);
		p1_ip1.add(p1_label6);
		p1_ip1.add(p1_label7);
		p1_ip1.add(p1_label8);
		
	}
	
	public Window1()
	{
		try {
			titleIcon = ImageIO.read(new File("image\\title.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.menu();
		
		this.tool_bar();
		
		this.all_panel();
			
		//Container
		c = this.getContentPane();
		c.add(jtb, BorderLayout.NORTH);
		
		//处理P5面板
		p5= new JPanel(new BorderLayout());
		//创建Timer，每隔1秒取触发ActionEvent
		t=new Timer(1000,this);
		//启动定时器
		t.start();
		//获取当前时间
		timeNow = new JLabel(Calendar.getInstance().getTime().toString());
		

		try {
			timeim=ImageIO.read(new File("image\\time_bg.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImagePanel ip1=new ImagePanel(timeim);
		//如果没设置BorderLayout，时间将显示在屏幕下方中间的位置；
		//设置后，时间可显示在屏幕下方右侧
		ip1.setLayout(new BorderLayout());
		ip1.add(timeNow,BorderLayout.EAST);
		
		p5.add(ip1);
		//时间显示在屏幕右下角
		//p5.add(timeNow,BorderLayout.EAST);
		c.add(p5,BorderLayout.SOUTH);
		//c.add(jsp,BorderLayout.CENTER);
		c.add(p1,BorderLayout.CENTER);
		
		this.setIconImage(titleIcon);
		this.setTitle("餐饮管理系统");
		
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width, height-30);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.timeNow.setText("当前时间："+Calendar.getInstance().getTime().toString());
		
		//处理菜单
		//切换用户
		if(e.getSource()==jmt1)
		{
			this.dispose();
			new LoginPage();
		}
		//切换到收款界面
		if(e.getSource()==jmt2)
		{
			//todo
		}
		//登录管理
		if(e.getSource()==jmt3)
		{
			//todo
		}
		//万年历
		if(e.getSource()==jmt4)
		{
			//todo
		}
		//退出
		if(e.getSource()==jmt5)
		{
			this.dispose();
		}
		
		//处理工具栏
		//切换用户
		if(e.getSource()==jb1)
		{
			this.dispose();
			new LoginPage();
		}
		//帮助
		if(e.getSource()==jb10)
		{
			JOptionPane.showMessageDialog(null, "欢迎使用满汉楼管理系统，有问题请联系主管，电话：123456789");
		}
				
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.p1_label2)
		{
			selecteditem= "userinfo";
			//selecteditem=1;
			MyAllPanel mlp = new MyAllPanel(selecteditem);
			p1.removeAll();
			p1.repaint();
			p1.add(mlp);
			p1.revalidate();
			
			//c2.show(p3, "1");
		}
		if(e.getSource()==this.p1_label3)
		{
			selecteditem= "logininfo";
			//selecteditem=2;
			MyAllPanel mlp = new MyAllPanel(selecteditem);
			p1.removeAll();
			p1.repaint();
			p1.add(mlp);
			p1.revalidate();
			//c2.show(p3, "2");
		}
		if(e.getSource()==this.p1_label4)
		{
			selecteditem= "menuinfo";
			//selecteditem=3;
			MyAllPanel mlp = new MyAllPanel(selecteditem);
			p1.removeAll();
			p1.repaint();
			p1.add(mlp);
			p1.revalidate();
			//c2.show(p3, "3");
		}
		if(e.getSource()==this.p1_label5)
		{
			selecteditem= "reportinfo";
			//selecteditem=4;
			MyAllPanel mlp = new MyAllPanel(selecteditem);
			p1.removeAll();
			p1.repaint();
			p1.add(mlp);
			p1.revalidate();
			//c2.show(p3, "4");
		}
		if(e.getSource()==this.p1_label6)
		{
			//selecteditem=5;
			selecteditem= "costinfo";
			MyAllPanel mlp = new MyAllPanel(selecteditem);
			p1.removeAll();
			p1.repaint();
			p1.add(mlp);
			p1.revalidate();
			//c2.show(p3, "5");
		}
		if(e.getSource()==this.p1_label7)
		{
			selecteditem= "systeminfo";
			//selecteditem=6;
			MyAllPanel mlp = new MyAllPanel(selecteditem);
			p1.removeAll();
			p1.repaint();
			p1.add(mlp);
			p1.revalidate();
			//c2.show(p3, "6");
		}
		if(e.getSource()==this.p1_label8)
		{
			selecteditem= "videoinfo";
			//selecteditem=7;
			MyAllPanel mlp = new MyAllPanel(selecteditem);
			p1.removeAll();
			p1.repaint();
			p1.add(mlp);
			p1.revalidate();
			//c2.show(p3, "7");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.p1_label2)
		{
			this.p1_label2.setEnabled(true);
		}
		if(e.getSource()==this.p1_label3)
		{
			this.p1_label3.setEnabled(true);
		}
		if(e.getSource()==this.p1_label4)
		{
			this.p1_label4.setEnabled(true);
		}
		if(e.getSource()==this.p1_label5)
		{
			this.p1_label5.setEnabled(true);
		}
		if(e.getSource()==this.p1_label6)
		{
			this.p1_label6.setEnabled(true);
		}
		if(e.getSource()==this.p1_label7)
		{
			this.p1_label7.setEnabled(true);
		}
		if(e.getSource()==this.p1_label8)
		{
			this.p1_label8.setEnabled(true);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.p1_label2)
		{
			this.p1_label2.setEnabled(false);
		}
		if(e.getSource()==this.p1_label3)
		{
			this.p1_label3.setEnabled(false);
		}
		if(e.getSource()==this.p1_label4)
		{
			this.p1_label4.setEnabled(false);
		}
		if(e.getSource()==this.p1_label5)
		{
			this.p1_label5.setEnabled(false);
		}
		if(e.getSource()==this.p1_label6)
		{
			this.p1_label6.setEnabled(false);
		}
		if(e.getSource()==this.p1_label7)
		{
			this.p1_label7.setEnabled(false);
		}
		if(e.getSource()==this.p1_label8)
		{
			this.p1_label8.setEnabled(false);
		}
	}


}
