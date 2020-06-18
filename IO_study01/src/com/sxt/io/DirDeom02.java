package com.sxt.io;

import java.io.File;

/**
 * 递归：方法自己调用自己
 * 递归头：合适结束递归
 * 递归体：重复调用
 * 打印子孙级目录
 * 
 * 统计文件夹大小
 * 
 * @author b.h.huang
 * @time 2020.06.17 16:21:37
 *
 */
public class DirDeom02 {
	public static void main(String[] args) {
		File dir = new File("E:/program/java/eclipse-workplace/IO_study01");
		ptintName(dir,0);
//		count(dir);
		System.out.println(len);
	}
	
	public static void ptintName(File dir,int deep) {
		//控制前面层次
		for (int i = 0; i < deep; i++) {
			System.out.print("-");
		}
		System.out.println(dir.getName());
		if (null == dir || !dir.exists()) {
			return;
		}else if (dir.isDirectory()) {//目录
			for (File dFile : dir.listFiles()) {
				ptintName(dFile, deep+1);
			}
		}
	}
	
	private static long len = 0;
	public static void count(File dirFile) {
		//获取大小
		if (null != dirFile || dirFile.exists()) {
			if (dirFile.isFile()) {
				len+=dirFile.length();
			}else {//子孙级
				for (File subFile : dirFile.listFiles()) {
					count(subFile);
				}
			}
		}
	}
}
