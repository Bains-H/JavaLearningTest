package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、图片读取到字节数组中
 * 2、字节数组写出到文件
 * 
 * @author huang b.h
 * @date 2020.06.18 11:40:55
 */

public class IOTest08 {
	public static void main(String[] args) {
		byte[] datas = fileToByteArray("desk.jpg");
		System.out.println(datas.length);
		byteArrayToFile(datas, "p-desk.jpg");
	}
	
	/**
	 * 1、图片读取到字节数组
	 * 1）图片到程序 		FileInputStream
	 * 2）程序到字节数组		ByteArayOutputStream
	 */
	public static byte[] fileToByteArray(String filePath) {
		//创建源与目的地
		File src = new File(filePath);
		byte[] dest = null;
		//选择流
		InputStream inputStream = null;
		ByteArrayOutputStream baos = null;
		try {
			inputStream = new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			//操作
			byte[] flush = new byte[1024*10];//缓冲容器
			int len = -1;//接收长度
			while ((len = inputStream.read(flush)) != -1) {
				baos.write(flush,0,len);//写出到字节数组中
			}
			baos.flush();
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * 2、字节数组写出到图片
	 * 1）字节数组到程序 ByteArrayInput
	 * 2） 程序到文件 FileOutputStream
	 */
	public static void byteArrayToFile(byte[] src,String filePath) {
		File dest = new File(filePath);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new ByteArrayInputStream(src);
			outputStream = new FileOutputStream(filePath);
			byte[] flush = new byte[1024*10];
			int len = -1;
			while ((len = inputStream.read(flush)) != -1) {
				outputStream.write(flush,0,len);
			}
			outputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != outputStream) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
