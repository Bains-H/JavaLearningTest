package com.sxt.syn;

/**
 * �����������ͬ����������໥���ͷ���Դ
 * �Ӷ��໥�ȴ���һ�㷢����ͬ��ͨ���ж���������
 * 
 * ���⣺��Ҫ��ͬһ��������У�ͬʱ���ж��������
 * 
 * @author B.H.Huang
 * @date 2020.06.23 18:16:17 
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		Markup g1 = new Markup(1, "��Ѿ");
		Markup g2 = new Markup(2, "��Ѿ");
		g1.start();
		g2.start();
	}
}
//�ں�
class Lipstick{
	
}
//����
class Mirror{
	
}
//��ױ
class Markup extends Thread{
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	//ѡ��
	int choice;
	//����
	String girl;
	public Markup(int choice, String girl) {
		super();
		this.choice = choice;
		this.girl = girl;
	}

	@Override
	public void run() {
		//��ױ
		markup();
	}
	//�໥���жԷ��Ķ�����-->�����������
	private void markup() {
		if (choice == 1) {
			synchronized (lipstick) {//��ÿں����
				System.out.println(this.girl+"Ϳ�ں�");
				//1���
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				synchronized (mirror) {//��þ��ӵ���
//					System.out.println(this.girl+"�վ���");
//				}
			}
			synchronized (mirror) {//��þ��ӵ���
				System.out.println(this.girl+"�վ���");
			}
		}else {
			synchronized (mirror) {//��þ��ӵ���
				System.out.println(this.girl+"�վ���");
				//2���
				try {
					Thread.sleep(1000*2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				synchronized (lipstick) {//��ÿں����
//					System.out.println(this.girl+"Ϳ�ں�");
//				}
			}
			synchronized (lipstick) {//��ÿں����
				System.out.println(this.girl+"Ϳ�ں�");
			}
		}
	}
}
