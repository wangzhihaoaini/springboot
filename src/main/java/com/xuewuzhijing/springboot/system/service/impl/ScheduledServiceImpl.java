package com.xuewuzhijing.springboot.system.service.impl;

import com.xuewuzhijing.springboot.system.service.ScheduledService;
import org.springframework.stereotype.Service;

/**
 * @ClassName ScheduledServiceImpl
 * @Description 定时任务实现类
 * @Author xuewuzhijing
 * @Date 19/11/24 16:57
 * @Version 1.0
 **/
@Service
public class ScheduledServiceImpl implements ScheduledService{
    //cron表达式
    //@Scheduled(cron = "0/5 * * * * MON-SAT")
    @Override
    public void print() {
        System.out.println("我是定时任务哦耶  "+System.currentTimeMillis());
    }
}
