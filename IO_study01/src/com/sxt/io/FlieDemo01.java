package com.sxt.io;

import java.io.File;

/**
 * @author b.h.huang
 * @time 2020.06.16 18:36:41
 *
 */
public class FlieDemo01 {
	/**
	 * 构建File对象
	 * 相对路径与绝对路径
	 *  存在盘符：绝对路径
	 *  不存在盘符:相对路径
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "E:/program/java/eclipse-workplace/MyPro01/images/ball.png";
		
//		//1、构建File对象
//		File src = new File(path);
//		System.out.println(src.length());
//		
//		//2、构建File对象
//		src = new File("E:/program/java/eclipse-workplace/MyPro01/images","ball.png");
//		System.out.println(src.length());
//		
//		//3、构建File对象
//		src = new File(new File("E:/program/java/eclipse-workplace/MyPro01/images"),"ball.png");
//		System.out.println(src.length());
		
		//绝对路径
		File src = new File(path);
		System.out.println(src.getAbsolutePath());
		
		//相对路径
		System.out.println(System.getProperty("user.dir"));
		src = new File("ball.png");
		System.out.println(src.getAbsolutePath());
	}
}
