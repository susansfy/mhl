/***
 * 登录界面
 */
package com.mhl.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import com.mhl.model.*;

public class LoginPage extends JDialog implements ActionListener{
	
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtf1;
	JPasswordField jpf;
	JButton jb1,jb2;
	Font f1 = new Font("宋体",Font.PLAIN,16);
	Font f2 = new Font("宋体",Font.PLAIN,12);
	Image img;
	int width,height;
	
	public static void main(String[] args)
	{
		LoginPage lp=new LoginPage();
	}
	
	public LoginPage() 
	{
		Container c = this.getContentPane();
		this.setLayout(null);
		//不要上下框
		this.setUndecorated(true);
		
		jl1 = new JLabel("请输入用户名：");
		jl1.setFont(f1);
		jl1.setBounds(60, 190, 150, 30);
		c.add(jl1);
		
		jl2 = new JLabel("请输入密码：");
		jl2.setFont(f1);
		jl2.setBounds(60,240,150,30);
		c.add(jl2);
		
		jl3 = new JLabel("（或员工号）");
		jl3.setForeground(Color.red);
		jl3.setFont(f2);
		jl3.setBounds(100, 210, 100, 30);
		c.add(jl3);
		
		jtf1 = new JTextField();
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		jtf1.setBounds(180,190,120,30);
		c.add(jtf1);
		
		jpf = new JPasswordField();
		jpf.setBorder(BorderFactory.createLoweredBevelBorder());
		jpf.setBounds(180, 240, 120, 30);
		c.add(jpf);
		
		jl4 = new JLabel();
		jl4.setForeground(Color.red);
		jl4.setFont(f2);
		jl4.setBounds(180, 270, 200, 30);
		c.add(jl4);
		
		jb1 = new JButton("确定");
		jb1.addActionListener(this);
		jb1.setBounds(110, 300, 70, 30);
		c.add(jb1);
		
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jb2.setBounds(250, 300, 70, 30);
		c.add(jb2);
		
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-150);
		
		BackImage bi = new BackImage();
		bi.setBounds(0,0,360,360);
		c.add(bi);
		
		
		this.setSize(360, 360);
		this.setVisible(true);
	
	}
	
	//内部类
	class BackImage extends JPanel
	{
		Image img;
		public BackImage()
		{
			try {
				img = ImageIO.read(new File("image//login.gif"));
				//System.out.println("hello");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void paintComponent(Graphics g)
		{
			g.drawImage(img, 0, 0, 360, 360, this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			//System.out.println("hello");
			//String userid = jtf1.getText().toString().trim();
			String userid = jtf1.getText().toString();
			String p = new String(this.jpf.getPassword());
			
			LoginModel um=new LoginModel();
			String position = um.checkUser(userid, p);
			if(position.equals("经理") || position.equals("主管") ||position.equals("管理员"))
			{
				new Window1();
				this.dispose();
			}else {
				//如果职位不是以上，则提示权限不足
				jl4.setText("权限不足");
			}
			
		}else if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}

}
