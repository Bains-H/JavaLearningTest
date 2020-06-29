package com.sxt.syn;

/**
 * 快乐影院
 * 
 * @author B.H.Huang
 * @date 2020.06.23 16:39:00 
 *
 */
public class HappyCinema {
	public static void main(String[] args) {
		Cinema c = new Cinema(2, "happy sxt");
		new Thread(new Customer(c, 2),"老高").start();
		new Thread(new Customer(c, 1),"老裴").start();
	}
}

//顾客
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
				System.out.println("出票成功"+Thread.currentThread().getName()+"-<位置为："+seats);
			} else {
				System.out.println("出票失败"+Thread.currentThread().getName()+"-<位置不够");
			}
		}
	}
}

class Cinema{
	int availabe;//可用位置
	String name;//名称
	public Cinema(int availabe, String name) {
		super();
		this.availabe = availabe;
		this.name = name;
	}
	
	//购票
	public boolean boolTickets(int seats) {
		System.out.println("可用位置为："+availabe);
		if (seats > availabe) {
			return false;
		}
		availabe -= seats;
		return true;
	}
}
