package com.sxt.others;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度：Timer TimerTask类
 * 
 * @author B.H.Huang
 * @date 2020.06.28 17:28:26 
 *
 */
public class TinerTest01 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//执行安排
//		timer.schedule(new MyTask(), 1000);//执行任务一次
//		timer.schedule(new MyTask(), 1000, 200);//每隔200毫秒执行一次
		Calendar cal = new GregorianCalendar(2099,12,31,21,53,54);
		timer.schedule(new MyTask(), cal.getTime(), 200);//5秒后开始执行
	}
}
//任务类
class MyTask extends TimerTask{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("放空大脑休息一下");
		}
		System.out.println("-------end-------");
	}
}