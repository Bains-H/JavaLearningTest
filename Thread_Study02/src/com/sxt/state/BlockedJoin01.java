package com.sxt.state;

/**
 * join�ϲ��̣߳�����߳�
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
		System.out.println("����̣�����û��");
		System.out.println("�ö���ȥ����");
		Thread t = new Thread(new Son());
		t.start();
		try {
			t.join();//father������
			System.out.println("�ӹ����������");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����߶��Ҷ���ȥ��");
		}
		
	}
}

class Son implements Runnable{
	@Override
	public void run() {
		System.out.println("����ϰֵ�Ǯ��ȥ��");
		System.out.println("������Ϸ������ȥ����10��");
		for (int i = 0; i < 10; i++) {
			System.out.println(i+"���ȥ��...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("�Ͻ�ȥ����");
	}
}
