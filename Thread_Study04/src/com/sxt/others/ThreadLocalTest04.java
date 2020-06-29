package com.sxt.others;

/**
 * ThreadLocal:�̳������Ļ��������ݣ�����һ�ݸ����߳�

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
		
		//��main�߳̿���
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
			threadLocal.set(200);
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}).start();
	}
	
}
