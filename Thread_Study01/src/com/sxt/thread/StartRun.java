package com.sxt.thread;

/**
 * �����̷߳�ʽ����
 * 1��������ʵ��Runnable+��дrun
 * 2������������ʵ�������+Thread����+start
 * 
 * �Ƽ������ⵥ�̳еľ����ԣ�����ʹ�ýӿ�
 * ���㹲����Դ
 * 
 * @author B.H.Huang
 * @date 2020.06.22 18:50:29 
 *
 */
public class StartRun implements Runnable{
	/**
	 * �߳���ڵ�
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			System.out.println("һ������");
		}
	}
	
	public static void main(String[] args) {
//		//����ʵ�������
//		StartRun sr = new StartRun();
//		//�������������
//		Thread t = new Thread();
//		//����
//		t.start();//����֤�������� cpu����
		
		//���һ������ֻʹ��һ�Σ�����ʹ������
		new Thread(new StartRun()).start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("һ��coding");
		}
	}
}
