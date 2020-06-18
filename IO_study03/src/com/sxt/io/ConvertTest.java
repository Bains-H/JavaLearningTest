package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * ת������InputStreamReader OutputStreamWriter
 * 1�����ַ�������ʽ�����ֽ��������ı��ģ�
 * 1��ָ���ַ���
 *
 * @author B.H.Huang
 * @date 2020.06.18 15:37:28 
 *
 */
public class ConvertTest {
	public static void main(String[] args) {
		//���������� ���ذٶ�Դ����
		try(BufferedReader reader = 
				new BufferedReader(
						new InputStreamReader(
								new URL("https://www.baidu.com").openStream(),"UTF-8"));
				BufferedWriter writer = 
						new BufferedWriter(
								new OutputStreamWriter(
										new FileOutputStream("baidu.html"),"UTF-8"));) {
			//ѭ����ȡ���̵����루exit�˳��������������
			String msg;
			while ((msg = reader.readLine()) != null) {
				msg = reader.readLine();//ѭ����ȡ
				writer.write(msg);//ѭ��д��
				writer.newLine();
			}
			writer.flush();//ǿ��ˢ��
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����쳣");
		}
		
	}
}
