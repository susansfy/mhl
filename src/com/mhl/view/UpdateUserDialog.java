/***
 * 修改人事管理界面
 */
package com.mhl.view;
import javax.swing.*;

import com.mhl.model.UserModel;

import java.awt.*;
import java.awt.event.*;

public class UpdateUserDialog extends JDialog implements ActionListener{
	
	JLabel jl1,jl2,jl3,jl4;
	JTextField jt1,jt2,jt3,jt4;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3;

	
	public UpdateUserDialog(Frame owner, String title, boolean modal,UserModel um,int rownum)
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
		jt1.setEditable(false);
		jt1.setText((um.getValueAt(rownum, 0)).toString());
		jt2=new JTextField();
		jt2.setText((um.getValueAt(rownum, 1)).toString());
		jt3=new JTextField();
		jt3.setText((um.getValueAt(rownum, 2)).toString());
		jt4=new JTextField();
		jt4.setText((um.getValueAt(rownum, 3)).toString());
		
		jb1=new JButton("修改");
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
		//修改按钮
		if(e.getSource()==jb1)
		{
			UserModel temp=new UserModel();
			String sql="update user set name=?,position=?,sex=? where id=?";
			String[] params={jt2.getText(),jt3.getText(),jt4.getText(),jt1.getText()};
			if(!temp.updateuser(sql, params))
			{
				JOptionPane.showMessageDialog(this, "修改失败");
			}
			JOptionPane.showMessageDialog(this, "修改成功");
			this.dispose();
		}
		if(e.getSource()==jb2)
		{
			this.setVisible(false);
		}
	}

}
