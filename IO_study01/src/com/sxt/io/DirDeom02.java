package com.sxt.io;

import java.io.File;

/**
 * �ݹ飺�����Լ������Լ�
 * �ݹ�ͷ�����ʽ����ݹ�
 * �ݹ��壺�ظ�����
 * ��ӡ���ＶĿ¼
 * 
 * ͳ���ļ��д�С
 * 
 * @author b.h.huang
 * @time 2020.06.17 16:21:37
 *
 */
public class DirDeom02 {
	public static void main(String[] args) {
		File dir = new File("E:/program/java/eclipse-workplace/IO_study01");
		ptintName(dir,0);
//		count(dir);
		System.out.println(len);
	}
	
	public static void ptintName(File dir,int deep) {
		//����ǰ����
		for (int i = 0; i < deep; i++) {
			System.out.print("-");
		}
		System.out.println(dir.getName());
		if (null == dir || !dir.exists()) {
			return;
		}else if (dir.isDirectory()) {//Ŀ¼
			for (File dFile : dir.listFiles()) {
				ptintName(dFile, deep+1);
			}
		}
	}
	
	private static long len = 0;
	public static void count(File dirFile) {
		//��ȡ��С
		if (null != dirFile || dirFile.exists()) {
			if (dirFile.isFile()) {
				len+=dirFile.length();
			}else {//���Ｖ
				for (File subFile : dirFile.listFiles()) {
					count(subFile);
				}
			}
		}
	}
}
