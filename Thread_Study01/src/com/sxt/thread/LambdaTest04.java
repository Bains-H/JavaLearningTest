package com.sxt.thread;

/**
 * Lambda推导：带参数+返回值
 * 
 * @author B.H.Huang
 * @date 2020.06.22 22:16:37 
 *
 */
public class LambdaTest04 {

	public static void main(String[] args) {
		new Thread(()-> {
			System.out.println("一边学习lambda");
		}).start();
		new Thread(()-> {
			System.out.println("一边学习奔溃");
		}).start();
	}
		
}
