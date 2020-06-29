package com.sxt.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ӰԺ
 * 
 * @author B.H.Huang
 * @date 2020.06.23 16:39:00 
 *
 */
public class HappyCinema2 {
	public static void main(String[] args) {
		//����λ��
		List<Integer> available = new ArrayList<Integer>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(6);
		available.add(7);
		
		//�˿���Ҫ��λ��
		List<Integer> seats1 = new ArrayList<Integer>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2 = new ArrayList<Integer>();
		seats2.add(4);
		seats2.add(5);
		seats2.add(6);
		
		SxtCinema c = new SxtCinema(available, "happy sxt");
		new Thread(new HappyCustomer(c, seats1),"�ϸ�").start();
		new Thread(new HappyCustomer(c, seats2),"����").start();
	}
}

//�˿�
class HappyCustomer implements Runnable{
	SxtCinema cinema;
	List<Integer> seats;
	
	public HappyCustomer(SxtCinema cinema, List<Integer> seats) {
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

class SxtCinema{
	List<Integer> availabe;//����λ��
	String name;//����
	public SxtCinema(List<Integer> availabe, String name) {
		this.availabe = availabe;
		this.name = name;
	}
	
	//��Ʊ
	public boolean boolTickets(List<Integer> seats) {
		System.out.println("��ӭ����"+this.name+" ��ǰ����λ��Ϊ��"+availabe);
		List<Integer> copy = new ArrayList<Integer>();
		copy.addAll(availabe);
		
		//���
		copy.removeAll(seats);
		//�жϴ�С
		if (availabe.size()-copy.size() != seats.size()) {
			return false;
		}
		//�ɹ�
		availabe = copy;
		
		return true;
	}
}
