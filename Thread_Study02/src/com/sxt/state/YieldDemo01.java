package com.sxt.state;

/**
 * yield �����̣߳���ͣ�߳� ֱ�ӽ������״̬����������״̬
 * 
 * @author B.H.Huang
 * @date 2020.06.23 14:10:33 
 *
 */
public class YieldDemo01 {
	public static void main(String[] args) {
		MyYield my = new MyYield();
		new Thread(my,"a").start();
		new Thread(my,"b").start();
	}
}

class MyYield implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"-->atart");
		Thread.yield();//����
		System.out.println(Thread.currentThread().getName()+"-->end");
	}
}
