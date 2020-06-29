package com.sxt.state;

/**
 * yield 礼让线程，暂停线程 直接进入就绪状态，不是阻塞状态
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
				Thread.yield();//main线程礼让
			}
			System.out.println("main");
		}
	}
}

