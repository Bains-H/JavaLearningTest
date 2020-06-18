package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件字节输出流
 *  * 1、创建源
 * 2、选择流
 * 3、操作（写出内容）
 * 4、释放资源
 * 
 * @author b.h.huang
 * @time 2020.06.17 18:08:08
 *
 */
public class IOTest04 {
	public static void main(String[] args) {
		//1、创建源
		File srcFile = new File("dest.txt");
		//2.选择流
		OutputStream oStream = null;
		try {
			oStream = new FileOutputStream(srcFile,true);
			//3、操作（写出）
			String msgString = "IO is so easy";
			byte[] datas = msgString.getBytes();//字符串-->字节数组
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
					//4、释放资源
					oStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
