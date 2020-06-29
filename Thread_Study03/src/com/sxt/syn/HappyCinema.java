package com.sxt.syn;

/**
 * ����ӰԺ
 * 
 * @author B.H.Huang
 * @date 2020.06.23 16:39:00 
 *
 */
public class HappyCinema {
	public static void main(String[] args) {
		Cinema c = new Cinema(2, "happy sxt");
		new Thread(new Customer(c, 2),"�ϸ�").start();
		new Thread(new Customer(c, 1),"����").start();
	}
}

//�˿�
class Customer implements Runnable{
	Cinema cinema;
	int seats;
	
	public Customer(Cinema cinema, int seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (cinema) {
			boolean flag = cinema.boolTickets(seats);
			if (flag) {
				System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-<λ��Ϊ��"+seats);
			} else {
				System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"-<λ�ò���");
			}
		}
	}
}

class Cinema{
	int availabe;//����λ��
	String name;//����
	public Cinema(int availabe, String name) {
		super();
		this.availabe = availabe;
		this.name = name;
	}
	
	//��Ʊ
	public boolean boolTickets(int seats) {
		System.out.println("����λ��Ϊ��"+availabe);
		if (seats > availabe) {
			return false;
		}
		availabe -= seats;
		return true;
	}
}
