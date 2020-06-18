package com.sxt.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取和写入流 RandomAccessFile
 * 
 * @author B.H.Huang
 * @date 2020.06.18 16:57:22 
 *
 */
public class RandTest01 {
	public static void main(String[] args) throws IOException {
		//分多少块
		File sre = new File("src/com/sxt/io/PrintTest2.java");
		//总长度
		long len = sre.length();
		//每块大小
		int blockSize = 512;
		//块数：多少块
		int size = (int) Math.ceil(len*1.0/blockSize);
		System.out.println(size);
		//起始位置和实际大小
		int beginPos = 0;
		int actuaSize = (int) (blockSize>len?len:blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i*blockSize;
			if (i == size-1) {//最后一块
				actuaSize = (int) len;
			} else {
				actuaSize = blockSize;
				len -= actuaSize;//剩余量
			}
			System.out.println(i+"-->"+beginPos+"-->"+actuaSize);
			split(i, beginPos, actuaSize);
		}
	}
	
	//指定起始位置，读取剩余所有内容
	public static void test1() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("src/com/sxt/io/PrintTest2.java", "r");
		//随机读取
		raf.seek(2);
		//读取
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			System.out.println(new String(flush,0,len));
//			raf.write(flush,0,len);
		}
		raf.close();
	}
	
	//分开思想：起始，实际大小
	public static void test2() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("src/com/sxt/io/PrintTest2.java", "r");
		//起始位置
		int beginPos = 2;
		//实际大小
		int actualSize = 1026;
		//随机读取
		raf.seek(beginPos);
		//读取
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			if (actualSize>len) {//获取本次读取的所有内容
				System.out.println(new String(flush,0,len));
				actualSize -= len;
			} else {
				System.out.println(new String(flush,0,actualSize));
				break;
			}
		}
		raf.close();
	}
	
	//指定第i块的起始位置和实际长度
	public static void split(int i,int beginPos, int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("src/com/sxt/io/PrintTest2.java", "r");
		RandomAccessFile raf2 = new RandomAccessFile(new File("dest/" + i + "copy.java"),"rw");
		//起始位置
		//实际大小
		//随机读取
		raf.seek(beginPos);
		//读取
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			if (actualSize>len) {//获取本次读取的所有内容
//				System.out.println(new String(flush,0,len));
				raf2.write(flush,0,len);
				actualSize -= len;
			} else {
//				System.out.println(new String(flush,0,actualSize));
				raf2.write(flush,0,actualSize);
				break;
			}
		}
		raf2.close();
		raf.close();
	}
}
