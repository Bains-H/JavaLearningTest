package com.sxt.thread;

/**
 * Lambda�Ƶ����������
 * 
 * @author B.H.Huang
 * @date 2020.06.22 22:16:37 
 *
 */
public class LambdaTest02 {

	public static void main(String[] args) {
		ILove love = (int i) ->{
			System.out.println("i like lambda -->"+i);
		};
		love.lambda(100);
		
		//�򻯣��������Ϳ���
		love = (i) ->{
			System.out.println("i like lambda -->"+i);
		};
		love.lambda(50);
		
		//�򻯣�ֻ��һ������������£����ſ���ʡ��
		love = i ->{
			System.out.println("i like lambda -->"+i);
		};
		love.lambda(5);
		
		//�򻯣�ֻ��һ�д��������£�����ʡ�Ի�����
		love = i -> System.out.println("i like lambda -->"+i);
		love.lambda(0);
	}
}

interface ILove{
	void lambda(int i);
}
//�ⲿ��
class Love implements ILove{
	@Override
	public void lambda(int i) {
		// TODO Auto-generated method stub
		System.out.println("i like lambda -->"+i);
	}
}
