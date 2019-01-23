/***
 * 动态加载图片做背景的JPanel
 */
package com.mhl.tools;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class ImagePanel extends JPanel{
	Image im;
	
	//指定JPanel大小
	public ImagePanel(Image im)
	{
		this.im=im;
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(w,h);
	}
	//画出背景
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	

}
