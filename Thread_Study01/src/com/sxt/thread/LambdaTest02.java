package com.sxt.thread;

/**
 * Lambda推导：加入参数
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
		
		//简化：参数类型可以
		love = (i) ->{
			System.out.println("i like lambda -->"+i);
		};
		love.lambda(50);
		
		//简化：只有一个参数的情况下，括号可以省略
		love = i ->{
			System.out.println("i like lambda -->"+i);
		};
		love.lambda(5);
		
		//简化：只有一行代码的情况下，可以省略花括号
		love = i -> System.out.println("i like lambda -->"+i);
		love.lambda(0);
	}
}

interface ILove{
	void lambda(int i);
}
//外部类
class Love implements ILove{
	@Override
	public void lambda(int i) {
		// TODO Auto-generated method stub
		System.out.println("i like lambda -->"+i);
	}
}
