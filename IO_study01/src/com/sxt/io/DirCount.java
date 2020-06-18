package com.sxt.io;

import java.io.File;
import java.util.concurrent.CountDownLatch;

/**
 * ʹ���������ͳ���ļ��д�С
 * 
 * @author b.h.huang
 * @time 2020.06.17 16:21:37
 *
 */
public class DirCount {
	//��С
	private long len;
	//�ļ���·��
	private String path;
	//�ļ�����
	private int fileSize;
	//�ļ��и���
	private int dirSize;
	//Դ
	private File src;
	public DirCount(String paString) {
		this.path = paString;
		this.src = new File(path);
		count(src);
	}
	
	public static void main(String[] args) {
		DirCount dir = new DirCount("E:/program/java/eclipse-workplace/IO_study01");
		System.out.println("�ļ��и��� "+dir.getFileSize());
		System.out.println("�ļ����� "+dir.getDirSize());
		System.out.println("�ļ��д�С"+dir.getLen());
	}
	
	//ͳ�ƴ�С
	private void count(File dirFile) {
		//��ȡ��С
		if (null != dirFile || dirFile.exists()) {
			if (dirFile.isFile()) {
				len+=dirFile.length();
				this.fileSize ++;
			}else {//���Ｖ
				this.dirSize++;
				for (File subFile : dirFile.listFiles()) {
					count(subFile);
				}
			}
		}
	}

	public long getLen() {
		return len;
	}

	public void setLen(long len) {
		this.len = len;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public File getSrc() {
		return src;
	}

	public void setSrc(File src) {
		this.src = src;
	}
	
	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getDirSize() {
		return dirSize;
	}

	public void setDirSize(int dirSize) {
		this.dirSize = dirSize;
	}
}
