package com.sxt.state;

/**
 * sleepģ��������ʱ���Ŵ��˷�������Ŀ�����
 * 
 * @author B.H.Huang
 * @date 2020.06.23 13:55:36 
 *
 */
public class BlockSleep01{
	public static void main(String[] args) {
		//һ����Դ
		Web12306 web = new Web12306();
		System.out.println(Thread.currentThread().getName());
		//�������
		new Thread(web,"����").start();
		new Thread(web,"��ũ").start();
		new Thread(web,"���").start();
	}
}

class Web12306 implements Runnable {
	//Ʊ��
	private int ticketNum = 99;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (ticketNum < 0) {
				break;
			}
			//ģ��������ʱ
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
