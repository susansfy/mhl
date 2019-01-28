/***
 * 收银界面中间界面
 */
package com.mhl.cashview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mhl.tools.ImagePanel;
import com.mhl.tools.MyTools;
import java.awt.event.*;

public class CashPanel extends JPanel implements ActionListener{
	JButton bookbtn,cancel_bookbtn,order_dishesbtn,check_outbtn;
	JLabel title_label1,title_label2,now_user_label,user_name_label,position_label,position_name_label;
	JPanel deskpanel,infopanel,timepanel,centerpanel;
	JPanel desklistpanel,inforbtbpanel;
	JLabel deskjl1,deskjl2,deskjl3,deskjl4,deskjl5,deskjl6,deskjl7,deskjl8,deskjl9,deskjl10;
	Image info_bg;
	Image desk_bg;
	
	public CashPanel()
	{
		
			//centerpanel = new JPanel();
			this.setLayout(new BorderLayout());
			//处理左侧界面
			deskpanel = new JPanel();
			deskpanel.setLayout(null);
			
			try {
				desk_bg=ImageIO.read(new File("image\\orderindex.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ImagePanel ip_desk = new ImagePanel(desk_bg);
			ip_desk.setBounds(5, 5, 1490, 910);
			
			//处理餐桌
			desklistpanel = new JPanel(new GridLayout(3,3));
			deskjl1 = new JLabel(new ImageIcon("image\\desk\\1.jpg"));
			deskjl1.setBounds(330, 300, 150, 108);
			deskjl2 = new JLabel(new ImageIcon("image\\desk\\2.jpg"));
			deskjl2.setBounds(630, 300, 150, 108);
			deskjl3 = new JLabel(new ImageIcon("image\\desk\\3.jpg"));
			deskjl3.setBounds(930, 300, 150, 108);
			deskjl4 = new JLabel(new ImageIcon("image\\desk\\4.jpg"));
			deskjl4.setBounds(330, 450, 150, 108);
			deskjl5 = new JLabel(new ImageIcon("image\\desk\\5.jpg"));
			deskjl5.setBounds(630, 450, 150, 108);
			deskjl6 = new JLabel(new ImageIcon("image\\desk\\6.jpg"));
			deskjl6.setBounds(930, 450, 150, 108);
			deskjl7 = new JLabel(new ImageIcon("image\\desk\\7.jpg"));
			deskjl7.setBounds(330, 600, 150, 108);
			deskjl8 = new JLabel(new ImageIcon("image\\desk\\8.jpg"));
			deskjl8.setBounds(630, 600, 150, 108);
			deskjl9 = new JLabel(new ImageIcon("image\\desk\\9.jpg"));
			deskjl9.setBounds(930, 600, 150, 108);
			deskjl10 = new JLabel(new ImageIcon("image\\desk\\10.jpg"));
			deskjl10.setBounds(630, 750, 150, 108);
			
			deskpanel.add(deskjl1);
			deskpanel.add(deskjl2);
			deskpanel.add(deskjl3);
			deskpanel.add(deskjl4);
			deskpanel.add(deskjl5);
			deskpanel.add(deskjl6);
			deskpanel.add(deskjl7);
			deskpanel.add(deskjl8);
			deskpanel.add(deskjl9);
			deskpanel.add(deskjl10);
			deskpanel.add(ip_desk);
			
			//处理右侧界面
			infopanel = new JPanel();
			//infopanel.setLayout(new BorderLayout());
			infopanel.setLayout(null);
			infopanel.setPreferredSize(new Dimension(400,900));
			bookbtn = new JButton("预定");
			bookbtn.setBounds(35, 700, 100, 50);
			cancel_bookbtn = new JButton("退定");
			cancel_bookbtn.setBounds(220,700,100,50);
			order_dishesbtn = new JButton("点菜");
			order_dishesbtn.setBounds(35, 800, 100, 50);
			check_outbtn = new JButton("结账");
			check_outbtn.setBounds(220, 800, 100, 50);
			infopanel.add(bookbtn);
			infopanel.add(cancel_bookbtn);
			infopanel.add(order_dishesbtn);
			infopanel.add(check_outbtn);
			
			//标题label
			title_label1 = new JLabel("满汉楼");
			title_label1.setFont(new MyTools().f3);
			title_label1.setBounds(110,80,100,30);
			title_label2 = new JLabel("餐饮管理系统");
			title_label2.setBounds(110, 110, 100, 30);
			infopanel.add(title_label1);
			infopanel.add(title_label2);
			
			//信息label
			now_user_label = new JLabel("当前用户:");
			now_user_label.setBounds(50, 300, 100, 50);
			user_name_label = new JLabel("??");
			user_name_label.setBounds(150, 300, 100, 50);
			position_label = new JLabel("职位:");
			position_label.setBounds(50, 400, 100, 50);
			position_name_label = new JLabel("??");
			position_name_label.setBounds(150, 400, 100, 50);
			infopanel.add(now_user_label);
			infopanel.add(user_name_label);
			infopanel.add(position_label);
			infopanel.add(position_name_label);
			
			try {
				info_bg=ImageIO.read(new File("image\\manage.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ImagePanel ip_info = new ImagePanel(info_bg);
			ip_info.setBounds(5, 5, 400, 900);	
			
			
			
			infopanel.add(ip_info);
			
			//处理center
			this.add(deskpanel,"Center");
			this.add(infopanel,"East");
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
