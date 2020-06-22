package com.sxt.thread;

/**
 * Lambda�Ƶ���������+����ֵ
 * 
 * @author B.H.Huang
 * @date 2020.06.22 22:16:37 
 *
 */
public class LambdaTest03 {

	public static void main(String[] args) {
		IInterest interest = (i,j)->i+j;
		System.out.println("i like lambde -->"+interest.lambda(100, 200));
	}
		
}

interface IInterest{
	int lambda(int i,int j);
}

//�ⲿ��
class Intersest implements IInterest{
	@Override
	public int lambda(int i, int j) {
		System.out.println("i like lambde -->"+(i+j));
		return i+j;
	}
}
