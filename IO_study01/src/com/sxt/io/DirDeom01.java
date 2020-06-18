package com.sxt.io;

import java.io.File;

/**
 * 创建目录
 * 1、mkdir();确保上级目录存在，不存在创建失败
 * 2、mkdirs():上级目录可以不存在，不存在一同来创建
 * 
 * 列出下一级
 * 1、list():列出下级名称
 * 2、listFiles():列出下级File对象
 * 
 * 列出所有盘符：listRoots()
 * 
 * @author b.h.huang
 * @time 2020.06.17 16:21:37
 *
 */
public class DirDeom01 {
	public static void main(String[] args) {
		File dir = new File("E:/program/java/eclipse-workplace/IO_study01/dir/test");
		
		//创建目录
		System.out.println("创建目录");
		//创建目录推荐使用mkdirs()
		boolean flag = dir.mkdirs();
		System.out.println(flag);
		//创建目录mkdir()
		dir = new File("E:/program/java/eclipse-workplace/IO_study01/dir2/test2");
		flag = dir.mkdir();
		System.out.println(flag);
		
		//列出下一级
		System.out.println("列出下一级");
		dir = new File("E:/program/java/eclipse-workplace/IO_study01/");
		//列出下一级名称 list
		String[] subName = dir.list();
		for (String string : subName) {
			System.out.println(string);
		}
		//下级对象 listFiles()
		File[] subFiles = dir.listFiles();
		for (File file : subFiles) {
			System.out.println(file);
		}
		
		//所有盘符
		File[] rootsFiles = dir.listRoots();
		for (File rootFile : rootsFiles) {
			System.out.println(rootFile);
		}
	}
}
