package com.sxt.cooperation;

/**
 * Э��ģ�ͣ�������������ʵ�ַ�ʽ�����źŵƷ�
 * ������־λ
 * 
 * @author B.H.Huang
 * @date 2020.06.28 16:38:36 
 *
 */
public class CoTest01 {
	public static void main(String[] args) {
		Tv tv = new Tv();
		Player player = new Player(tv);
		Watcher watcher = new Watcher(tv);
		new Thread(player).start();
		new Thread(watcher).start();
		
	}
}
//������ ��Ա
class Player extends Thread{
	Tv tv;
	public Player(Tv tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			if (i%2==0) {
				this.tv.play("����˵");
			} else {
				this.tv.play("̫���ˣ���ƽ����ϴϴ��");
			}
		}
	}
}
//������ ����
class Watcher extends Thread{
	Tv tv;
	public Watcher(Tv tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			tv.watch();
		}
	}
}
//ͬһ����Դ ����
class Tv{
	String voice;
	//�źŵ�
	//T ��ʾ��Ա���� ���ڵȴ�
	//F ��ʾ���ڹۿ� ��Ա�ȴ�
	boolean flag = true;
	
	//����
	public synchronized void play(String voice) {
		//��Ա�ȴ�
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//����
		System.out.println("�����ˣ�"+voice);
		this.voice = voice;
		//����
		this.notifyAll();
		this.flag = !this.flag;
	}
	//�ۿ�
	public synchronized void watch() {
		//���ڵȴ�
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�ۿ�
		System.out.println("�����ˣ�"+voice);
		//����
		this.notifyAll();
		//�л���־λ
		this.flag = !this.flag;
	}
}