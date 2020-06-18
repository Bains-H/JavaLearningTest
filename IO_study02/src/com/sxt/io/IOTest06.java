package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ֽ�����������
 *  * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 * 
 * @author b.h.huang
 * @time 2020.06.17 18:08:08
 *
 */
public class IOTest06 {
	public static void main(String[] args) {
		//1������Դ
		byte[] src = "talk is cheap show m the code".getBytes();
		File copyFile = new File("dest.txt");
		//2.ѡ����
		InputStream inputStream = null;
		try {
			inputStream = new ByteArrayInputStream(src);
			//3����������ȡ��
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
					//4���ͷ���Դ
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
