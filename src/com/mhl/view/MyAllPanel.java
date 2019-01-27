/***
 * 重置中间的画面
 */
package com.mhl.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.mhl.tools.ImagePanel;

public class MyAllPanel extends JSplitPane implements ActionListener,MouseListener{
	
	JPanel p1,p2,p3,p4,p5;
	JLabel p1_label1,p1_label2,p1_label3,p1_label4,p1_label5,p1_label6,p1_label7,p1_label8;
	CardLayout c1,c2;
	JLabel p2_label1,p2_label2;
	ImageIcon p3_image1,p3_image2,p3_image3,p3_image4,p3_image5,p3_image6,p3_image7;
	JLabel p3_label2,p3_label3,p3_label4,p3_label5,p3_label6,p3_label7,p3_label1;
	JPanel p3_jp1,p3_menujp;
	//JSplitPane jsp;
	Cursor cs;
	Image p1_bg;
	//int selecteditem;
	
	public MyAllPanel(String selecteditem)
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
		
		//处理p2,p3,p4
		c1 = new CardLayout();
		c2 = new CardLayout();
		p4 = new JPanel(new BorderLayout());
		//p4.setPreferredSize(new Dimension(100,100));
		p2 = new JPanel(c1);
		p3 = new JPanel(c2);
		//p3.setPreferredSize(new Dimension(100,100));;
		p4.add(p2,"West");
		p4.add(p3,"Center");
		
		//处理p2，两个方向的箭头
		p2_label1 = new JLabel(new ImageIcon("image\\center_image\\jp2_left.jpg"));
		p2_label2 = new JLabel(new ImageIcon("image\\center_image\\jp2_right.jpg"));
		p2.add(p2_label1,"left");
		p2.add(p2_label2,"right");
		
		//处理p3,
		//先给界面贴图片，实验过后再换成实际的列表界面
		
		p3_label1 = new JLabel(new ImageIcon("image\\jp3_test\\jp3_1.jpg"));
		p3_label2 = new JLabel(new ImageIcon("image\\jp3_test\\jp3_2.jpg"));
		p3_label3 = new JLabel(new ImageIcon("image\\jp3_test\\jp3_3.jpg"));
		p3_label4 = new JLabel(new ImageIcon("image\\jp3_test\\jp3_4.jpg"));
		p3_label5 = new JLabel(new ImageIcon("image\\jp3_test\\jp3_5.jpg"));
		p3_label6 = new JLabel(new ImageIcon("image\\jp3_test\\jp3_6.jpg"));
		p3_label7 = new JLabel(new ImageIcon("image\\jp3_test\\jp3_7.jpg"));
		
		p3_jp1 = new UserPage();
		p3_menujp = new MenuPage();
//		p3.add(p3_jp1,"1");
//
//		//p3.add(p3_label1,"1");
//		p3.add(p3_label2,"2");
//		p3.add(p3_label3,"3");
//		p3.add(p3_label4,"4");
//		p3.add(p3_label5,"5");
//		p3.add(p3_label6,"6");
//		p3.add(p3_label7,"7");
		
		if(selecteditem.equals("userinfo"))
		{
			p3.add(p3_jp1,"1");
			p3.add(p3_label2,"2");
			p3.add(p3_menujp,"3");
			p3.add(p3_label4,"4");
			p3.add(p3_label5,"5");
			p3.add(p3_label6,"6");
			p3.add(p3_label7,"7");
		}else if(selecteditem.equals("logininfo")){
		
			p3.add(p3_label2,"2");
			p3.add(p3_jp1,"1");
			p3.add(p3_menujp,"3");
			p3.add(p3_label4,"4");
			p3.add(p3_label5,"5");
			p3.add(p3_label6,"6");
			p3.add(p3_label7,"7");
		}else if(selecteditem.equals("menuinfo")){
		
			p3.add(p3_menujp,"3");
			p3.add(p3_label2,"2");
			p3.add(p3_jp1,"1");
			
			p3.add(p3_label4,"4");
			p3.add(p3_label5,"5");
			p3.add(p3_label6,"6");
			p3.add(p3_label7,"7");
		}else if(selecteditem.equals("reportinfo")){
		
			p3.add(p3_label4,"4");
			p3.add(p3_label2,"2");
			p3.add(p3_jp1,"1");
			p3.add(p3_menujp,"3");
			
			p3.add(p3_label5,"5");
			p3.add(p3_label6,"6");
			p3.add(p3_label7,"7");
		}else if(selecteditem.equals("costinfo")){
		
			p3.add(p3_label5,"5");
			p3.add(p3_label2,"2");
			p3.add(p3_jp1,"1");
			p3.add(p3_menujp,"3");
			p3.add(p3_label4,"4");
			
			p3.add(p3_label6,"6");
			p3.add(p3_label7,"7");
		}else if(selecteditem.equals("systeminfo")){
		
			p3.add(p3_label6,"6");
			p3.add(p3_label2,"2");
			p3.add(p3_jp1,"1");
			p3.add(p3_menujp,"3");
			p3.add(p3_label4,"4");
			p3.add(p3_label5,"5");
			
			p3.add(p3_label7,"7");
		}else if(selecteditem.equals("vedioinfo")){
		
			p3.add(p3_label7,"7");
			p3.add(p3_label2,"2");
			p3.add(p3_jp1,"1");
			p3.add(p3_menujp,"3");
			p3.add(p3_label4,"4");
			p3.add(p3_label5,"5");
			p3.add(p3_label6,"6");
			
		}
		
		
		
		//拆分布局，放p1,p2,p3
//		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,p1,p4);
//		jsp.setDividerLocation(120);
		//jsp.setDividerSize(0);
		this.setLeftComponent(p1);
		this.setRightComponent(p4);
		this.setDividerLocation(120);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.p1_label2)
		{
			c2.show(p3, "1");
		}
		if(e.getSource()==this.p1_label3)
		{
			c2.show(p3, "2");
		}
		if(e.getSource()==this.p1_label4)
		{
			c2.show(p3, "3");
		}
		if(e.getSource()==this.p1_label5)
		{
			c2.show(p3, "4");
		}
		if(e.getSource()==this.p1_label6)
		{
			c2.show(p3, "5");
		}
		if(e.getSource()==this.p1_label7)
		{
			c2.show(p3, "6");
		}
		if(e.getSource()==this.p1_label8)
		{
			c2.show(p3, "7");
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
