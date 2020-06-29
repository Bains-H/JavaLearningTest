package com.sxt.cooperation;

/**
 * Э��ģ�ͣ�������������ʵ�ַ�ʽһ���̷ܳ�
 * ����������
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

//������
class Productor extends Thread{
	SynContainer container;
	public Productor(SynContainer container) {
		this.container = container;
	}
	public void run() {
		//��ʼ����
		for (int i = 0; i < 100; i++) {
			System.out.println("������"+i+"����ͷ");
			container.push(new Steamedbun(i));
		}
	}
}
//������
class Consumer extends Thread{
	SynContainer container;
	public Consumer(SynContainer container) {
		this.container = container;
	}
	public void run() {
		//����
		for(int i=0;i<1000;i--) {
			System.out.println("���ѵ�"+container.pop().id+"����ͷ");
		}
	}
}
//������
class SynContainer{
	Steamedbun[] buns = new Steamedbun[10];//�洢����
	int count = 0;//������
	//�洢 ����
	public synchronized void push(Steamedbun bun) {
		//���������� �������ڿռ�
		if (count == buns.length) {
			try {
				this.wait();//�߳����������ڿռ���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//���ڿռ� ��������
		buns[count] = bun;
		count++;
		this.notifyAll();
	}
	//��ȡ ����
	public synchronized Steamedbun pop() {
		//��ʱ���� �������Ƿ��������
		//û������ ֻ�еȴ�
		if (count == 0) {
			try {
				this.wait();//�߳�������������֪ͨ���ѽ������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//�������ݿ�������
		count --;
		Steamedbun bun = buns[count];
		this.notifyAll();//���ڿռ䣬֪ͨ����
		return bun;
	}
}
//��ͷ
class Steamedbun{
	int id;
	public Steamedbun(int id) {
		this.id = id;
	}
}
