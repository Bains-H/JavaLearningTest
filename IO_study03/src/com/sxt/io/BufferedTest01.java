package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件字节输入流 加入缓存流
 *
 * @author B.H.Huang
 * @date 2020.06.18 15:21:22 
 *
 */
public class BufferedTest01 {
	public static void main(String[] args) {
		File src = new File("abc.txt");
		InputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(src));
			byte[] flush = new byte[1024*10];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				String string = new String(flush,0,len);
				System.out.println(string);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
