package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件字节输入流  分段读取
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * 
 * @author b.h.huang
 * @time 2020.06.17 17:38:49
 *
 */
public class IOTest03 {
	public static void main(String[] args) {
		//1、创建源
		File src = new File("abc.txt");
		//2、选择流
		InputStream iStream = null;
		try {
			iStream = new FileInputStream(src);
			//3、操作(分段读取)
			byte[] flush = new byte[3]; //缓存容器
			int len = -1;//接收长度
			while ((len=iStream.read(flush))!=-1) {
				//字节数组-->字符串（解码）
				String string = new String(flush,0,len);
				System.out.print(string);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//4、释放资源
			try {
				if (null!=iStream) {
					iStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
