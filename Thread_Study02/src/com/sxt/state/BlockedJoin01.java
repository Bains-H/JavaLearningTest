package com.sxt.state;

/**
 * join合并线程，插队线程
 * 
 * @author B.H.Huang
 * @date 2020.06.23 14:21:16 
 *
 */
public class BlockedJoin01 {
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Father()).start();
	}
}

class Father extends Thread{
	@Override
	public void run() {
		System.out.println("想抽烟，发现没了");
		System.out.println("让儿子去买烟");
		Thread t = new Thread(new Son());
		t.start();
		try {
			t.join();//father被阻塞
			System.out.println("接过儿子买的烟");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("儿子走丢找儿子去了");
		}
		
	}
}

class Son implements Runnable{
	@Override
	public void run() {
		System.out.println("结果老爸的钱出去了");
		System.out.println("发现游戏厅，进去玩了10秒");
		for (int i = 0; i < 10; i++) {
			System.out.println(i+"秒过去了...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("赶紧去买烟");
	}
}
