package com.sxt.state;

/**
 * �̵߳����ȼ�1-10
 * 1��NORM_PRIORITY 5 Ĭ��
 * 2��MIN_PRIORITY 1
 * 3��MAX_PRIORITY 10
 * ���ʣ���������Ե��Ⱥ�˳��
 * 
 * @author B.H.Huang
 * @date 2020.06.23 14:46:49 
 *
 */
public class PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority());
		MyPriority mp = new MyPriority();
		
		Thread t1 = new Thread(mp,"adidas");
		Thread t2 = new Thread(mp,"NIKE");
		Thread t3 = new Thread(mp,"����");
		Thread t4 = new Thread(mp,"����");
		Thread t5 = new Thread(mp,"˫��");
		Thread t6 = new Thread(mp,"puma");
		
		//�������ȼ�������ǰ
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class MyPriority implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		Thread.yield();
	}
}