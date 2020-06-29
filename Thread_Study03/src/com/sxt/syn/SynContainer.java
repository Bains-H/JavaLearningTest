package com.sxt.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * �̰߳�ȫ������������������
 * 
 * @author B.H.Huang
 * @date 2020.06.23 15:34:47 
 *
 */
public class SynContainer {
	public static void main(String[] args) throws InterruptedException {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()->{
				//ͬ����
				list.add(Thread.currentThread().getName());
			}).start();
		}
		Thread.sleep(1000*10);
		System.out.println(list.size());
	}
}