package com.sxt.io;

/**
 * ģ�⿧��
 * 1�������������Ҫװ�εĳ�����󣨽ӿڻ�����ࣩ
 * 2�������������Ҫװ�εĶ���
 * 3������װ���ࣺ�����˶Գ�������������Լ�װ���Ź��еķ���
 * 4������װ���ࣺ��װ�εĶ���
 * 
 * @author huang b.h
 * @date 2020.06.18 14:11:08 
 */
public class DecorateTest02 {
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		Drink suger = new Suger(coffee);
		System.out.println(suger.info()+"-->"+suger.cost());
		Drink milk = new Milk(coffee);
		System.out.println(milk.info()+"-->"+milk.cost());
		
		milk = new Milk(suger);
		System.out.println(milk.info()+"-->"+milk.cost());
	}
}

//�������
interface Drink{
	double cost();//����
	String info();//˵��
}

//�������
class Coffee implements Drink{
	private String name = "ԭζ����";

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
//����װ����
abstract class Decorate implements Drink{
	
	//�Գ������������
	private Drink drink;
	public Decorate(Drink drink) {
		this.drink = drink;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost();
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
	
}

//����װ����
class Milk extends Decorate{

	public Milk(Drink drink) {
		// TODO Auto-generated method stub
		super(drink);
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*4;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info() + "������ţ��";
	}
	
}

class Suger extends Decorate{

	public Suger(Drink drink) {
		// TODO Auto-generated method stub
		super(drink);
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*2;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info() + "����������";
	}
	
}
