package com.sxt.state;

/**
 * join�ϲ��̣߳�����߳�
 * 
 * @author B.H.Huang
 * @date 2020.06.23 14:21:16 
 *
 */
public class BlockedJoin02 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda..."+i);
			}
		});
		t.start();
		
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				t.join();//���
			}
			System.out.println("main..."+i);
		}
	}
}
