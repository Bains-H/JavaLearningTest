package com.sxt.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * �̲߳���ȫ����������
 * 
 * @author B.H.Huang
 * @date 2020.06.23 15:34:47 
 *
 */
public class SynBlockTest02 {
	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()->{
				//ͬ����
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		Thread.sleep(1000*10);
		System.out.println(list.size());
	}
}