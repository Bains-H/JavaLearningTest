package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * ����������
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 * 
 * @author b.h.huang
 * @time 2020.06.17 17:38:49
 *
 */
public class IOTest01 {
	public static void main(String[] args) {
		//1������Դ
		File src = new File("abc.txt");
		//2��ѡ����
		try {
			InputStream iStream = new FileInputStream(src);
			//3������
			int data1 = iStream.read();//��һ������s
			int data2 = iStream.read();//�ڶ�������x
			int data3 = iStream.read();//����������t
			int data4 = iStream.read();//???�������ݣ��ļ���ĩβ����-1
			System.out.println((char)data1);
			System.out.println((char)data2);
			System.out.println((char)data3);
			System.out.println(data4);
			//4���ͷ���Դ
			iStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
