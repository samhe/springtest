package com.sam.springtest.conroller;

import com.sam.springtest.config.AppName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    private AppName appName;
    @GetMapping("/")
    public Map<String, String> getAppName() {
        Map<String, String> appDetails = new HashMap<>();
//        AppName appName = new AppName();
        appDetails.put("name", appName.getName());
        appDetails.put("appName", appName.getAppName());
        return appDetails;
    }
}
