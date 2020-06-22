package com.sxt.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ģ���������
 * 
 * @author B.H.Huang
 * @date 2020.06.22 19:15:10 
 *
 */
public class CRacer implements Callable<Integer>{
	private static String winner;//ʤ����
	@Override
	public Integer call() throws Exception{
		for (int steps = 1; steps <= 100; steps++) {
			System.out.println(Thread.currentThread().getName()+"--->"+steps);
			//ģ����Ϣ
			if (Thread.currentThread().getName().equals("pool-1-thread-1")&&steps%10==0) {
				Thread.sleep(100);
			}
			//�����Ƿ����
			boolean flag = gameOver(steps);
			if (flag) {
				return steps;
			}
		}
		return null;
	}
	private boolean gameOver(int steps) {
		if (winner!=null) {//����ʤ����
			return true;
		} else {
			if (steps == 100) {
				winner = Thread.currentThread().getName();
				System.out.println("winner ==> "+winner);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CRacer racer = new CRacer();
		//����ִ�з���
		ExecutorService ser = Executors.newFixedThreadPool(2);
		//�ύִ��
		Future<Integer> result1 = ser.submit(racer);
		Future<Integer> result2 = ser.submit(racer);
		//��ȡ�����
		Integer r1 = result1.get();
		Integer r2 = result2.get();
		System.out.println(r1+"--->"+r2);
		//�رշ���
		ser.shutdownNow();
	}
}
