package com.sxt.commons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 
 * 
 * @author B.H.Huang
 * @date 2020.06.18 18:39:12 
 *
 */
public class CIOTest01 {
	public static void main(String[] args) throws IOException {
		//计算大小
//		Size();
		//列出子孙级
//		ListFiles();
		//读取内容
//		ReaderStore();
		//写出内容
		WriteStore();
	}
	
	//计算大小
	public static void Size() {
		//文件大小
		long len = FileUtils.sizeOf(new File("src/com/sxt/commons/CIOTest01.java"));
		System.out.println(len);
		//目录大小
		len = FileUtils.sizeOf(new File("E:/program/java/eclipse/sxt_test"));
		System.out.println(len);
	}
	
	//列出子孙级
	public static void ListFiles() {
		Collection<File> files = FileUtils.listFiles(new File("E:/program/java/eclipse/sxt_test/IO_study04"), 
				EmptyFileFilter.NOT_EMPTY, null);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("-----------");
		files = FileUtils.listFiles(new File("E:/program/java/eclipse/sxt_test/IO_study04"),
				new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("-----------");
		files = FileUtils.listFiles(new File("E:/program/java/eclipse/sxt_test/IO_study04"),
				FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")),
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("-----------");
		files = FileUtils.listFiles(new File("E:/program/java/eclipse/sxt_test/IO_study04"),
				FileFilterUtils.and(new SuffixFileFilter("java"),EmptyFileFilter.EMPTY),
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}
	
	//读取内容
	public static void ReaderStore() throws IOException {
		//读取文件
		String msg = FileUtils.readFileToString(new File("emp.txt"),"GBK");
		System.out.println(msg);
		byte[] dates = FileUtils.readFileToByteArray(new File("emp.txt"));
		System.out.println(dates.length);
		//逐行读取
		List<String> msgs = FileUtils.readLines(new File("emp.txt"),"GBK");
		for (String string : msgs) {
			System.out.println(string);
		}
		
		LineIterator it = FileUtils.lineIterator(new File("emp.txt"),"GBK");
		while (it.hasNext()) {
			System.out.println(it.nextLine());
		}
	}

	//写出内容
	public static void WriteStore() throws IOException {
		//写出文件
		FileUtils.write(new File("happy.txt"), "学习是一件伟大的事业\r\n","GBK",true);
		FileUtils.writeStringToFile(new File("happy.txt"), "学习是一件辛苦的事业\r\n","GBK",true);
		FileUtils.writeByteArrayToFile(new File("happy.txt"), "学习是一件幸福的事业\t\n".getBytes("GBK"),true);
		
		//写出列表
		List<String> datas = new ArrayList<String>();
		datas.add("马云");
		datas.add("马化腾");
		datas.add("弼马温");
		
		FileUtils.writeLines(new File("happy.txt"),datas,"\r\n",true);
	}
	
}
