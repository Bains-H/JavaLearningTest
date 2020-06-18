package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * ת������InputStreamReader OutputStreamWriter
 * 1�����ַ�������ʽ�����ֽ��������ı��ģ�
 * 1��ָ���ַ���
 *
 * @author B.H.Huang
 * @date 2020.06.18 15:37:28 
 *
 */
public class ConvertTest02 {
	public static void main(String[] args) {
		//����System.in ��System.out
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
			//ѭ����ȡ���̵����루exit�˳��������������
			String msg = "";
			while (!msg.equals("exit")) {
				msg = reader.readLine();//ѭ����ȡ
				writer.write(msg);//ѭ��д��
				writer.newLine();
				writer.flush();//ǿ��ˢ��
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����쳣");
		}
		
	}
}
