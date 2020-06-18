package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、封装拷贝
 * 2、封装释放
 * @author huang b.h
 * @date 2020.06.18 13:30:22
 */

public class FileUtils2 {
	public static void main(String[] args) {
		//文件到文件
		try {
			InputStream is = new FileInputStream("abc.txt");
			OutputStream os = new FileOutputStream("abc-copy.txt");
			copy(is, os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//文件到字节数组
		byte[] datas = null;
		try {
			InputStream is = new FileInputStream("desk.jpg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is, os);
			datas = os.toByteArray();
			System.out.println(datas.length);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//字节数组到文件
		try {
			ByteArrayInputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("desk-copy.jpg");
			copy(is, os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 对接输入输出流
	 * try ...with...resource 
	 * jdk8中 try()里的资源必须单独声明
	 */
	public static void copy(InputStream is,OutputStream os) {
		try(InputStream is1 = is; OutputStream os1 = os) {
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = is1.read(flush)) != -1) {
				os1.write(flush,0,len);
			}
			os1.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
