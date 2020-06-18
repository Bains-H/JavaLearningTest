package com.sxt.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流 PrintStream
 * 
 * @author B.H.Huang
 * @date 2020.06.18 16:42:11 
 *
 */
public class PrintTest {
	public static void main(String[] args) throws FileNotFoundException {
		//打印流System.out
		PrintStream ps = System.out;
		ps.println("打印流");
		ps.println(true);
		
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
		ps.println("打印流");
		ps.println(true);
		ps.close();
		
		//重定向输出端
		System.setOut(ps);
		System.out.println("change");
		//重定向会控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("i'm back");
	}
}
