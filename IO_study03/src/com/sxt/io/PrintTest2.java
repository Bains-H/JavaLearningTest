package com.sxt.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * ��ӡ�� PrintWriter
 * 
 * @author B.H.Huang
 * @date 2020.06.18 16:42:11 
 *
 */
public class PrintTest2 {
	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
		pw.println("��ӡ��");
		pw.println(true);
		pw.close();
		
	}
}
