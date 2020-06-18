package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1����װ����
 * 2����װ�ͷ�
 * @author huang b.h
 * @date 2020.06.18 13:30:22
 */

public class FileUtils {
	public static void main(String[] args) {
		//�ļ����ļ�
		try {
			InputStream is = new FileInputStream("abc.txt");
			OutputStream os = new FileOutputStream("abc-copy.txt");
			copy(is, os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ļ����ֽ�����
		byte[] datas = null;
		try {
			InputStream is = new FileInputStream("desk.jpg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is, os);
			datas = os.toByteArray();
			System.out.println(datas.length);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ֽ����鵽�ļ�
		try {
			ByteArrayInputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("desk-copy.jpg");
			copy(is, os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * �Խ����������
	 */
	public static void copy(InputStream is,OutputStream os) {
		try {
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush,0,len);
			}
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(is, os);
		}
	}
	
	/**
	 * �ͷ���Դ
	 */
	public static void close(InputStream is,OutputStream os) {
		if (null != os) {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != is) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Closeable...ios) {
		for (Closeable io : ios) {
			if (null != io) {
				try {
					io.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
