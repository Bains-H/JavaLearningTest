package com.sxt.thread;

/**
 * Lambda�Ƶ���������+����ֵ
 * 
 * @author B.H.Huang
 * @date 2020.06.22 22:16:37 
 *
 */
public class LambdaTest04 {

	public static void main(String[] args) {
		new Thread(()-> {
			System.out.println("һ��ѧϰlambda");
		}).start();
		new Thread(()-> {
			System.out.println("һ��ѧϰ����");
		}).start();
	}
		
}
