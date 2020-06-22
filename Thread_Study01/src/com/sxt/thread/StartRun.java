package com.sxt.thread;

/**
 * 创建线程方式二：
 * 1、创建：实现Runnable+重写run
 * 2、启动：创建实现类对象+Thread对象+start
 * 
 * 推荐：避免单继承的局限性，优先使用接口
 * 方便共享资源
 * 
 * @author B.H.Huang
 * @date 2020.06.22 18:50:29 
 *
 */
public class StartRun implements Runnable{
	/**
	 * 线程入口点
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			System.out.println("一边听歌");
		}
	}
	
	public static void main(String[] args) {
//		//创建实现类对象
//		StartRun sr = new StartRun();
//		//创建代理类对象
//		Thread t = new Thread();
//		//启动
//		t.start();//不保证立即运行 cpu调用
		
		//如果一个对象只使用一次，可以使用匿名
		new Thread(new StartRun()).start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("一边coding");
		}
	}
}
