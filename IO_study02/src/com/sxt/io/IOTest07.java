package com.sxt.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 字节数组输出流 ByteArrayOutputStream
 * 1、创建源：内部维护
 * 2、选择流：不关联源
 * 3、操作(写出内容)
 * 4、释放资源：可以不用
 * 
 * 获取数据：toByteArray()
 * 
 * @author huang b.h
 * @date 2020.06.18 11:40:55
 */

public class IOTest07 {
	public static void main(String[] args) {
		//创建源
		byte[] dest = null;
		//选择流  新增方法
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			//操作
			String mag = "shou me the code";
			byte[] datas = mag.getBytes();
			baos.write(datas,0,datas.length);
			baos.flush();
			//获取数据
			dest = baos.toByteArray();
			System.out.println(dest.length+"-->"+new String(dest,0,baos.size()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != baos) {
				//释放资源
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
