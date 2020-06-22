package com.sxt.thread;

/**
 * 共享资源,并发（线程安全）
 * 
 * @author B.H.Huang
 * @date 2020.06.22 19:05:24 
 *
 */
public class Web12306 implements Runnable {
	//票数
	private int ticketNum = 99;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (ticketNum < 0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+ticketNum--);
		}
	}
	
	public static void main(String[] args) {
		//一份资源
		Web12306 web = new Web12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"码畜").start();
		new Thread(web,"码农").start();
		new Thread(web,"码蟥").start();
	}
}
