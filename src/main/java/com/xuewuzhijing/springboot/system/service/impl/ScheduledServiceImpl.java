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
    /**
     *@Author wangzhihao
     *@Description cron表达式
     *              second,minute,hour,day of month,month,day of week.
     *              【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
     *              【0 15 10 ? * 1-6】 每个月的周一到周六10：15分执行一次
     *              【0 0 2 ? * 6L】 每个月的最后一个周六凌晨2点执行一次
     *              【0 0 2-4 ? * 1#1】 每个月的第一个周一2点到4点，每个整点都执行一次
     *@Date 21:27 19/12/16
     *@Param []
     *@return void
     **/
//    @Scheduled(cron = "* * * * * MON-FRI")  /**任意时刻**/
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI")  /**枚举**/
//    @Scheduled(cron = "0-4 * * * * MON-FRI")   /**区间**/
//    @Scheduled(cron = "0/4 * * * * MON-FRI")  /**步长 每4秒一次**/
    @Override
    public void print() {
        System.out.println("我是定时任务哦耶  "+System.currentTimeMillis());
    }
}
