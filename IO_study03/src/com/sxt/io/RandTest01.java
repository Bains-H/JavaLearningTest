package com.sxt.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �����ȡ��д���� RandomAccessFile
 * 
 * @author B.H.Huang
 * @date 2020.06.18 16:57:22 
 *
 */
public class RandTest01 {
	public static void main(String[] args) throws IOException {
		//�ֶ��ٿ�
		File sre = new File("src/com/sxt/io/PrintTest2.java");
		//�ܳ���
		long len = sre.length();
		//ÿ���С
		int blockSize = 512;
		//���������ٿ�
		int size = (int) Math.ceil(len*1.0/blockSize);
		System.out.println(size);
		//��ʼλ�ú�ʵ�ʴ�С
		int beginPos = 0;
		int actuaSize = (int) (blockSize>len?len:blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i*blockSize;
			if (i == size-1) {//���һ��
				actuaSize = (int) len;
			} else {
				actuaSize = blockSize;
				len -= actuaSize;//ʣ����
			}
			System.out.println(i+"-->"+beginPos+"-->"+actuaSize);
			split(i, beginPos, actuaSize);
		}
	}
	
	//ָ����ʼλ�ã���ȡʣ����������
	public static void test1() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("src/com/sxt/io/PrintTest2.java", "r");
		//�����ȡ
		raf.seek(2);
		//��ȡ
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			System.out.println(new String(flush,0,len));
//			raf.write(flush,0,len);
		}
		raf.close();
	}
	
	//�ֿ�˼�룺��ʼ��ʵ�ʴ�С
	public static void test2() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("src/com/sxt/io/PrintTest2.java", "r");
		//��ʼλ��
		int beginPos = 2;
		//ʵ�ʴ�С
		int actualSize = 1026;
		//�����ȡ
		raf.seek(beginPos);
		//��ȡ
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			if (actualSize>len) {//��ȡ���ζ�ȡ����������
				System.out.println(new String(flush,0,len));
				actualSize -= len;
			} else {
				System.out.println(new String(flush,0,actualSize));
				break;
			}
		}
		raf.close();
	}
	
	//ָ����i�����ʼλ�ú�ʵ�ʳ���
	public static void split(int i,int beginPos, int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("src/com/sxt/io/PrintTest2.java", "r");
		RandomAccessFile raf2 = new RandomAccessFile(new File("dest/" + i + "copy.java"),"rw");
		//��ʼλ��
		//ʵ�ʴ�С
		//�����ȡ
		raf.seek(beginPos);
		//��ȡ
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			if (actualSize>len) {//��ȡ���ζ�ȡ����������
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
