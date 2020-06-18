package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * �ļ��ֽ������
 *  * 1������Դ
 * 2��ѡ����
 * 3��������д�����ݣ�
 * 4���ͷ���Դ
 * 
 * @author b.h.huang
 * @time 2020.06.17 18:08:08
 *
 */
public class IOTest04 {
	public static void main(String[] args) {
		//1������Դ
		File srcFile = new File("dest.txt");
		//2.ѡ����
		OutputStream oStream = null;
		try {
			oStream = new FileOutputStream(srcFile,true);
			//3��������д����
			String msgString = "IO is so easy";
			byte[] datas = msgString.getBytes();//�ַ���-->�ֽ�����
			oStream.write(datas,0,datas.length);
			oStream.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != oStream) {
				try {
					//4���ͷ���Դ
					oStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
