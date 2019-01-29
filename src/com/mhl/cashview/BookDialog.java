/***
 * 预定界面
 */
package com.mhl.cashview;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import com.mhl.model.*;

public class BookDialog extends Dialog implements ActionListener{
	
	JLabel usernamejl,userphonejl,deskidjl,booktimejl;
	JTextField usernamejtf,userphonejtf,booktimejtf;
	JComboBox deskjcb;
	JPanel labeljp,textjp,btnjp;

	public BookDialog(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
		
		usernamejl = new JLabel("用户名称：");
		userphonejl = new JLabel("用户电话：");
		deskidjl = new JLabel("预定餐桌号：");
		booktimejl = new JLabel("预定时间:");
		labeljp = new JPanel(new GridLayout(4,1));
		labeljp.add(usernamejl);
		labeljp.add(userphonejl);
		labeljp.add(deskidjl);
		labeljp.add(booktimejl);
		
		textjp = new JPanel(new GridLayout(4,1));
		usernamejtf = new JTextField(30);
		userphonejtf = new JTextField(30);
		booktimejtf = new JTextField(30);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
