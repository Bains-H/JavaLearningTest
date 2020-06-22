package com.sxt.thread;

/**
 * 静态代理
 * 公共接口
 * 1、真实角色
 * 2、代理角色
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
//真实角色
class You implements Marry{
	@Override
	public void happyMarry() {
		// TODO Auto-generated method stub
		System.out.println("you and 嫦娥终于奔月了...");
	}
}
//代理角色
class WeddingCompany implements Marry{
	//真是角色
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
		System.out.println("布置猪窝......");
	}
	private void after() {
		System.out.println("闹玉兔....");
	}
}
