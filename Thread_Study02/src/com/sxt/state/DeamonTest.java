package com.sxt.state;

/**
 * �ػ��̣߳���Ϊ�û��̷߳���ģ�jvmֹͣ���õȴ��ػ��߳�ִ�����
 * Ĭ�ϣ��û��߳� jvm�ȴ��û��߳�ִ����ϲŻ�ֹͣ
 * 
 * @author B.H.Huang
 * @date 2020.06.23 14:56:48 
 *
 */
public class DeamonTest {
	public static void main(String[] args) {
		God god = new God();
		You you = new You();
		Thread t = new Thread(god);
		t.setDaemon(true);//���û��̵߳���Ϊ�ػ��߳�
		t.start();
		new Thread(you).start();
	}
}

class You implements Runnable{
	@Override
	public void run() {
		for (int i = 1; i < 365*100; i++) {
			System.out.println("happy life..");
		}
		System.out.println("ooooo");
	}
}

class God implements Runnable{
	@Override
	public void run() {
		for (;true;) {
			System.out.println("bless you");
		}
	}
}
