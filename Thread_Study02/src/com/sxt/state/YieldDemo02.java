package com.sxt.state;

/**
 * yield �����̣߳���ͣ�߳� ֱ�ӽ������״̬����������״̬
 * 
 * @author B.H.Huang
 * @date 2020.06.23 14:10:33 
 *
 */
public class YieldDemo02 {
	public static void main(String[] args) {
		new Thread(()-> {
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda...");
			}
		}).start();
		
		for (int i = 0; i < 100; i++) {
			if (i%20==0) {
				Thread.yield();//main�߳�����
			}
			System.out.println("main");
		}
	}
}

