package com.sxt.io;

import java.io.File;

/**
 * @author b.h.huang
 * @time 2020.06.16 18:36:41
 *
 */
public class FlieDemo01 {
	/**
	 * ����File����
	 * ���·�������·��
	 *  �����̷�������·��
	 *  �������̷�:���·��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "E:/program/java/eclipse-workplace/MyPro01/images/ball.png";
		
//		//1������File����
//		File src = new File(path);
//		System.out.println(src.length());
//		
//		//2������File����
//		src = new File("E:/program/java/eclipse-workplace/MyPro01/images","ball.png");
//		System.out.println(src.length());
//		
//		//3������File����
//		src = new File(new File("E:/program/java/eclipse-workplace/MyPro01/images"),"ball.png");
//		System.out.println(src.length());
		
		//����·��
		File src = new File(path);
		System.out.println(src.getAbsolutePath());
		
		//���·��
		System.out.println(System.getProperty("user.dir"));
		src = new File("ball.png");
		System.out.println(src.getAbsolutePath());
	}
}
