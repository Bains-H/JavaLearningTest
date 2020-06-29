package com.sxt.others;

/**
 * ThreadLocal:每个线程自身的存储本地、局部区域
 * get/set/initailValue
 * 
 * @author B.H.Huang
 * @date 2020.06.28 20:25:20 
 *
 */
public class ThreadLocalTest01 {
//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	//更改初始值
//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
//		protected Integer initailValue() {
//			return 200;
//		};
//	};
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->200);
	public static void main(String[] args) {
		//获取值
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		//设置值
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
