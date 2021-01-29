package com.wangzhihao.springboot;

import com.wangzhihao.springboot.common.util.HttpUtil;
import com.wangzhihao.springboot.system.snowflake.SnowFlakeFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @ClassName Test
 * @Description TODO
 * @Author wangzhihao
 * @Date 2020/1/19 14:17
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        HttpUtil httpUtil = new HttpUtil();
        String text="分流通知";
        String desp="购票成功";
        httpUtil.doGetParam(text,desp);

    }
}