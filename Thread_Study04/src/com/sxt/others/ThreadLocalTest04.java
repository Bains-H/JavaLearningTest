package com.sxt.others;

/**
 * ThreadLocal:继承上下文环境的数据，拷贝一份给子线程

 * 
 * @author B.H.Huang
 * @date 2020.06.28 20:25:20 
 *
 */
public class ThreadLocalTest04 {
	private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<Integer>();
	public static void main(String[] args) {
		threadLocal.set(2);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		
		//由main线程开辟
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
			threadLocal.set(200);
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}).start();
	}
	
}
