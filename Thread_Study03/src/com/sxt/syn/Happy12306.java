package com.sxt.syn;

/**
 * ���ֻ�Ʊ
 * 
 * @author B.H.Huang
 * @date 2020.06.23 17:49:26 
 *
 */
public class Happy12306 {
	public static void main(String[] args) {
		Web12306 web12306 = new Web12306(2, "happy sxt");
		new Passenger(web12306,"�ϸ�",2).start();
		new Passenger(web12306,"����",1).start();
	}
}

//�˿�
class Passenger extends Thread{
	int seats;
	
	public Passenger(Runnable target,String name,int seats) {
		super(target,name);
		this.seats = seats;
	}
}

//��Ʊ��
class Web12306 implements Runnable{
	int available;//���õ�λ��
	String name;//����
	public Web12306(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	@Override
	public void run() {
		Passenger p = (Passenger) Thread.currentThread();
		boolean flag = this.bookTickets(p.seats);
		if (flag) {
			System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-<λ��Ϊ��"+p.seats);
		} else {
			System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"-<λ�ò���");
		}
	}
	//��Ʊ
	public synchronized boolean bookTickets(int seats) {
		System.out.println("����λ��Ϊ��"+available);
		if (seats > available) {
			return false;
		}
		available -= seats;
		return true;
	}
}

