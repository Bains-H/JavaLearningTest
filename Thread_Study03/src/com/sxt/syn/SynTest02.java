package com.sxt.syn;

/**
 * �̲߳���ȫ��ȡǮ
 * 
 * @author B.H.Huang
 * @date 2020.06.23 15:34:47 
 *
 */
public class SynTest02 {
	public static void main(String[] args) {
		//�˻�
		SafeAccount account = new SafeAccount(100,"������");
		SafeDrawing you = new SafeDrawing(account, 80, "�ɱ�����");
		SafeDrawing wife = new SafeDrawing(account, 90, "happy����");
		you.start();
		wife.start();
		
	}
}
//�˻�
class SafeAccount{
	int money;//���
	String name;//����
	public SafeAccount(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
}

class SafeDrawing extends Thread{
	SafeAccount account;//ȡǮ���˻�
	int drawingMoney;//ȡ��Ǯ��
	int packetTotal;//�ڴ���Ǯ
	
	public SafeDrawing(SafeAccount account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}
	
	//Ŀ�겻������ʧ�� ���ﲻ����this Ӧ������account
	public synchronized void test() {
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
