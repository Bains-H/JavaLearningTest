package com.sxt.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * ��ӡ�� PrintStream
 * 
 * @author B.H.Huang
 * @date 2020.06.18 16:42:11 
 *
 */
public class PrintTest {
	public static void main(String[] args) throws FileNotFoundException {
		//��ӡ��System.out
		PrintStream ps = System.out;
		ps.println("��ӡ��");
		ps.println(true);
		
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
		ps.println("��ӡ��");
		ps.println(true);
		ps.close();
		
		//�ض��������
		System.setOut(ps);
		System.out.println("change");
		//�ض�������̨
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("i'm back");
	}
}
