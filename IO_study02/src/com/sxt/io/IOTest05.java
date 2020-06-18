package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * �ļ��ַ�������
 *  * 1������Դ
 * 2��ѡ����
 * 3����������ȡ���ݣ�
 * 4���ͷ���Դ
 * 
 * @author b.h.huang
 * @time 2020.06.17 18:08:08
 *
 */
public class IOTest05 {
	public static void main(String[] args) {
		//1������Դ
		File srcFile = new File("abc.txt");
		File copyFile = new File("dest.txt");
		//2.ѡ����
		Reader reader = null;
		Writer writer = null;
		try {
			reader = new FileReader(srcFile);
			writer = new FileWriter(copyFile);
			//3����������ȡ��
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
					//4���ͷ���Դ
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
