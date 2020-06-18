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
		//�����С
//		Size();
		//�г����Ｖ
//		ListFiles();
		//��ȡ����
//		ReaderStore();
		//д������
		WriteStore();
	}
	
	//�����С
	public static void Size() {
		//�ļ���С
		long len = FileUtils.sizeOf(new File("src/com/sxt/commons/CIOTest01.java"));
		System.out.println(len);
		//Ŀ¼��С
		len = FileUtils.sizeOf(new File("E:/program/java/eclipse/sxt_test"));
		System.out.println(len);
	}
	
	//�г����Ｖ
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
	
	//��ȡ����
	public static void ReaderStore() throws IOException {
		//��ȡ�ļ�
		String msg = FileUtils.readFileToString(new File("emp.txt"),"GBK");
		System.out.println(msg);
		byte[] dates = FileUtils.readFileToByteArray(new File("emp.txt"));
		System.out.println(dates.length);
		//���ж�ȡ
		List<String> msgs = FileUtils.readLines(new File("emp.txt"),"GBK");
		for (String string : msgs) {
			System.out.println(string);
		}
		
		LineIterator it = FileUtils.lineIterator(new File("emp.txt"),"GBK");
		while (it.hasNext()) {
			System.out.println(it.nextLine());
		}
	}

	//д������
	public static void WriteStore() throws IOException {
		//д���ļ�
		FileUtils.write(new File("happy.txt"), "ѧϰ��һ��ΰ�����ҵ\r\n","GBK",true);
		FileUtils.writeStringToFile(new File("happy.txt"), "ѧϰ��һ���������ҵ\r\n","GBK",true);
		FileUtils.writeByteArrayToFile(new File("happy.txt"), "ѧϰ��һ���Ҹ�����ҵ\t\n".getBytes("GBK"),true);
		
		//д���б�
		List<String> datas = new ArrayList<String>();
		datas.add("����");
		datas.add("����");
		datas.add("������");
		
		FileUtils.writeLines(new File("happy.txt"),datas,"\r\n",true);
	}
	
}
