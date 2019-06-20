package com.sam.springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
//@PropertySource({ "application-test.yml" })
@ContextConfiguration(classes = { SpringtestApplicationTests.class })
@TestPropertySource(properties = { "spring.config.location=classpath:application-test.yml" })
public class SpringtestApplicationTests {

    @Test
    public void contextLoads() {
    }

}
