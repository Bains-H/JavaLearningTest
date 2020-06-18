package com.sxt.io;

/**
 * ʵ�ַŴ����������ķŴ���
 * @author huang b.h
 * @date 2020.06.18 14:11:08 
 */
public class DecorateTest01 {
	public static void main(String[] args) {
		Person person = new Person();
		person.say();
		Amplifier amplifier = new Amplifier(person);
		amplifier.say();
	}
}

interface Say{
	void say();
}

class Person implements Say{
	//����
	private int voice = 10;
	
	public void say() {
		System.out.println("�˵�����Ϊ��"+this.getVoice());
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
	
	public int getVoice() {
		return voice;
	}
	
}

class Amplifier implements Say{
	private Person person;
	
	public Amplifier(Person person) {
		// TODO Auto-generated constructor stub
		this.person = person;
	}
	
	public void say() {
		System.out.println("�˵�����Ϊ��"+ person.getVoice()*100);
		System.out.println("������������");
	}
}