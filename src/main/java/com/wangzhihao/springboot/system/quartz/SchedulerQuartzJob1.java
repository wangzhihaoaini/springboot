package com.wangzhihao.springboot.system.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ClassName SchedulerQuartzJob1
 * @Description TODO
 * @Author wangzhihao
 * @Date 20/5/20 22:15
 * @Version 1.0
 **/
public class SchedulerQuartzJob1 implements Job{
    private void before(){
        System.out.println("任务开始执行");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        before();
        System.out.println("开始提数");
        after();
    }

    private void after(){
        System.out.println("任务开始执行");
    }
}
