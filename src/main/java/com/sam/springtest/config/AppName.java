package com.sam.springtest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppName {
    @Value("${sam.name}")
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Value("${sam.app-name:app-name-defualt}")
    private String appName;

    public String getName() {
        return name;
    }

    public String getAppName() {
        return appName;
    }
}
