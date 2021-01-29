package com.wangzhihao.springboot.system.config;

import com.wangzhihao.springboot.system.snowflake.SnowFlakeFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName IDGenderConfig
 * @Description TODO
 * @Author wangzhihao
 * @Date 21/1/21 0021 10:41
 * @Version 1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "snowflake")
public class IDGenderConfig {
    //数据中心[0,31] 配置文件中不配置就是0
    private long datacenterId;

    //机器标识[0,31] 配置文件中不配置就是0
    private long machineId;

    @Bean
    public SnowFlakeFactory getSnowFlakeFactory() {
        SnowFlakeFactory snowFlakeFactory = new SnowFlakeFactory(datacenterId,machineId);
        return snowFlakeFactory;
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public void setDatacenterId(long datacenterId) {
        this.datacenterId = datacenterId;
    }

    public long getMachineId() {
        return machineId;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }
}
