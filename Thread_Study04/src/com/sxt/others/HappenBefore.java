package com.sxt.others;

/**
 * 指令重排：代码执行顺序与预期不一致
 * 目的：提高性能
 * 
 * @author B.H.Huang
 * @date 2020.06.28 19:41:55 
 *
 */
public class HappenBefore {
	//变量1
	private static int a = 0;
	//变量2
	private static boolean flag = false;
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			a=0;
			flag=false;
			//线程1 更改数据
			Thread t1 = new Thread(()->{
				a = 1;
				flag = true;
			});
			//线程2 读取数据
			Thread t2 = new Thread(()->{
				if (flag) {
					a *= 1;
				}
				//指令重排
				if (a == 0) {
					System.out.println("happen before a ->"+a);
				}
			});
			t1.start();
			t2.start();
		}
	}
}
