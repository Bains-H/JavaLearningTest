package com.sxt.others;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ������ȣ�Timer TimerTask��
 * 
 * @author B.H.Huang
 * @date 2020.06.28 17:28:26 
 *
 */
public class TinerTest01 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//ִ�а���
//		timer.schedule(new MyTask(), 1000);//ִ������һ��
//		timer.schedule(new MyTask(), 1000, 200);//ÿ��200����ִ��һ��
		Calendar cal = new GregorianCalendar(2099,12,31,21,53,54);
		timer.schedule(new MyTask(), cal.getTime(), 200);//5���ʼִ��
	}
}
//������
class MyTask extends TimerTask{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("�ſմ�����Ϣһ��");
		}
		System.out.println("-------end-------");
	}
}