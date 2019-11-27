package com.wangzhihao.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoads() {
        System.out.println(dataSource.getClass());
        try {
            Connection conn = dataSource.getConnection();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
