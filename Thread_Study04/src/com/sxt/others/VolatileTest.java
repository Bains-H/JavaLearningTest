package com.sxt.others;

/**
 * volatile���ڱ�֤���ݵ�ͬ����Ҳ���ǿɼ���
 * 
 * @author B.H.Huang
 * @date 2020.06.28 19:54:07 
 *
 */
public class VolatileTest {
	private volatile static int num = 0;
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			while (num==0) {//�˴���Ҫ��д����
				
			}
		}).start();
		
		Thread.sleep(1000);
		num = 1;
	}
}
