package com.sxt.io;

import java.io.File;
import java.io.IOException;

/**
 * 
 * ���ƻ�·��
 * getName():����
 * getPath():·��
 * getAbsolutePath():����·��
 * getParent():��·��
 * 
 * �ļ���״̬
 * 1�������ڣ�exists
 * 2������
 * 		�ļ���isFile
 * 		�ļ��У�isDirctory
 * 
 * ������Ϣ
 * length():�ֽ���
 * createNewFile():�����ڲŴ��������ڴ����ɹ�
 * delete():ɾ���Ѿ����ڵ��ļ�
 * 
 * @author b.h.huang
 * @time 2020.06.17 15:50:38
 *
 */
public class FileDemo02 {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File src = new File("E:/program/java/eclipse-workplace/MyPro01/images/ball.png");
		
		//������Ϣ
		System.out.println("������Ϣ");
		System.out.println("���ƣ�"+src.getName());
		System.out.println("·����"+src.getPath());
		System.out.println("����·����"+src.getAbsolutePath());
		System.out.println("��·����"+src.getParent());
		System.out.println("������"+src.getParentFile());
		
		//�ļ�״̬
		System.out.println("�ļ�״̬");
		
		//�������ļ�״̬
//		src = new File("xxx");
		if (null == src || !src.exists()) {
			System.out.println("�ļ�������");
		}else {
			if (src.isFile()) {
				System.out.println("�ļ�����");
			}else {
				System.out.println("�ļ��в���");
			}
		}
		
		//������Ϣ
		System.out.println("������Ϣ");
		System.out.println("���ȣ�"+src.length());
		boolean flag = src.createNewFile();
		System.out.println(flag);
		
		//�����ļ���
		src = new File("E:/program/java/eclipse-workplace/IO_study01/io.txt");
		flag = src.createNewFile();
		System.out.println(flag);
		
		flag = src.delete();
		System.err.println(flag);
		
		//����:con com3...����ϵͳ���豸����������ȷ����
		src = new File("E:/program/java/eclipse-workplace/IO_study01/con");
		flag = src.createNewFile();
		System.out.println(flag);
	}
}
