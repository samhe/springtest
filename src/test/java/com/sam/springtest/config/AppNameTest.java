package com.sam.springtest.config;

import com.sam.springtest.conroller.IndexController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppNameTest {
    @Autowired
    private IndexController indexController;
    @Autowired
    private AppName appName;

    @Test
    public void whenAppStart_shouldGetTheIndexProperly() {
        String expectedAppName = "appname-in-test-yml";
        String expectedName = "name-in-test-yml";
        Map<String, String> appNameReqRes = indexController.getAppName();
        Assertions.assertThat(appNameReqRes.get("appName")).isEqualTo(expectedAppName);
        Assertions.assertThat(appNameReqRes.get("name")).isEqualTo(expectedName);
    }

    @Test
    public void whenAppNameSetInTest_shouldGetTheProperName() {
        String expectName = "name-in-test-yml";
        Assertions.assertThat(appName.getName()).isEqualTo(expectName);
    }

}
