/***
 * 满汉楼
 * 闪屏页
 */
package com.mhl.view;

import java.awt.*;

import javax.swing.*;

public class Index extends JWindow implements Runnable{
	
	int width,height;
	JProgressBar jpb;
	JLabel jl ;
	Font f1 = new Font("宋体",Font.PLAIN,12);
	Font f2 = new Font("宋体",Font.PLAIN,16);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Index ind = new Index();
		Thread t = new Thread(ind);
		t.start();
	}
	
	public Index()
	{
		
		this.setSize(400, 260);
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-150);
		
		
		
		jl=new JLabel(new ImageIcon("image//index.jpg"));
		
		jpb=new JProgressBar();
		jpb.setStringPainted(true);
		jpb.setIndeterminate(false);
		jpb.setBorderPainted(false);
		jpb.setBackground(Color.blue);
		jpb.setFont(f1);
		
		this.add(jl,BorderLayout.NORTH);
		this.add(jpb, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//String[] ss= {"系","统","正","在","加","载","中","，请","稍","等"};
		//StringBuilder name=null;
		int[] ss= {5,10,15,20,50,80,100};
		for(int i=0;i<ss.length;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//name.append(ss[i]);
			jpb.setValue(ss[i]);
			//System.out.println(ss[i]);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new LoginPage();
		System.out.println("index page");
		this.dispose();
		
	}

}


	
