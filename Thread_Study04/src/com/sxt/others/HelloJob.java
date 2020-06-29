package com.sxt.others;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 任务调度
 * 
 * @author B.H.Huang
 * @date 2020.06.28 17:28:26 
 *
 */
public class HelloJob implements Job {

    public HelloJob() {
    }

    public void execute(JobExecutionContext context)
        throws JobExecutionException {
    	System.out.println("------start-------");
    	System.out.println("Hello World!-"+new Date());
    	System.out.println("-------end--------");
    }

}
