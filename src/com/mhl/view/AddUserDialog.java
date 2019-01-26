package com.mhl.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.mhl.model.*;

public class AddUserDialog extends JDialog implements ActionListener{
	
	JLabel jl1,jl2,jl3,jl4;
	JTextField jt1,jt2,jt3,jt4;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3;

	
	public AddUserDialog(Frame owner, String title, boolean modal)
	{
		//创建一个具有指定标题的对话框，所有者为 Frame和模态。
		//可设置JFrame为空
		super(owner,title,modal);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jl1 = new JLabel(" 账号:");
		jl2 = new JLabel(" 姓名:");
		jl3 = new JLabel(" 职位:");
		jl4 = new JLabel(" 性别:");
		
		jt1=new JTextField();
		//jt1.setSize(30,10);
		jt2=new JTextField();
		jt3=new JTextField();
		jt4=new JTextField();
		
		jb1=new JButton("添加");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		
		jp2.add(jt1);
		jp2.add(jt2);
		jp2.add(jt3);
		jp2.add(jt4);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//gridlayout(int,int,int,int)最后两个，第一个设置横向之间的间距，第二个设置纵向之间的间距
		jp1.setLayout(new GridLayout(4,1,5,10));
		jp2.setLayout(new GridLayout(4,1,5,10));
		
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		this.setTitle(title);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-150, h/2-150);
		//setsize要放在setvisible之前，否则窗口的大小是0
		this.setSize(300, 200);
		this.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//添加按钮
		if(e.getSource()==jb1)
		{
			//判断输入框中的值是否为空
			//如果为空，则给出提示
			if(jt1.getText().trim().length()<1 | jt2.getText().trim().length()<1 |
					jt3.getText().trim().length()<1 |jt4.getText().trim().length()<1 )
			{
				JOptionPane.showMessageDialog(this, "信息未填写完整");
			}else {
			UserModel temp = new UserModel();
			String sql = "insert into user values(?,?,?,?)";
			String[] params={jt1.getText(),jt2.getText(),jt3.getText(),jt4.getText()};
			boolean b = temp.updateuser(sql, params);
			if(!b)
			{
				JOptionPane.showMessageDialog(this, "添加失败");
			}else {
			JOptionPane.showMessageDialog(this, "添加成功");
			this.dispose();
			
			}
			}
		}
		if(e.getSource()==jb2)
		{
			this.setVisible(false);
		}
	}

}
