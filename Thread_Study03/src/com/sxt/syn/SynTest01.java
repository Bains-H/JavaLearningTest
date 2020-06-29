package com.sxt.syn;

/**
 * �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԡ�Ч�ʾ����ܸ�
 * synchronized
 * 1��ͬ������
 * 2��ͬ����
 * 
 * @author B.H.Huang
 * @date 2020.06.23 15:27:33 
 *
 */
public class SynTest01 {
	public static void main(String[] args) {
		//һ����Դ
		SafeWeb12306 web = new SafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		//�������
		new Thread(web,"����").start();
		new Thread(web,"��ũ").start();
		new Thread(web,"���").start();
	}
}

class SafeWeb12306 implements Runnable {
	//Ʊ��
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
			test();
		}
	}
	public synchronized void test() {
		if (ticketNum <= 0) {
			flag = false;
			return;
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
