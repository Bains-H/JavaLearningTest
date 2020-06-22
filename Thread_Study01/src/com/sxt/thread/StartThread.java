package com.sxt.thread;

/**
 * 创建线程方式一：
 * 1、继承Thread+重写run
 * 2、启动：创建子类对象+start
 * 
 * @author B.H.Huang
 * @date 2020.06.22 17:48:45 
 *
 */
public class StartThread extends Thread{
	
	/**
	 * 线程入口点
	 */
	@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("一边听歌");
			}
		}
	
	public static void main(String[] args) {
		//创建子类对象
		StartThread st = new StartThread();
		//启动线程
		st.start(); //开启一个新的线程，不保证立即运行 cpu调用
//		st.run(); //普通方法调用
		
		for (int i = 0; i < 20; i++) {
			System.out.println("一边coding");
		}
	}
}
