package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组输入流
 *  * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * 
 * @author b.h.huang
 * @time 2020.06.17 18:08:08
 *
 */
public class IOTest06 {
	public static void main(String[] args) {
		//1、创建源
		byte[] src = "talk is cheap show m the code".getBytes();
		File copyFile = new File("dest.txt");
		//2.选择流
		InputStream inputStream = null;
		try {
			inputStream = new ByteArrayInputStream(src);
			//3、操作（读取）
			byte[] flush = new byte[5];
			int len = -1;
			while ((len = inputStream.read(flush)) != -1) {
				String string = new String(flush,0,len);
				System.out.println(string);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					//4、释放资源
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
