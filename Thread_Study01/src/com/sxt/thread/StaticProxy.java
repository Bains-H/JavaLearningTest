package com.sxt.thread;

/**
 * ��̬����
 * �����ӿ�
 * 1����ʵ��ɫ
 * 2�������ɫ
 * 
 * @author B.H.Huang
 * @date 2020.06.22 19:46:12 
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
	}
}

interface Marry{
	void happyMarry();
}
//��ʵ��ɫ
class You implements Marry{
	@Override
	public void happyMarry() {
		// TODO Auto-generated method stub
		System.out.println("you and �϶����ڱ�����...");
	}
}
//�����ɫ
class WeddingCompany implements Marry{
	//���ǽ�ɫ
	private Marry taget;
	public WeddingCompany(Marry taget) {
		this.taget = taget;
	}
	@Override
	public void happyMarry() {
		ready();
		this.taget.happyMarry();
		after();
	}
	
	private void ready() {
		System.out.println("��������......");
	}
	private void after() {
		System.out.println("������....");
	}
}
