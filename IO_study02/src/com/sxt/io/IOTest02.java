package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * ���������� ��׼
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 * 
 * @author b.h.huang
 * @time 2020.06.17 17:38:49
 *
 */
public class IOTest02 {
	public static void main(String[] args) {
		//1������Դ
		File src = new File("abc.txt");
		//2��ѡ����
		InputStream iStream = null;
		try {
			iStream = new FileInputStream(src);
			//3������(��ȡ)
			int temp;
			while ((temp=iStream.read())!=-1) {
				System.out.println((char)temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//4���ͷ���Դ
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
