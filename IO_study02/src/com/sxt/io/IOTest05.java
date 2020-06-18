package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 文件字符输入流
 *  * 1、创建源
 * 2、选择流
 * 3、操作（读取内容）
 * 4、释放资源
 * 
 * @author b.h.huang
 * @time 2020.06.17 18:08:08
 *
 */
public class IOTest05 {
	public static void main(String[] args) {
		//1、创建源
		File srcFile = new File("abc.txt");
		File copyFile = new File("dest.txt");
		//2.选择流
		Reader reader = null;
		Writer writer = null;
		try {
			reader = new FileReader(srcFile);
			writer = new FileWriter(copyFile);
			//3、操作（读取）
			char[] flush = new char[1024];
			int len = -1;
			while ((len = reader.read(flush)) != -1) {
//				String string = new String(flush,0,len);
				writer.append(new String(flush,0,len));
//				writer.write(flush,0,len);
//				writer.write(flush);
				writer.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != writer) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != reader) {
				try {
					//4、释放资源
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
