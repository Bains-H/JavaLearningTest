package com.sxt.others;

/**
 * ThreadLocal:ÿ���߳�����Ĵ洢���ء��ֲ�����
 * get/set/initailValue
 * 
 * @author B.H.Huang
 * @date 2020.06.28 20:25:20 
 *
 */
public class ThreadLocalTest01 {
//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	//���ĳ�ʼֵ
//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
//		protected Integer initailValue() {
//			return 200;
//		};
//	};
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->200);
	public static void main(String[] args) {
		//��ȡֵ
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		//����ֵ
		threadLocal.set(99);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
	}
	
	public static class MyRun implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			threadLocal.set((int) (Math.random()*99));
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

		}
	}
}
