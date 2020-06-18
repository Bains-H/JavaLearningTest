package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 转换流：InputStreamReader OutputStreamWriter
 * 1、以字符流的形式操作字节流（纯文本的）
 * 1、指定字符集
 *
 * @author B.H.Huang
 * @date 2020.06.18 15:37:28 
 *
 */
public class ConvertTest {
	public static void main(String[] args) {
		//操作网络流 下载百度源代码
		try(BufferedReader reader = 
				new BufferedReader(
						new InputStreamReader(
								new URL("https://www.baidu.com").openStream(),"UTF-8"));
				BufferedWriter writer = 
						new BufferedWriter(
								new OutputStreamWriter(
										new FileOutputStream("baidu.html"),"UTF-8"));) {
			//循环获取键盘的输入（exit退出），输出此内容
			String msg;
			while ((msg = reader.readLine()) != null) {
				msg = reader.readLine();//循环读取
				writer.write(msg);//循环写出
				writer.newLine();
			}
			writer.flush();//强制刷新
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("操作异常");
		}
		
	}
}
