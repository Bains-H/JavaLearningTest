package com.sxt.cooperation;

/**
 * 协作模型：生产者消费者实现方式一：管程法
 * 借助缓冲区
 * 
 * @author B.H.Huang
 * @date 2020.06.28 16:38:36 
 *
 */
public class CoTest02 {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		Productor productor = new Productor(container);
		Consumer consumer = new Consumer(container);
		new Thread(productor).start();
		new Thread(consumer).start();
		
	}
}

//生产者
class Productor extends Thread{
	SynContainer container;
	public Productor(SynContainer container) {
		this.container = container;
	}
	public void run() {
		//开始生产
		for (int i = 0; i < 100; i++) {
			System.out.println("生产第"+i+"个馒头");
			container.push(new Steamedbun(i));
		}
	}
}
//消费者
class Consumer extends Thread{
	SynContainer container;
	public Consumer(SynContainer container) {
		this.container = container;
	}
	public void run() {
		//消费
		for(int i=0;i<1000;i--) {
			System.out.println("消费第"+container.pop().id+"个馒头");
		}
	}
}
//缓冲区
class SynContainer{
	Steamedbun[] buns = new Steamedbun[10];//存储容器
	int count = 0;//计数器
	//存储 生产
	public synchronized void push(Steamedbun bun) {
		//合适能生产 容器存在空间
		if (count == buns.length) {
			try {
				this.wait();//线程阻塞，存在空间解除
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//存在空间 可以生产
		buns[count] = bun;
		count++;
		this.notifyAll();
	}
	//获取 消费
	public synchronized Steamedbun pop() {
		//何时消费 容器中是否存在数据
		//没有数据 只有等待
		if (count == 0) {
			try {
				this.wait();//线程阻塞，生产者通知消费解除阻塞
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//存在数据可以消费
		count --;
		Steamedbun bun = buns[count];
		this.notifyAll();//存在空间，通知生产
		return bun;
	}
}
//馒头
class Steamedbun{
	int id;
	public Steamedbun(int id) {
		this.id = id;
	}
}
