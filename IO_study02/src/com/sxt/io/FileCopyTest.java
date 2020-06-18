package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author b.h.huang
 * @time 2020.06.17 21:05:23
 *
 */
public class FileCopyTest {
	public static void main(String[] args) {
		//把第一个路径改成已存在的文件夹路径
//		copyDir("E:/program/java/eclipse/sxt_test/IO_study02", "E:/program/java/eclipse/sxt_test/IO_study02",-1);
	}
	
	public static void copyFile(String srcPath,String copyPath) {
		File srcFile = new File(srcPath);
		File copyFile = new File(copyPath);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(srcFile);
			outputStream = new FileOutputStream(copyFile);
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len=inputStream.read(flush))!=-1) {
				outputStream.write(flush,0,len);
				outputStream.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != outputStream) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	
	public static void copyDir(String srcPath,String copyPath,int deep) {
		File srcDir = new File(srcPath);
		if (null == srcDir || !srcDir.exists()) {
			return;
		} else {
			if (deep == -1) {
				String newCopyPath = copyPath + File.separator + srcDir.getName();
				if (srcDir.isFile()) {
					copyFile(srcPath, newCopyPath);
				} else {
					File newCopyDir = new File(newCopyPath);
					newCopyDir.mkdir();
					copyDir(srcPath, newCopyPath, ++deep);
				}
			} else {
				for (File subDir : srcDir.listFiles()) {
					String newSubCopyPath = copyPath + File.separator + subDir.getName();
					File newCopyDir = new File(newSubCopyPath);
					if (subDir.isFile()) {
						copyFile(subDir.getAbsolutePath(), newSubCopyPath);
					}else {
						newCopyDir.mkdirs();
						copyDir(subDir.getAbsolutePath(), newSubCopyPath,++deep);
					}
				}
			}
		}
	}
}
