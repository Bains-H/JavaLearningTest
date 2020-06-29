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
public class SynBlockTest03 {
	public static void main(String[] args) {
		//һ����Դ
		SynWeb12306 web = new SynWeb12306();
		System.out.println(Thread.currentThread().getName());
		//�������
		new Thread(web,"����").start();
		new Thread(web,"��ũ").start();
		new Thread(web,"���").start();
	}
}

class SynWeb12306 implements Runnable {
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
//			test1();
//			test2();
//			test3();
//			test4();
			test5();
		}
	}
	
	//�̰߳�ȫ ͬ��
	public synchronized void test1() {
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
	
	//�̰߳�ȫ ��Χ̫�� ����Ч�ʵ���
	public void test2() {
		synchronized (this) {
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
	
	//�̲߳���ȫ������ʧ�� ticketNum�����ڱ�
	public void test3() {
		synchronized ((Integer)ticketNum) {
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
	
	//�̲߳���ȫ����Χ̫С����ס
	public void test4() {
		synchronized (this) {
			if (ticketNum <= 0) {
				flag = false;
				return;
			}
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
		
	//�̰߳�ȫ����������������ķ�Χ������ָ���룬ָ���ݵ������ԣ�
	//double checking
	public void test5() {
		if (ticketNum <= 0) {//����ûƱ�����
			flag = false;
			return;
		}
		synchronized (this) {
			if (ticketNum <= 0) {//�������һ��Ʊ�����
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
}
