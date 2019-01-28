/***
 * 收银界面
 */
package com.mhl.cashview;
import com.mhl.tools.*;
import com.mhl.view.Window1;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class CashDeskPage extends JFrame implements ActionListener,MouseListener{
	JMenuBar menubar;
	JMenu sysmenu,servicemenu,helpmenu;
	//todo:JMenuItem 
	JToolBar toolbar;
	JButton switchuserbtn,clientbtn,helpbtn;
	
	Container c;
	
	JPanel deskpanel,infopanel,timepanel,centerpanel;

	JLabel timenow;
	javax.swing.Timer t;
	Image titleimage,timeimage,timebg;
	
	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CashDeskPage cp = new CashDeskPage();
	}
	
	public void menu()
	{
		menubar = new JMenuBar();
		sysmenu = new JMenu("系统");
		servicemenu = new JMenu("服务");
		helpmenu = new JMenu("帮助");
		menubar.add(sysmenu);
		menubar.add(servicemenu);
		menubar.add(helpmenu);
		
		this.setJMenuBar(menubar);
		
	}
	
	public void toolbar()
	{
		toolbar = new JToolBar();
		toolbar.setFloatable(false);
		switchuserbtn = new JButton(new ImageIcon("image\\toolBar_image\\jb1.jpg"));
		clientbtn = new JButton(new ImageIcon("image\\\\toolBar_image\\\\jb2.jpg"));
		helpbtn = new JButton(new ImageIcon("image\\toolBar_image\\jb10.jpg"));
		toolbar.add(switchuserbtn);
		toolbar.add(clientbtn);
		toolbar.add(helpbtn);
	}
	

	
	
	public CashDeskPage()
	{
		//处理界面标题icon
		try {
			titleimage = ImageIO.read(new File("image\\title.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//处理timepanel
		timepanel = new JPanel(new BorderLayout());
		t = new Timer(1000,this);
		t.start();
		timenow = new JLabel(Calendar.getInstance().getTime().toString());
		try {
			timebg = ImageIO.read(new File("image\\time_bg.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImagePanel ip1 = new ImagePanel(timebg);
		ip1.setLayout(new BorderLayout());
		ip1.add(timenow,"East");
		timepanel.add(ip1);
		
		
		this.menu();
		this.toolbar();
		
		
		c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(toolbar,"North");
		c.add(timepanel,"South");
		c.add(new CashPanel(),"Center");
		
//		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width, height-30);
		this.setTitle("收银台");
		this.setIconImage(titleimage);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.timenow.setText("当前时间："+Calendar.getInstance().getTime().toString());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
