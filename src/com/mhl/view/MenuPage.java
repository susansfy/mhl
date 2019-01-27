/***
 * 菜谱价格界面
 */
package com.mhl.view;
import java.awt.*;
import java.awt.event.*;
import com.mhl.model.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MenuPage extends JPanel implements ActionListener{
	
	JPanel p1,p2,p3,p4,p5;
	JLabel p1_label1,p3_label;
	JTextField p1_jtf1;
	JButton p1_bt1,p4_bt1,p4_bt2,p4_bt3;
	JTable jt;
	JScrollPane jsp;
	MenuModel mm;
	int row_num;
	JComboBox jcb;
	String sql;
	String[] params;
	
	public MenuPage()
	{
		//处理顶部p1
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_label1 = new JLabel("请输入菜谱名称查询:");
		p1_jtf1 = new JTextField(30);
		p1_bt1 = new JButton("查询");
		p1_bt1.addActionListener(this);
		String[] category = {"全部","甜点类","主食类","汤类","饮料类"};
		jcb = new JComboBox(category);
		
		p1.add(p1_label1);
		p1.add(p1_jtf1);
		p1.add(jcb);
		p1.add(p1_bt1);
		
		//处理底部p3,p4,p5
		p5=new JPanel(new BorderLayout());
		p3=new JPanel(new FlowLayout());
		p4=new JPanel(new FlowLayout());
		
		p4_bt1 = new JButton("添加");
		p4_bt1.addActionListener(this);
		p4_bt2 = new JButton("修改");
		p4_bt2.addActionListener(this);
		p4_bt3 = new JButton("删除");
		p4_bt3.addActionListener(this);
		
		p4.add(p4_bt1);
		p4.add(p4_bt2);
		p4.add(p4_bt3);
		
		p5.add(p3,"West");
		p5.add(p4,"East");
		
		//处理p2
		p2 = new JPanel();
		p2.setBorder(BorderFactory.createTitledBorder("菜谱管理"));
		p2.setLayout(new BorderLayout());
		
		mm=new MenuModel();
		String[] params2 = {"1"};
		mm.querymenu("select * from menu where 1=?", params2);		
		jt = new JTable(mm);
		//设置jtable的行高
		jt.setRowHeight(30);
		//设置jtable自适应列宽
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		//创建一个不占空间的边框来填满，使滚动条边框不出来
		Border js = BorderFactory.createEmptyBorder();
		jsp = new JScrollPane(jt);
		jsp.setBorder(js);
		p2.add(jsp,"Center");
		
		row_num = mm.getRowCount();
		p3_label = new JLabel("共有"+row_num+"行数据");
		p3.add(p3_label);
		
		this.setLayout(new BorderLayout());
		this.add(p1,"North");
		this.add(p5, "South");
		this.add(p2, "Center");
		this.setVisible(true);
		//this.setBackground(Color.RED);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//添加按钮
		if(e.getSource()==p4_bt1)
		{
			AddMenuDialog amd = new AddMenuDialog(null,"添加菜单",true);
			//构造新的数据模型类，并更新
			mm=new MenuModel();
			String[] params2 = {"1"};
			mm.querymenu("select * from menu where 1=?", params2);
			
			//更新JTable
			jt.setModel(mm);
			//根据查询的结果，变更左下角的行数
			row_num = mm.getRowCount();
			this.p3_label.setText("共有"+row_num+"行数据");
			
		}
		//查询按钮
		if(e.getSource()==p1_bt1)
		{
			
			String name = "%"+p1_jtf1.getText().trim()+"%";
			String selecteditem;
			if(jcb.getSelectedIndex()==0)
			{
				selecteditem="%%";
			}else {
			selecteditem = "%"+jcb.getSelectedItem().toString()+"%";
			}
			sql = "select * from menu where foodname like ? and category like ?";
			params = new String[] {name,selecteditem};
			//构造新的数据模型类，并更新
			mm=new MenuModel();
			mm.querymenu(sql,params);
			//更新JTable
			jt.setModel(mm);
			//根据查询的结果，变更左下角的行数
			row_num = mm.getRowCount();
			this.p3_label.setText("共有"+row_num+"行数据");
					
		}
		
	}


}
