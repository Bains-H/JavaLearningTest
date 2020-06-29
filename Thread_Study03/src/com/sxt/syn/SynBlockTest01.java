package com.sxt.syn;

/**
 * synchronized
 * 1��ͬ������
 * 2��ͬ���飬Ŀ�����ȷ
 * 
 * @author B.H.Huang
 * @date 2020.06.23 15:34:47 
 *
 */
public class SynBlockTest01 {
	public static void main(String[] args) {
		//�˻�
		SynAccount account = new SynAccount(1000,"������");
		SynDrawing you = new SynDrawing(account, 80, "�ɱ�����");
		SynDrawing wife = new SynDrawing(account, 90, "happy����");
		you.start();
		wife.start();
		
	}
}
//�˻�
class SynAccount{
	int money;//���
	String name;//����
	public SynAccount(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
}

class SynDrawing extends Thread{
	SynAccount account;//ȡǮ���˻�
	int drawingMoney;//ȡ��Ǯ��
	int packetTotal;//�ڴ���Ǯ
	
	public SynDrawing(SynAccount account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}
	
	//Ŀ������account
	public synchronized void test() {
		//������ܴ���
		if (account.money <= 0) {
			return;
		}
		//ͬ����
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
			System.out.println(this.getName()+"-->�˻����Ϊ��"+account.money);
			System.out.println(this.getName()+"-->�ڴ���ǮΪ��"+packetTotal);
		}
	}
}
