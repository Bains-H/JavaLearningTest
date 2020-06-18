package com.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * ���룺�ַ���-->�ֽ�
 * ���룺�ֽ�-->�ַ���
 * @author b.h.huang
 * @time 2020.06.17 17:13:26
 *
 */
public class ContentEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "��������ʹ��";
		//���룺�ֽ�����
		byte[] datas = msg.getBytes();//Ĭ��ʹ�ù��̵��ַ���
		System.out.println(datas.length);
		
		//���������ַ���
		datas = msg.getBytes("UTF-8");
		System.out.println(datas.length);
		
		//���룺�ַ���String(byte[] bytes,int offset,int length,String charsetName)
		msg = new String(datas,0,datas.length,"utf8");
		System.out.println(msg);
		
		//���룺
		//1���ֽ�������
		msg = new String(datas,0,datas.length-1,"utf8");
		System.out.println(msg);
		//2���ַ�����ͳһ
		msg = new String(datas,0,datas.length,"utf16");
		System.out.println(msg);
	}
}
