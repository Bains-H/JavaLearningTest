package com.sxt.syn;

/**
 * 线程不安全，数据有负数和相同的情况
 * 
 * @author B.H.Huang
 * @date 2020.06.23 15:27:33 
 *
 */
public class UnsafeTest01 {
	public static void main(String[] args) {
		//一份资源
		UnsafeWeb12306 web = new UnsafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"码畜").start();
		new Thread(web,"码农").start();
		new Thread(web,"码蟥").start();
	}
}

class UnsafeWeb12306 implements Runnable {
	//票数
	private int ticketNum = 10;
	private boolean flag = true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			test();
		}
	}
	public void test() {
		if (ticketNum < 0) {
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
