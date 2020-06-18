package com.sxt.io;

import java.io.File;

/**
 * ����Ŀ¼
 * 1��mkdir();ȷ���ϼ�Ŀ¼���ڣ������ڴ���ʧ��
 * 2��mkdirs():�ϼ�Ŀ¼���Բ����ڣ�������һͬ������
 * 
 * �г���һ��
 * 1��list():�г��¼�����
 * 2��listFiles():�г��¼�File����
 * 
 * �г������̷���listRoots()
 * 
 * @author b.h.huang
 * @time 2020.06.17 16:21:37
 *
 */
public class DirDeom01 {
	public static void main(String[] args) {
		File dir = new File("E:/program/java/eclipse-workplace/IO_study01/dir/test");
		
		//����Ŀ¼
		System.out.println("����Ŀ¼");
		//����Ŀ¼�Ƽ�ʹ��mkdirs()
		boolean flag = dir.mkdirs();
		System.out.println(flag);
		//����Ŀ¼mkdir()
		dir = new File("E:/program/java/eclipse-workplace/IO_study01/dir2/test2");
		flag = dir.mkdir();
		System.out.println(flag);
		
		//�г���һ��
		System.out.println("�г���һ��");
		dir = new File("E:/program/java/eclipse-workplace/IO_study01/");
		//�г���һ������ list
		String[] subName = dir.list();
		for (String string : subName) {
			System.out.println(string);
		}
		//�¼����� listFiles()
		File[] subFiles = dir.listFiles();
		for (File file : subFiles) {
			System.out.println(file);
		}
		
		//�����̷�
		File[] rootsFiles = dir.listRoots();
		for (File rootFile : rootsFiles) {
			System.out.println(rootFile);
		}
	}
}
