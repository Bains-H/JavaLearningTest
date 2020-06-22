package com.sxt.thread;

/**
 * ģ���������
 * 
 * @author B.H.Huang
 * @date 2020.06.22 19:15:10 
 *
 */
public class Racer implements Runnable{
	private static String winner;//ʤ����
	@Override
	public void run() {
		for (int steps = 1; steps <= 100; steps++) {
			System.out.println(Thread.currentThread().getName()+"--->"+steps);
			//ģ����Ϣ
			if (Thread.currentThread().getName().equals("rabbit")&&steps%10==0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//�����Ƿ����
			boolean flag = gameOver(steps);
			if (flag) {
				break;
			}
		}
	}
	private boolean gameOver(int steps) {
		if (winner!=null) {//����ʤ����
			return true;
		} else {
			if (steps == 100) {
				winner = Thread.currentThread().getName();
				System.out.println("winner ==> "+winner);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Racer racer = new Racer();
		new Thread(racer,"tortoise").start();
		new Thread(racer,"rabbit").start();
	}
}
