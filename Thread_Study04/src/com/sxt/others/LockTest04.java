package com.sxt.others;

import java.util.concurrent.locks.ReentrantLock;

/** + ������
 * ��������������������ʹ��
 * 
 * @author B.H.Huang
 * @date 2020.06.29 14:32:28 
 *
 */
public class LockTest04 {
	ReentrantLock lock = new ReentrantLock();
	public void a() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		doSomething();
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}
	//��������
	public void doSomething() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		//.....
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockTest04 test = new LockTest04();
		test.a();
		Thread.sleep(1000);
		System.out.println(test.lock.getHoldCount());
	}
}