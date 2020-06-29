package com.sxt.others;

import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import java.util.Date;

/**
 * quartz学习入门
 * 
 * @author B.H.Huang
 * @date 2020.06.28 17:28:26 
 *
 */
public class QuartzTest {

  public void run() throws Exception {
	//1、创建Scheduler的工厂
    SchedulerFactory sf = new StdSchedulerFactory();
    //2、从工厂中获取调度器
    Scheduler sched = sf.getScheduler();
    //3、创建JobDetail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    //时间
    Date runTime = evenSecondDateAfterNow();
    //4、触发条件
//    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime)
    		.withSchedule(simpleSchedule().withIntervalInSeconds(5).withRepeatCount(10)).build();
    //5、注册任务和触发条件
    sched.scheduleJob(job, trigger);
    //6、启动
    sched.start();

    try {
    	//500秒后停止
    	Thread.sleep(500L * 1000L);
    } catch (Exception e) {
    }
    
    sched.shutdown(true);
  }

  public static void main(String[] args) throws Exception {

    QuartzTest example = new QuartzTest();
    example.run();

  }

}
