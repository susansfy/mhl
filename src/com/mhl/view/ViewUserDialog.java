/***
 * 查看人事管理详情
 */
package com.mhl.view;
import javax.swing.*;

import com.mhl.model.UserModel;

import java.awt.*;

public class ViewUserDialog extends JDialog{
	JLabel id_label,name_label,position_label,sex_label;
	JLabel id_value_label,name_value_label,position_value_label,sex_value_label;
	JPanel jp1,jp2;

	public ViewUserDialog(UserModel um,int row)
	{
		
		jp1=new JPanel();
		jp2=new JPanel();
		
		
		id_label = new JLabel(" 账号:");
		name_label = new JLabel(" 姓名:");
		position_label = new JLabel(" 职位:");
		sex_label = new JLabel(" 性别:");
		
		id_value_label = new JLabel();
		id_value_label.setText((um.getValueAt(row, 0)).toString());
		name_value_label = new JLabel();
		name_value_label.setText((um.getValueAt(row, 1)).toString());
		position_value_label = new JLabel();
		position_value_label.setText((um.getValueAt(row, 2)).toString());
		sex_value_label = new JLabel();
		sex_value_label.setText((um.getValueAt(row, 3)).toString());
		
		jp1.add(id_label);
		jp1.add(name_label);
		jp1.add(position_label);
		jp1.add(sex_label);
		
		jp2.add(id_value_label);
		jp2.add(name_value_label);
		jp2.add(position_value_label);
		jp2.add(sex_value_label);
		
		
		//gridlayout(int,int,int,int)最后两个，第一个设置横向之间的间距，第二个设置纵向之间的间距
		jp1.setLayout(new GridLayout(4,1,5,10));
		jp2.setLayout(new GridLayout(4,1,5,10));
		
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		
		this.setTitle("查看人事信息");
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-150, h/2-150);
		//setsize要放在setvisible之前，否则窗口的大小是0
		this.setSize(300, 200);
		this.setVisible(true);
		
	}

}
