package com.sxt.syn;

/**
 * synchronized
 * 1、同步方法
 * 2、同步块，目标更明确
 * 
 * @author B.H.Huang
 * @date 2020.06.23 15:34:47 
 *
 */
public class SynBlockTest01 {
	public static void main(String[] args) {
		//账户
		SynAccount account = new SynAccount(1000,"结婚礼金");
		SynDrawing you = new SynDrawing(account, 80, "可悲的你");
		SynDrawing wife = new SynDrawing(account, 90, "happy的她");
		you.start();
		wife.start();
		
	}
}
//账户
class SynAccount{
	int money;//金额
	String name;//名称
	public SynAccount(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
}

class SynDrawing extends Thread{
	SynAccount account;//取钱的账户
	int drawingMoney;//取的钱数
	int packetTotal;//口袋的钱
	
	public SynDrawing(SynAccount account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}
	
	//目标锁定account
	public synchronized void test() {
		//提高性能代码
		if (account.money <= 0) {
			return;
		}
		//同步块
		synchronized (account) {
			if (account.money-drawingMoney<0) {
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account.money -= drawingMoney;
			packetTotal += drawingMoney;
			System.out.println(this.getName()+"-->账户余额为："+account.money);
			System.out.println(this.getName()+"-->口袋的钱为："+packetTotal);
		}
	}
}
