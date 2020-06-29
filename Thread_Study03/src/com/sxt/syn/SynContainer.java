package com.sxt.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全：操作并发容器容器
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
				//同步块
				list.add(Thread.currentThread().getName());
			}).start();
		}
		Thread.sleep(1000*10);
		System.out.println(list.size());
	}
}