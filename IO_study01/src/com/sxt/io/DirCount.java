package com.sxt.io;

import java.io.File;
import java.util.concurrent.CountDownLatch;

/**
 * 使用面向对象统计文件夹大小
 * 
 * @author b.h.huang
 * @time 2020.06.17 16:21:37
 *
 */
public class DirCount {
	//大小
	private long len;
	//文件夹路径
	private String path;
	//文件个数
	private int fileSize;
	//文件夹个数
	private int dirSize;
	//源
	private File src;
	public DirCount(String paString) {
		this.path = paString;
		this.src = new File(path);
		count(src);
	}
	
	public static void main(String[] args) {
		DirCount dir = new DirCount("E:/program/java/eclipse-workplace/IO_study01");
		System.out.println("文件夹个数 "+dir.getFileSize());
		System.out.println("文件个数 "+dir.getDirSize());
		System.out.println("文件夹大小"+dir.getLen());
	}
	
	//统计大小
	private void count(File dirFile) {
		//获取大小
		if (null != dirFile || dirFile.exists()) {
			if (dirFile.isFile()) {
				len+=dirFile.length();
				this.fileSize ++;
			}else {//子孙级
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
