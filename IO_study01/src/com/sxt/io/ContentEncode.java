package com.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * 编码：字符串-->字节
 * 解码：字节-->字符串
 * @author b.h.huang
 * @time 2020.06.17 17:13:26
 *
 */
public class ContentEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "性命生命使命";
		//编码：字节数组
		byte[] datas = msg.getBytes();//默认使用工程的字符集
		System.out.println(datas.length);
		
		//编码其他字符集
		datas = msg.getBytes("UTF-8");
		System.out.println(datas.length);
		
		//解码：字符串String(byte[] bytes,int offset,int length,String charsetName)
		msg = new String(datas,0,datas.length,"utf8");
		System.out.println(msg);
		
		//乱码：
		//1、字节数不够
		msg = new String(datas,0,datas.length-1,"utf8");
		System.out.println(msg);
		//2、字符集不统一
		msg = new String(datas,0,datas.length,"utf16");
		System.out.println(msg);
	}
}
