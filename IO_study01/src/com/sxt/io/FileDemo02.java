package com.sxt.io;

import java.io.File;
import java.io.IOException;

/**
 * 
 * 名称或路径
 * getName():名称
 * getPath():路径
 * getAbsolutePath():绝对路径
 * getParent():父路径
 * 
 * 文件的状态
 * 1、不存在：exists
 * 2、存在
 * 		文件：isFile
 * 		文件夹：isDirctory
 * 
 * 其他信息
 * length():字节数
 * createNewFile():不存在才创建，存在创建成功
 * delete():删除已经存在的文件
 * 
 * @author b.h.huang
 * @time 2020.06.17 15:50:38
 *
 */
public class FileDemo02 {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File src = new File("E:/program/java/eclipse-workplace/MyPro01/images/ball.png");
		
		//基本信息
		System.out.println("基本信息");
		System.out.println("名称："+src.getName());
		System.out.println("路径："+src.getPath());
		System.out.println("绝对路径："+src.getAbsolutePath());
		System.out.println("父路径："+src.getParent());
		System.out.println("父对象："+src.getParentFile());
		
		//文件状态
		System.out.println("文件状态");
		
		//完整的文件状态
//		src = new File("xxx");
		if (null == src || !src.exists()) {
			System.out.println("文件不存在");
		}else {
			if (src.isFile()) {
				System.out.println("文件操作");
			}else {
				System.out.println("文件夹操作");
			}
		}
		
		//其他信息
		System.out.println("其他信息");
		System.out.println("长度："+src.length());
		boolean flag = src.createNewFile();
		System.out.println(flag);
		
		//不是文件夹
		src = new File("E:/program/java/eclipse-workplace/IO_study01/io.txt");
		flag = src.createNewFile();
		System.out.println(flag);
		
		flag = src.delete();
		System.err.println(flag);
		
		//补充:con com3...操作系统的设备名，不能正确创建
		src = new File("E:/program/java/eclipse-workplace/IO_study01/con");
		flag = src.createNewFile();
		System.out.println(flag);
	}
}
