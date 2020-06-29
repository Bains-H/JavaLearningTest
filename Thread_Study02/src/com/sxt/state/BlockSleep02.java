package com.sxt.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep模拟倒计时
 * 
 * @author B.H.Huang
 * @date 2020.06.23 14:02:58 
 *
 */
public class BlockSleep02 {
	public static void main(String[] args) throws InterruptedException{
//		test01();
		test02();
	}
	
	//倒数10个数，1秒一个
	public static void test01() throws InterruptedException {
		int num = 10;
		while (true) {
			Thread.sleep(1000);
			System.out.println(num--);
		}
	}
	
	//倒计时
	public static void test02() throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis()+1000*10);
		long end = endTime.getTime();
		while (true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			Thread.sleep(1000);
			endTime = new Date(endTime.getTime()-1000);
			if (end-10000>endTime.getTime()) {
				break;
			}
		}
	}
	
}
