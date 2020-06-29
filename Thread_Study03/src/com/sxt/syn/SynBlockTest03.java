package com.sxt.syn;

/**
 * 线程安全，在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块
 * 
 * @author B.H.Huang
 * @date 2020.06.23 15:27:33 
 *
 */
public class SynBlockTest03 {
	public static void main(String[] args) {
		//一份资源
		SynWeb12306 web = new SynWeb12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"码畜").start();
		new Thread(web,"码农").start();
		new Thread(web,"码蟥").start();
	}
}

class SynWeb12306 implements Runnable {
	//票数
	private int ticketNum = 10;
	private boolean flag = true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			test1();
//			test2();
//			test3();
//			test4();
			test5();
		}
	}
	
	//线程安全 同步
	public synchronized void test1() {
		if (ticketNum <= 0) {
			flag = false;
			return;
		}
		//模拟网络延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNum--);
	}
	
	//线程安全 范围太大 性能效率低下
	public void test2() {
		synchronized (this) {
			if (ticketNum <= 0) {
				flag = false;
				return;
			}
			//模拟网络延时
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+ticketNum--);
		}
	}
	
	//线程不安全，锁定失败 ticketNum对象在变
	public void test3() {
		synchronized ((Integer)ticketNum) {
			if (ticketNum <= 0) {
				flag = false;
				return;
			}
			//模拟网络延时
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+ticketNum--);
		}
	}
	
	//线程不安全，范围太小锁不住
	public void test4() {
		synchronized (this) {
			if (ticketNum <= 0) {
				flag = false;
				return;
			}
		}
		//模拟网络延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNum--);
	}
		
	//线程安全：尽可能锁定合理的范围（不是指代码，指数据的完整性）
	//double checking
	public void test5() {
		if (ticketNum <= 0) {//考虑没票的情况
			flag = false;
			return;
		}
		synchronized (this) {
			if (ticketNum <= 0) {//考虑最后一张票的情况
				flag = false;
				return;
			}
			//模拟网络延时
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+ticketNum--);
		}
	}
}
