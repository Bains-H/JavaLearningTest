package com.sxt.others;

/**
 * 不可重入锁：锁不可以延续使用
 * 
 * @author B.H.Huang
 * @date 2020.06.29 14:32:28 
 *
 */
public class LockTest02 {
	Lock lock = new Lock();
	public void a() throws InterruptedException {
		lock.lock();
		doSomething();
		lock.unlock();
	}
	//不可重入
	public void doSomething() throws InterruptedException {
		lock.lock();
		//.....
		lock.unlock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockTest02 test = new LockTest02();
		test.a();
		test.doSomething();
	}
}

//不可重入锁
class Lock{
	//是否占用
	private boolean isLocked = false;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
	}
	//释放锁
	public synchronized void unlock() {
		isLocked =false;
		notify();
	}
}
