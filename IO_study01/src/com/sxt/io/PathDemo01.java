package com.sxt.io;

import java.io.File;

/**
 * @author b.h.huang
 * @time 2020.06.16 18:28:11
 *
 */
public class PathDemo01 {
	/**
	 * \/名称分隔符 separator
	 */
	public static void main(String[] args) {
		String path = "D:\\java300\\IO_study01\\IO.png";
		System.out.println(File.separatorChar);
		
		//建议
		//1、/
		path = "D:/java300/IO_study01/IO.png";
		System.out.println(path);
		//2、常量拼接
		path = "D:"+File.separator+"java300"+File.separator+"IO_study01"+File.separator+
				"IO.png";
		System.out.println(path);
	}
}
